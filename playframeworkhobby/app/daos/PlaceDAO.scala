package daos

import models.PlaceData
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, optional}

class PlaceDAO {

}

object PlaceDAO {

  private var placeID: Int = 0
  def generateID: Int = {
    placeID += 1
    placeID
  }

  val createPlaceForm = Form(
    mapping(
      "_id" -> optional(nonEmptyText),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(PlaceData.apply)(PlaceData.unapply)
  )
}