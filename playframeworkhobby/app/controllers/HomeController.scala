package controllers

import javax.inject._
import models.PlaceData
import play.api._
import play.api.mvc._


@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def index():Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())}

  def formtest2():Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.formtest2())}


}
