package models

import reactivemongo.api.bson.BSONObjectID

case class Post(_id: BSONObjectID, title: String, description: String)

object Post {

}
