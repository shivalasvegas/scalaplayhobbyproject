package controllers

import daos.PlaceDAO
import javax.inject.Inject
import models.{Place, PlaceData}
import play.api.libs.Files
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import reactivemongo.api.bson.collection.BSONCollection

@Singleton
class ApplicationController @Inject()(val controllerComponents: ControllerComponents) extends BaseController{
  val placeDAO = new PlaceDAO

  def uploadPlace(): Action[AnyContent] = Action.async {implicit request =>
    val formData: PlaceData = PlaceDAO.createPlaceForm.bindFromRequest.get

    def success(placeData: PlaceData): Unit ={
      placeDAO.create(placeData).Ok(views.html.formtest2)
    }



  }
}
