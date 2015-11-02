package controllers

import com.typesafe.config.ConfigFactory
import play.api._
import play.api.mvc._
import javax.inject._

/*
 * 2.4 的 DI
 * 一般情形下，在 2.4 版雖然使用 class 而非 object。但行為是 object 也就是 singleton
 * 如果是 DI 的情形下(在 routes 設定檔加 "@")，則是 class 行為，也就是每次的 request 都會產生一個新的 instance。
 * 如果要保有 singleton ，則需要使用 @Singleton. 範例如下：
 */

@Singleton
class Application extends Controller {

  val config = ConfigFactory.load

  var counter = 0

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def env = Action {
    counter += 1
    Ok(s"${config.getString("env.debug")} : $counter")
  }
}
