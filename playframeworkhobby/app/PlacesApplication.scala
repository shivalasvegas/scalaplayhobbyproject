import models.Place
import reactivemongo.api.bson.{BSONDocument, BSONDocumentWriter, Macros}
import reactivemongo.api.{AsyncDriver, DB, MongoConnection}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.commands.WriteResult

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

  // Get this value from webpage
  val place = new Place( 4, "Lulworth Cove", "Jewel of the Dorset coast.")

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]

//  def create(place: Place): Future[Unit] = collection.flatMap(_.insert.one(place).map(_ => {}))
//
//  PlacesApplication.create(place)

  println("Waiting ...")
  def simpleCreate(collection: BSONCollection): Future[Unit] = Future {
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
    case Success(collection: BSONCollection) => PlacesApplication.simpleCreate(collection)
    case Failure(failureMessage) => println(failureMessage)
  }

}
