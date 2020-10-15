package controllers

import javax.inject.Inject
import models._
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import views._

import scala.concurrent.{ExecutionContext, Future}

/**
  * Manage a database of computers
  */
class HomeController @Inject()(placeService: PlacesRepository,
                               companyService: CompanyRepository,
                               cc: MessagesControllerComponents)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  private val logger = play.api.Logger(this.getClass)

  /**
    * This result directly redirect to the application home.
    */
  val Home = Redirect(routes.HomeController.list(0, 2, ""))

  /**
    * Describe the place form (used in both edit and create screens).
    */
  val placeForm = Form(
    mapping(
      "id" -> ignored(None: Option[Long]),
      "name" -> nonEmptyText,
      "introduced" -> optional(date("yyyy-MM-dd")),
      "discontinued" -> optional(date("yyyy-MM-dd")),
      "company" -> optional(longNumber)
    )(Place.apply)(Place.unapply)
  )

  // -- Actions

  /**
    * Handle default path requests, redirect to computers list
    */
  def index = Action {
    Home
  }

  /**
    * Display the paginated list of computers.
    *
    * @param page    Current page number (starts from 0)
    * @param orderBy Column to be sorted
    * @param filter  Filter applied on place names
    */
  def list(page: Int, orderBy: Int, filter: String) = Action.async { implicit request =>
    placeService.list(page = page, orderBy = orderBy, filter = ("%" + filter + "%")).map { page =>
      Ok(html.list(page, orderBy, filter))
    }
  }

  /**
    * Display the 'edit form' of a existing Computer.
    *
    * @param id Id of the place to edit
    */
  def edit(id: Long) = Action.async { implicit request =>
    placeService.findById(id).flatMap {
      case Some(place) =>
        companyService.options.map { options =>
          Ok(html.editForm(id, placeForm.fill(place), options))
        }
      case other =>
        Future.successful(NotFound)
    }
  }

  /**
    * Handle the 'edit form' submission
    *
    * @param id Id of the computer to edit
    */
  def update(id: Long) = Action.async { implicit request =>
    placeForm.bindFromRequest.fold(
      formWithErrors => {
        logger.warn(s"form error: $formWithErrors")
        companyService.options.map { options =>
          BadRequest(html.editForm(id, formWithErrors, options))
        }
      },
      place => {
        placeService.update(id, place).map { _ =>
          Home.flashing("success" -> "Place %s has been updated".format(place.name))
        }
      }
    )
  }

  /**
    * Display the 'new computer form'.
    */
  def create = Action.async { implicit request =>
    companyService.options.map { options =>
      Ok(html.createForm(placeForm, options))
    }
  }

  /**
    * Handle the 'new computer form' submission.
    */
  def save = Action.async { implicit request =>
    placeForm.bindFromRequest.fold(
      formWithErrors => companyService.options.map { options =>
        BadRequest(html.createForm(formWithErrors, options))
      },
      place => {
        placeService.insert(place).map { _ =>
          Home.flashing("success" -> "Place %s has been created".format(place.name))
        }
      }
    )
  }

  /**
    * Handle computer deletion.
    */
  def delete(id: Long) = Action.async {
    placeService.delete(id).map { _ =>
      Home.flashing("success" -> "Computer has been deleted")
    }
  }

}
