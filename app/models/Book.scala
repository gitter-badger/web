package models

import java.net.URL
import play.api.libs.json.Json
import scala.io.Source
import java.util.Date
import play.api.libs.json._

case class Book(
    title:String,
    description:String,
    link:URL,
    imageUrl:URL
)

object Book {
    def load(date:Date) = {
        //おすすめ本一覧データを読み込み
        def jsonString = Source.fromFile("./app/assets/recommends.json", "UTF-8").mkString
        def json = Json.parse(jsonString)

        //キーとなる日付文字列を生成
        def dateString = new java.text.SimpleDateFormat("yyyy-MM-dd").format(date)

        //対象となる本を探す
        def targetJson = (json \ "recommends" \ dateString).asOpt[JsValue] match {
            case Some(jsValue) => jsValue
            case None => json \ "default"
        }

        //Bookオブジェクトを生成して返却
        Book(
            title = (targetJson \ "title").as[String],
            description = ((targetJson \ "description").as[String]),
            link = new URL((targetJson \ "link").as[String]),
            imageUrl = new URL((targetJson \ "imageUrl").as[String])
        )
    }
}
