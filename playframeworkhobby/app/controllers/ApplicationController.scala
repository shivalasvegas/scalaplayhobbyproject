package controllers

import javax.inject.Singleton
import javax.inject.Inject
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AbstractController, Action, AnyContent, BaseController, ControllerComponents, Request}
import application.PlacesApplication
import daos.PostDAO
import play.api.data._
import play.api.data.Forms._
import views.html.helper.form

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ApplicationController @Inject() (cc: ControllerComponents) extends AbstractController(cc){

  def createPost(): Action[AnyContent] = Action.async { implicit request =>
   val postedData = PostDAO.createPostForm.bindFromRequest.get
    PostDAO.createPostForm.bindFromRequest.fold(
      formWithErrors => {
        Future(BadRequest(Json.toJson("Bad request")))
      },
      postForm => {
        val newPost = postForm(PostDAO.generateID, postedData.title, postedData.description)
        PlacesApplication.createWithForm(newPost)
        Future(Ok(Json.toJson("Success")))
      }
    )

  }


  def titleParam() = Action { _ =>
    Ok("Now we're cooking on gas")
  }


}
