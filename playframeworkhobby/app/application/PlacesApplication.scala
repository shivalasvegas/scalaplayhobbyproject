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

  val driver = new reactivemongo.api.AsyncDriver

  val connection: Future[MongoConnection] = driver.connect(List("localhost"))

  val parsedUri = MongoConnection.fromString(mongoUri)

  println("Connecting to database ...")
  val futureConnection = parsedUri.flatMap(driver.connect(_))

  def db1: Future[DB] = futureConnection.flatMap(_.database("placesdb"))

  db1 onComplete {
    case Success(successMessage) => println(s"Connected to $successMessage")
    case Failure(failureMessage) => println(failureMessage)
  }

  def collectionPlace: Future[BSONCollection] = db1.map(_.collection("place"))
  def collectionDoc: Future[BSONCollection] = db1.map(_.collection("placedoc"))

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]
  implicit def placesDocWriter: BSONDocumentWriter[PlaceDocument] = Macros.writer[PlaceDocument]
  implicit def placesReader: BSONDocumentReader[Place] = Macros.reader[Place]
  // Get this value from webpage
//  val placeDocument = new PlaceDocument(22, "West Lulworth", "Gateway to the fossil Forest")
//
//  println("Waiting ...")
//
//  def createWithCollectionDoc(collection: BSONCollection, placeDocument: PlaceDocument): Future[Unit] = Future {
//    println(s"Database connection established ... $placeDocument")
//
//    val writeRes: Future[WriteResult] = collection.insert.one(placeDocument)
//
//    writeRes.onComplete {
//      case Failure(e) => e.printStackTrace()
//      case Success(writeResult) =>
//        println(s"successfully inserted document with result: $writeResult")
//    }
//
//    writeRes.map(_ => {})
//  }
//
//  collectionDoc onComplete {
//    case Success(collectionDoc: BSONCollection) =>
//      PlacesApplication.createWithCollectionDoc(collectionDoc, placeDocument)
//    case Failure(failureMessage) => println(failureMessage)
//  }



//    def createPlaceWithForm(place: Place): Future[Unit] =  Future {
//      println(s"Creating document ... $place ")
//      def createWithCollection(collection: BSONCollection, place: Place): Future[Unit] = Future {
//        println(s"Database connection established ... $place")
//
//        val writeRes: Future[WriteResult] = collection.insert.one(place)
//
//        writeRes.onComplete {
//          case Failure(e) => e.printStackTrace()
//          case Success(writeResult) =>
//            println(s"successfully inserted document with result: $writeResult")
//        }
//
//        writeRes.map(_ => {})
//
//      }
//
////      collectionPlace onComplete {
////        case Success(collection: BSONCollection) =>
////          createWithCollection(collection, place)
////        case Failure(failureMessage) => println(failureMessage)
////      }
////
//    }

  def createPlaceWithForm(place: Place): Future[Unit] =  {

    println(s"Mapping the data ... $place ")
    val writeRes: Future[WriteResult] = collectionPlace.flatMap(_.insert.one(place))
    println("Future written ...")

    writeRes.onComplete {
            case Failure(failureMessage) => println(failureMessage)
            case Success(writeResult) =>
              println(s"successfully inserted document from post with result: $writeResult")
          }
          writeRes.map(_ => {})
  }
  collectionPlace onComplete {
    case Success(collectionPlace: BSONCollection) => println(s"Collection $collectionPlace ... created")
    case Failure(failureMessage) => println(failureMessage)
     }
//  def createPlaceWithForm(place: Place): Future[Unit] =  Future {
//
//    println(s"Mapping the data ... $place ")
//    val writeRes: Future[WriteResult] = collection.insert.one(place)
//    val isComplete = writeRes.isCompleted
//    if (isComplete) println("Inserted document") else println("Oh snap!")
//    writeRes.onComplete {
//      case Failure(e) => e.printStackTrace()
//      case Success(writeResult) =>
//        println(s"successfully inserted document from post with result: $writeResult")
//    }
//    writeRes.map(_ => {})
//
//
//  }



}
