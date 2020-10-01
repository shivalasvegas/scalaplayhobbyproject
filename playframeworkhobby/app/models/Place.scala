package models

import reactivemongo.api.bson.BSONObjectID

case class PlaceData(_id: Option[String], name: String, description: String) {
  def apply(generateID: Int, name: String, description: String) = ???
}
case class Place(_id: String, name: String, description: String){

}

object Place{

}



