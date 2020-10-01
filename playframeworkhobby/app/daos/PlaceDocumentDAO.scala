package daos

import models.{PlaceDocumentData}
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number, optional}

class PlaceDocumentDAO {

}

object PlaceDocumentDAO {

  private var postID: Int = 1
  def generateID: Int = {
    postID += 1
    postID
  }

  val createPostForm = Form(
    mapping(
      "_id" -> optional(number),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(PlaceDocumentData.apply)(PlaceDocumentData.unapply)
  )
}
