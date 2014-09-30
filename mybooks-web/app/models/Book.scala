package models

import java.net.URL

case class Book(
    title:String,
    description:String = "本の説明がここに入ります",
    link:URL = new URL("http://www.yahoo.co.jp"),
    imageUrl:URL = new URL("http://k.yimg.jp/images/top/sp2/cmn/logo-ns-131205.png")
)
