package controllers

import javax.inject.Singleton
import javax.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import application.PlacesApplication
import application.PlacesApplication.{collectionPlace, db1}
import daos.PlaceDAO
import models.Place
import reactivemongo.api.bson.collection.BSONCollection
import reactivemongo.api.bson.{BSONDocumentWriter, BSONObjectID, Macros}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ApplicationController @Inject() (cc: ControllerComponents) extends AbstractController(cc)  with play.api.i18n.I18nSupport {

  PlacesApplication

  def uploadPlace(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    implicit def placesWriter: BSONDocumentWriter[Place] = Macros.writer[Place]

    println("Ready to upload ... ")
    val placeData = PlaceDAO.createPlaceForm.bindFromRequest().get
    val place = Place(BSONObjectID.generate().stringify, placeData.name, placeData.description)
    println("Creating document for database ... ")

    //PlacesApplication.create(placeData)
    if (db1 == null) println(s"Found null database $db1")

    def collectionPlace =
      try {
        db1.map(_.collection("place"))
      } catch{
        case ex: NullPointerException => {
        println("Found the null pointer exception")
      }
  }
    println(s"Writing document for database ... ${placeData.description}")
    def collectionTest: Future[BSONCollection] = db1.map(_.collection("testplace"))
    println("Writing document for database ... ")
    //PlacesApplication.createPlaceWithForm(newPlace)


    for {
      places <- collectionTest
      writeResult <- places.insert.one(place)
    } yield writeResult

    println("Document written ... ")
    //collectionPlace.flatMap(_.insert.one(newPlace))
      Future(Ok(views.html.formtest2(PlaceDAO.createPlaceForm)))
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
