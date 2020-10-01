package daos

import models.PlaceDocumentData
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, number, optional}

class PlaceDocumentDAO {

}

object PlaceDocumentDAO {

  private var placeID: Int = 8
  def generateID: Int = {
    placeID += 1
    placeID
  }

  val createPlaceDocumentForm = Form(
    mapping(
      "_id" -> optional(number),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(PlaceDocumentData.apply)(PlaceDocumentData.unapply)
  )
}