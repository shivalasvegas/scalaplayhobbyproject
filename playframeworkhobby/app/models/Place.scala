package models

case class PlaceData(_id: Option[String], name: String, description: String) {
  def apply(generateID: String, name: String, description: String) = ???
}
case class Place(_id: String, name: String, description: String){

}

object Place{

}



