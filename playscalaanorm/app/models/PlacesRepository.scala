package models

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

case class Place(id: Option[Long] = None,
                    name: String,
                    introduced: Option[Date],
                    discontinued: Option[Date],
                    placeInfoId: Option[Long])

object Place {
  implicit def toParameters: ToParameterList[Place] =
    Macro.toParameters[Place]
}

/**
 * Helper for pagination.
 */
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}


@javax.inject.Singleton
class PlacesRepository @Inject()(dbapi: DBApi, placeInfoRepository: PlaceInfoRepository)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  // -- Parsers

  /**
   * Parse a Place from a ResultSet
   */
  private val simple = {
    get[Option[Long]]("place.id") ~
      get[String]("place.name") ~
      get[Option[Date]]("place.introduced") ~
      get[Option[Date]]("place.discontinued") ~
      get[Option[Long]]("place.placeInfo_id") map {
      case id ~ name ~ introduced ~ discontinued ~ placeInfoId =>
        Place(id, name, introduced, discontinued, placeInfoId)
    }
  }

  /**
   * Parse a (Place,PlaceInfo) from a ResultSet
   */
  private val withPlaceInfo = simple ~ (placeInfoRepository.simple.?) map {
    case place ~ placeInfo => place -> placeInfo
  }

  // -- Queries

  /**
   * Retrieve a place from the id.
   */
  def findById(id: Long): Future[Option[Place]] = Future {
    db.withConnection { implicit connection =>
      SQL"select * from place where id = $id".as(simple.singleOpt)
    }
  }(ec)

  /**
   * Return a page of (Place,PlaceInfo).
   *
   * @param page Page to display
   * @param pageSize Number of computers per page
   * @param orderBy Computer property used for sorting
   * @param filter Filter applied on the name column
   */
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[(Place, Option[PlaceInfo])]] = Future {

    val offset = pageSize * page

    db.withConnection { implicit connection =>

      val places = SQL"""
        select * from place
        left join placeInfo on place.placeInfo_id = placeInfo.id
        where place.name like ${filter}
        order by ${orderBy} nulls last
        limit ${pageSize} offset ${offset}
      """.as(withPlaceInfo.*)

      val totalRows = SQL"""
        select count(*) from place
        left join placeInfo on place.placeInfo_id = placeInfo.id
        where place.name like ${filter}
      """.as(scalar[Long].single)

      Page(places, page, offset, totalRows)
    }
  }(ec)

  /**
   * Update a computer.
   *
   * @param id The computer id
   * @param place The computer values.
   */
  def update(id: Long, place: Place) = Future {
    db.withConnection { implicit connection =>
      SQL("""
        update place set name = {name}, introduced = {introduced},
          discontinued = {discontinued}, placeInfo_id = {placeInfoId}
        where id = {id}
      """).bind(place.copy(id = Some(id)/* ensure */)).executeUpdate()
      // case class binding using ToParameterList,
      // note using SQL(..) but not SQL.. interpolation
    }
  }(ec)

  /**
   * Insert a new computer.
   *
   * @param place The computer values.
   */
  def insert(place: Place): Future[Option[Long]] = Future {
    db.withConnection { implicit connection =>
      SQL("""
        insert into place values (
          (select next value for place_seq),
          {name}, {introduced}, {discontinued}, {placeInfoId}
        )
      """).bind(place).executeInsert()
    }
  }(ec)

  /**
   * Delete a place.
   *
   * @param id Id of the place to delete.
   */
  def delete(id: Long) = Future {
    db.withConnection { implicit connection =>
      SQL"delete from place where id = ${id}".executeUpdate()
    }
  }(ec)

}
