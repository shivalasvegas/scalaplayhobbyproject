package controllers

import javax.inject.Singleton
import javax.inject.Inject
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AbstractController, Action, AnyContent, BaseController, ControllerComponents, Request}
import application.PlacesApplication

import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class ApplicationController @Inject() (cc: ControllerComponents) extends AbstractController(cc){

  def listposts()  = Action.async  { implicit request: Request[AnyContent] =>
    PlacesApplication.list().map {
      posts => Ok(Json.toJson(posts))
    }
  }

  def titleParam() = Action { _ =>
    Ok("Now we're cooking on gas!")
  }


}
