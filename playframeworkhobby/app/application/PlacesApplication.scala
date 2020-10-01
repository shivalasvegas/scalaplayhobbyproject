package application

import controllers.PlaceDAO
import models.{Place, PlaceDocument, Post, PostData}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter, Macros}
import reactivemongo.api.commands.WriteResult
import reactivemongo.api._
import reactivemongo.play.json.compat
import play.api.data._
import play.api.data.Forms._

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
  def collectionCounters: Future[BSONCollection] = db1.map(_.collection("counters"))

  def collectionPosts: Future[BSONCollection] = db1.map(_.collection("posts"))

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]
  implicit def placesDocWriter: BSONDocumentWriter[PlaceDocument] = Macros.writer[PlaceDocument]

  implicit def postsWriter: BSONDocumentWriter[Post] = Macros.writer[Post]

  implicit def postsReader: BSONDocumentReader[Post] = Macros.reader[Post]
  def getNextId(idName: String): Unit = {
    var mod = collectionCounters.map(counters => counters.findAndModify(
      {
        query : {id : idName},

      }
    )

    )
  }
  // Get this value from webpage
  val placeDocument = new PlaceDocument(PlaceDAO.generateID, "West Lulworth", "Gateway to the fossil Forest")

  println("Waiting ...")

  def createWithCollection(collection: BSONCollection): Future[Unit] = Future {
    println("Database connection established")

    val writeRes: Future[WriteResult] = collection.insert.one(placeDocument)

    writeRes.onComplete {
      case Failure(e) => e.printStackTrace()
      case Success(writeResult) =>
        println(s"successfully inserted document with result: $writeResult")
    }

    writeRes.map(_ => {})
  }

  collection onComplete {
    case Success(collection: BSONCollection) => PlacesApplication.createWithCollection(collection)
    case Failure(failureMessage) => println(failureMessage)
  }

  def createPostWithForm(post: Post): Future[Unit] =  Future {
    val writeRes = collectionPosts.map(_.insert.one(post))
    writeRes.onComplete {
      case Failure(e) => e.printStackTrace()
      case Success(writeResult) =>
        println(s"successfully inserted document from post with result: $writeResult")
    }
    writeRes.map(_ => {})
  }

  def createPlaceWithForm(place: Place): Future[Unit] =  Future {
    val writeRes = collectionPosts.map(_.insert.one(place))
    writeRes.onComplete {
      case Failure(e) => e.printStackTrace()
      case Success(writeResult) =>
        println(s"successfully inserted document from post with result: $writeResult")
    }
    writeRes.map(_ => {})
  }

}
