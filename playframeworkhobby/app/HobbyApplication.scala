import reactivemongo.api.{AsyncDriver, DB, MongoConnection}
import reactivemongo.api.bson.collection.BSONCollection

import scala.concurrent.{ExecutionContext, Future}


object HobbyApplication {

  val mongoUri = "mongodb://localhost:27017"

  import ExecutionContext.Implicits.global

  val driver = AsyncDriver()
  val parsedUri = MongoConnection.fromString(mongoUri)
  
  val futureConnection = parsedUri.flatMap(driver.connect(_))

  def db: Future[DB] = futureConnection.flatMap(_.database("hobbyprojectdb"))
  def placeCollection: Future[BSONCollection] = db.map(_.collection("places"))

}
