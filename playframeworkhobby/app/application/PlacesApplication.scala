package application

import daos.{PlaceDAO, PlaceDocumentDAO}
import models.{Place, PlaceData, PlaceDocument}
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.bson.{BSONDocumentReader, BSONDocumentWriter, BSONObjectID, Macros}
import reactivemongo.api.commands.WriteResult
import reactivemongo.api._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object PlacesApplication extends App {

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
//    case resolution => println(s"DB resolution ... $resolution")
//      driver.close()
  }

  def collectionPlace: Future[BSONCollection] = db1.map(_.collection("place"))
  def collectionDoc: Future[BSONCollection] = db1.map(_.collection("placedoc"))

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]
  implicit def placesDocWriter: BSONDocumentWriter[PlaceDocument] = Macros.writer[PlaceDocument]
  implicit def placesReader: BSONDocumentReader[Place] = Macros.reader[Place]

  def create(placeData: PlaceData): Future[WriteResult] = {
    val place = Place(BSONObjectID.generate().stringify, placeData.name, placeData.description)

    for {
      places <- collectionPlace
      writeResult <- places.insert.one(place)
    } yield writeResult

  }
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

//  def createPlaceWithForm(place: Place): Future[Unit] =  {
//
//    println(s"Mapping the data ... $place ")
//    val writeRes: Future[WriteResult] = collectionPlace.flatMap(_.insert.one(place))
//    println("Future written ...")
//
//    writeRes.onComplete {
//            case Failure(failureMessage) => println(failureMessage)
//            case Success(writeResult) =>
//              println(s"successfully inserted document from post with result: $writeResult")
//          }
//          writeRes.map(_ => {})
//  }
//  collectionPlace onComplete {
//    case Success(collectionPlace: BSONCollection) => println(s"Collection $collectionPlace ... created")
//    case Failure(failureMessage) => println(failureMessage)
//     }
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
