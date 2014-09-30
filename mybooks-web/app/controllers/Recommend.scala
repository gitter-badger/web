package controllers

import play.api._
import play.api.mvc._
import models._

object Recommend extends Controller {

    def today = Action {
        Ok(views.html.recommend(Book("仕事は楽しいかね")))
    }

}
