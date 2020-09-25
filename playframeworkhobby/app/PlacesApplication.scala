import models.Place
import reactivemongo.api.bson.{BSONDocumentWriter, Macros}
import reactivemongo.api.{AsyncDriver, DB, MongoConnection}
import reactivemongo.api.bson.collection.BSONCollection

import scala.concurrent.{ExecutionContext, Future}


object PlacesApplication {

  val mongoUri = "mongodb://localhost:27017"

  import ExecutionContext.Implicits.global

  val driver = AsyncDriver()
  val parsedUri = MongoConnection.fromString(mongoUri)

  val futureConnection = parsedUri.flatMap(driver.connect(_))

  def db: Future[DB] = futureConnection.flatMap(_.database("placesdb"))

  def placesCollection: Future[BSONCollection] = db.map(_.collection("places"))

  implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]

  def createPerson(place: Place): Future[Unit] =
    placesCollection.flatMap(_.insert.one(place).map(_ => {}))


}
