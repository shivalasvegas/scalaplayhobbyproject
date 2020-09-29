package daos

import java.util.UUID

import javax.inject.Inject
import models.{Place, PlaceData}
import play.api.Configuration
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number, optional}
import play.mvc.Controller
import reactivemongo.api.bson.collection.BSONCollection

import scala.concurrent.{ExecutionContext, Future}

class PlaceDAO {

  //def getCollection(collection: BSONCollection): Unit = println("Got collection")
  def create(placeData: PlaceData): Unit = {
    val place = Place(PlaceDAO.generateID, placeData.name, placeData.description)
    collection.flatMap(_.insert.one(place).map(_ => {}))
  }

}

object PlaceDAO {

  private var placeID: Int = 0
  def generateID: Int = {
    placeID += 1
    placeID
  }

  val createPlaceForm = Form(
    mapping(
      "_id" -> optional(number),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(PlaceData.apply)(PlaceData.unapply)
  )
}