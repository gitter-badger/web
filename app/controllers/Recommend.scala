package controllers

import play.api._
import play.api.mvc._
import models._
import java.net.URL
import java.util.Date

object Recommend extends Controller {

    def today = Action {
        Ok(views.html.recommend(Book.load, new Date()))
    }

}
