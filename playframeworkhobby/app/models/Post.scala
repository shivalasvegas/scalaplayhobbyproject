package models

import play.api.libs.json.{Json, OFormat}
import reactivemongo.api.bson.BSONObjectID

case class Post(_id: Int, title: String, description: String)

object Post {
  implicit val formatter = Json.format[Post]
}
