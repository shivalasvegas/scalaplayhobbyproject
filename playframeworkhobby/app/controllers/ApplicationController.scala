package controllers

import javax.inject.Singleton
import javax.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import application.PlacesApplication
import application.PlacesApplication.collectionPlace
import daos.PlaceDAO
import models.Place
import reactivemongo.api.bson.{BSONDocumentWriter, BSONObjectID, Macros}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ApplicationController @Inject() (cc: ControllerComponents) extends AbstractController(cc)  with play.api.i18n.I18nSupport {

  def uploadPlace(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent]=>

    println("Ready to upload ... ")
    val placeData = PlaceDAO.createPlaceForm.bindFromRequest().get
    val newPlace = Place(BSONObjectID.generate().stringify, placeData.name, placeData.description)
    println("Creating document for database ... ")
    //PlacesApplication.createPlaceWithForm(newPlace)
    implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]
    collectionPlace.flatMap(_.insert.one(newPlace)).map(lastError =>
      Ok(views.html.formtest2(PlaceDAO.createPlaceForm)))
   // println("Should have created document inside collection ...")
    //Future(Ok(views.html.))
  }

  def formtest2(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.formtest2(PlaceDAO.createPlaceForm))
  }


  def titleParam() = Action { _ =>
    Ok("Now we're cooking on gas")
  }


}
