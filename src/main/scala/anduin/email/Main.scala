package anduin.email

import scala.scalajs.LinkingInfo
import scala.scalajs.js.annotation.JSExportTopLevel

import org.scalajs.dom
import slinky.hot
import slinky.web.ReactDOM

// The entry point
object Main {
  @JSExportTopLevel("main")
  def main(): Unit = {
    if (LinkingInfo.developmentMode) {
      hot.initialize()
    }

    val doc = dom.document
    val container = Option(doc.getElementById("root")).getOrElse {
      val elem = doc.createElement("div")
      elem.id = "root"
      doc.body.appendChild(elem)
      elem
    }

    ReactDOM.render(App(), container)
  }
}
