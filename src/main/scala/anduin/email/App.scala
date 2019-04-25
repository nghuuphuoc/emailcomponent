package anduin.email

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

@react class App extends StatelessComponent {
  type Props = Unit

  def render() = {
    div("Hello")
  }
}
