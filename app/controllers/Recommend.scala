package controllers

import play.api._
import play.api.mvc._
import models._
import java.net.URL
import java.util.Date

object Recommend extends Controller {

    def today = Action {
        def today = new Date()
        Ok(views.html.recommend(Book.load(today), today))
    }

}
