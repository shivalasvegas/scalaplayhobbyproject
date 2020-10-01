package controllers

import javax.inject.Singleton
import javax.inject._
import play.api.mvc._
import play.api.mvc.Action

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index():Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())}


}
