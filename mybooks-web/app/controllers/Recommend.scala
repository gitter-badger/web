package controllers

import play.api._
import play.api.mvc._

object Recommend extends Controller {

    def today = Action {
        Ok(views.html.recommend("仕事は楽しいかね"))
    }

}
