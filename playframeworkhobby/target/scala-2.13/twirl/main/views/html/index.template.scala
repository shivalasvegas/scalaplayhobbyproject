
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Welcome")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
"""),format.raw/*4.1*/("""<div class="App">
  <header class="App-header">
    <h1> Google Maps API </h1>
  </header>
  <main>
    <div class="container">

      <div class= "row">
        <div class= "col">
          <h4> Test Page </h4>
          <p>This page is set up to be a testing bed for Google Maps API.</p>
        </div>
        <div class= "col"><h4> Map </h4></div>
      </div>

      <div class= "row">
        <div class="col"><h4> Feature </h4></div>
        <div class="col"><h4> Feature </h4></div>
      </div>

    </div>
  </main>
  <footer>

  </footer>
</div>
""")))}),format.raw/*30.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-05T08:14:42.886783
                  SOURCE: /Users/shivaking/Documents/CC_SCALAPROJECTS/scalaplayhobbyproject/playframeworkhobby/app/views/index.scala.html
                  HASH: eea12bbae1cef40ad9581e87da53c6d889f08487
                  MATRIX: 722->1|818->4|845->6|868->21|907->23|934->24|1522->582
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|54->30
                  -- GENERATED --
              */
          