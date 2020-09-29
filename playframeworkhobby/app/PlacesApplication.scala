
import models.{Place, PlaceData}
import daos.PlaceDAO
import reactivemongo.api.bson.{BSONDocument, BSONDocumentWriter, Macros}
import reactivemongo.api.{AsyncDriver, Cursor, DB, MongoConnection, ReadPreference}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.commands.WriteResult

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


object PlacesApplication extends App{

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

  def list(limit: Int = 100): Future[Seq[Post]] = {
    collection.flatMap(
      _.find(BSONDocument)
        .cursor[Post](ReadPreference.primary)
        .collect[Seq](limit, Cursor.FailOnError[Seq[Post]]()))
  }

  // Get this value from webpage
  val place = new Place( 7, "Clovelly", "A wish away from the past.")

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]

  println("Waiting ...")
  def createWithCollection(collection: BSONCollection): Future[Unit] = Future {
    println("Database connection established")

    val writeRes: Future[WriteResult] = collection.insert.one(place)

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

//  def createWithPlace(placeFromPage: Place): Future[Unit] =  Future {
//
//  }
}
