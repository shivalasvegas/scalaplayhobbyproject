package models


case class PlaceDocument(_id: Int, title: String, description: String)

case class PlaceDocumentData(_id: Option[Int], title: String, description: String) {
  def apply(generateID: Int, title: String, description: String) = ???


}


object Post {

}
