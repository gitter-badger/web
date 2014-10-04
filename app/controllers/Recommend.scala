package controllers

import play.api._
import play.api.mvc._
import models._
import java.net.URL
import java.util.Date
import scala.io.Source
import play.api.libs.json.Json

object Recommend extends Controller {

    def today = Action {
        //jsonの読み込み
        //TODO model側に移す
        def jsonString = Source.fromFile("./app/assets/recommends.json").mkString
        def json = Json.parse(jsonString)

        Ok(views.html.recommend(
            Book(
                title = (json \ "default" \ "title").as[String],
                description = ((json \ "default" \ "description").as[String]),
                link = new URL((json \ "default" \ "link").as[String]),
                imageUrl = new URL((json \ "default" \ "imageUrl").as[String])
            ),
            new Date()
        ))
    }

}
