package daos

import models.PostData
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number, optional}

class PostDAO {

}

object PostDAO {

  private var postID: Int = 0
  def generateID: Int = {
    postID += 1
    postID
  }

  val createPostForm = Form(
    mapping(
      "_id" -> optional(number),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(PostData.apply)(PostData.unapply)
  )
}
