package controllers

import javax.inject.Singleton
import javax.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, BaseController, ControllerComponents, MultipartFormData, Request}
import play.api.i18n.I18nSupport
import application.PlacesApplication
import daos.PostDAO
import models.{Place, PlaceData}
import reactivemongo.api.bson.BSONObjectID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ApplicationController @Inject() (cc: ControllerComponents) extends AbstractController(cc)  with play.api.i18n.I18nSupport {

  def uploadPlace(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent]=>

    val placeData = PlaceDAO.createPlaceForm.bindFromRequest().get
    val newPlace = Place(BSONObjectID.generate().stringify, placeData.name, placeData.description)
    PlacesApplication.createPlaceWithForm(newPlace)
    Future(Ok(views.html.formtest2(PlaceDAO.createPlaceForm)))
  }

  def formtest2(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.formtest2(PlaceDAO.createPlaceForm))
  }


  def titleParam() = Action { _ =>
    Ok("Now we're cooking on gas")
  }


}
