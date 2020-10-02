package application

import models.{Place}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.bson.{BSONDocumentReader, BSONDocumentWriter, Macros}
import reactivemongo.api.commands.WriteResult
import reactivemongo.api._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object PlacesApplication {

  import ExecutionContext.Implicits.global

  val mongoUri = "mongodb://localhost:27017/placesdb"

  val driver = new reactivemongo.api.AsyncDriver
  println("Connecting to database ...")
  val db1 = for {
    uri <- MongoConnection.fromString(mongoUri)
    con <- driver.connect(uri)
    dn <- Future(uri.db.get)
    db <- con.database(dn)
  } yield db

  db1.onComplete {
    case Success(successMessage) => println(s"Connected to $successMessage")
    case Failure(failureMessage) => println(failureMessage)

  }

  def collectionPlace: Future[BSONCollection] = db1.map(_.collection("place"))

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]
  implicit def placesReader: BSONDocumentReader[Place] = Macros.reader[Place]

  def createPlaceWithForm(place: Place): Future[Unit] =  {

    val writeRes: Future[WriteResult] = collectionPlace.flatMap(_.insert.one(place))
    writeRes.onComplete {
            case Failure(failureMessage) => println(failureMessage)
            case Success(writeResult) =>
              println(s"successfully inserted document from post with result: $writeResult")
          }
          writeRes.map(_ => {})
  }

}
