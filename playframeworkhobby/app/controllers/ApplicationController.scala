package controllers

import javax.inject.Singleton
import javax.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import application.PlacesApplication
import daos.PlaceDAO
import models.Place
import reactivemongo.api.bson.{ BSONObjectID }

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ApplicationController @Inject() (cc: ControllerComponents) extends AbstractController(cc)  with play.api.i18n.I18nSupport {

  def uploadPlace(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>

    println("Creating document for database ... ")
    val placeData = PlaceDAO.createPlaceForm.bindFromRequest().get
    val place = Place(BSONObjectID.generate().stringify, placeData.name, placeData.description)

    PlacesApplication.createPlaceWithForm(place)
    println("Document written ... ")
    Future(Ok(views.html.formtest2(PlaceDAO.createPlaceForm)))
  }

  def formtest2(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.formtest2(PlaceDAO.createPlaceForm))
  }

  def titleParam() = Action { _ =>
    Ok("Now we're cooking on gas")
  }

}
