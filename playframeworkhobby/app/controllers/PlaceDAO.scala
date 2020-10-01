package controllers

import models.PlaceData
import play.api.data.Form
import play.api.data.Forms.{ignored, mapping, nonEmptyText, number, optional}
import reactivemongo.api.bson.BSONObjectID

class PlaceDAO {

}

object PlaceDAO {

  private var placeID: Int = 9
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