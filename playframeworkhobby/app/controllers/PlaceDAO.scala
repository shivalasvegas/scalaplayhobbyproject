package controllers

import models.PlaceData
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText, optional}

class PlaceDAO {

}

object PlaceDAO {


  val createPlaceForm = Form(
    mapping(
      "_id" -> optional(nonEmptyText),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(PlaceData.apply)(PlaceData.unapply)
  )
}