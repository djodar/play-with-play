package controllers

import models.Product
import play.api.mvc.{Action, Controller}

/**
 * Created by daniel.jodar on 19/06/2015.
 */
object Products extends Controller {

  def list = Action { implicit request =>
    val products = Product.findAll

    Ok(views.html.products.list(products))
  }

}
