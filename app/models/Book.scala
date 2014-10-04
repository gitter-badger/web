package models

import java.net.URL
import play.api.libs.json.Json
import scala.io.Source

case class Book(
    title:String,
    description:String,
    link:URL,
    imageUrl:URL
)

object Book {
    def load = {
        def jsonString = Source.fromFile("./app/assets/recommends.json").mkString
        def json = Json.parse(jsonString)
        Book(
            title = (json \ "default" \ "title").as[String],
            description = ((json \ "default" \ "description").as[String]),
            link = new URL((json \ "default" \ "link").as[String]),
            imageUrl = new URL((json \ "default" \ "imageUrl").as[String])
        )
    }
}
