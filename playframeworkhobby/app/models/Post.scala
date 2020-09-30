package models


case class Post(_id: Int, title: String, description: String)

case class PostData(_id: Option[Int], title: String, description: String) {
  def apply(generateID: Int, title: String, description: String) = ???


}


object Post {

}
