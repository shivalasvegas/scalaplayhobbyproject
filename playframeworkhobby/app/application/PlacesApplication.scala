package application

import daos.{PlaceDAO, PlaceDocumentDAO}
import models.{Place, PlaceDocument}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.bson.{BSONDocumentReader, BSONDocumentWriter, Macros}
import reactivemongo.api.commands.WriteResult
import reactivemongo.api._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object PlacesApplication extends App {

  val mongoUri = "mongodb://localhost:27017"

  import ExecutionContext.Implicits.global

  val driver = AsyncDriver()
  val parsedUri = MongoConnection.fromString(mongoUri)

  println("Connecting to database ...")
  val futureConnection = parsedUri.flatMap(driver.connect(_))

  def db1: Future[DB] = futureConnection.flatMap(_.database("placesdb"))

  db1 onComplete {
    case Success(successMessage) => println(s"Connected to $successMessage")
    case Failure(failureMessage) => println(failureMessage)
  }

  def collection: Future[BSONCollection] = db1.map(_.collection("place"))
  def collectionDoc: Future[BSONCollection] = db1.map(_.collection("placedoc"))

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]
  implicit def placesDocWriter: BSONDocumentWriter[PlaceDocument] = Macros.writer[PlaceDocument]
  implicit def placesReader: BSONDocumentReader[Place] = Macros.reader[Place]
  // Get this value from webpage
  val placeDocument = new PlaceDocument(PlaceDocumentDAO.generateID, "West Lulworth", "Gateway to the fossil Forest")

  println("Waiting ...")

  def createWithCollection(collection: BSONCollection, placeDocument: PlaceDocument): Future[Unit] = Future {
    println(s"Database connection established ... $placeDocument")

    val writeRes: Future[WriteResult] = collection.insert.one(placeDocument)

    writeRes.onComplete {
      case Failure(e) => e.printStackTrace()
      case Success(writeResult) =>
        println(s"successfully inserted document with result: $writeResult")
    }

    writeRes.map(_ => {})
  }

  collectionDoc onComplete {
    case Success(collectionDoc: BSONCollection) =>
      PlacesApplication.createWithCollection(collectionDoc, placeDocument)
    case Failure(failureMessage) => println(failureMessage)
  }

  def createPlaceWithForm(place: Place): Future[Unit] =  Future {
    println(s"Mapping the data ... $place ")
    val writeRes = collection.map(_.insert.one(place))
    val isComplete = writeRes.isCompleted
    if (isComplete) println("Inserted document") else println("Oh snap!")
    writeRes.onComplete {
      case Failure(e) => e.printStackTrace()
      case Success(writeResult) =>
        println(s"successfully inserted document from post with result: $writeResult")
    }
    writeRes.map(_ => {})
  }

}
