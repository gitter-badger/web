package controllers

import play.api._
import play.api.mvc._
import models._
import java.net.URL
import java.util.Date

object Recommend extends Controller {

    def today = Action {
        Ok(views.html.recommend(
            Book(
                title = "仕事は楽しいかね",
                description = "本書は、将来への希望もなく日々仕事に追われる主人公が、老人のアドバイスに自己変革のアイデアを見いだしていく物語である。それは、唐突に繰り出される老人の言葉とそれを問いただす「私」の会話で展開していく。たとえば老人は「目標を立てるな」という。",
                link = new URL("http://amazon.co.jp/o/ASIN/4877710787/shoma2da-22"),
                imageUrl = new URL("http://ecx.images-amazon.com/images/I/717z8keSY7L.jpg")
            ),
            new Date()
        ))
    }

}
