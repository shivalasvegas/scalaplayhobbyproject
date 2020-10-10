
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Html,MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Html)(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.58*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>Computers database</title>
        
        """),format.raw/*14.47*/("""
        """),format.raw/*15.9*/("""<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*15.70*/routes/*15.76*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*15.119*/("""">
        
        <link rel="stylesheet" media="screen" href=""""),_display_(/*17.54*/routes/*17.60*/.Assets.at("stylesheets/main.css")),format.raw/*17.94*/(""""/> 
        
        
    </head>
    <body>
        
        <header class="topbar">
            <h1 class="fill" id="header-title">
                <a href=""""),_display_(/*25.27*/routes/*25.33*/.HomeController.index()),format.raw/*25.56*/("""">
                    Play sample application &mdash; Computer database
                </a>
            </h1>
        </header>
        
        <section id="main">
            """),_display_(/*32.14*/content),format.raw/*32.21*/("""
        """),format.raw/*33.9*/("""</section>
        
    </body>
</html>
"""))
      }
    }
  }

  def render(content:Html,request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(content)(request)

  def f:((Html) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (content) => (request) => apply(content)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-10T11:34:42.472
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/playExamples/play-samples/play-scala-anorm-example/app/views/main.scala.html
                  HASH: 6424bfbaed2c8d02e9ebb43a191b73e9ceeb8b42
                  MATRIX: 748->1|899->57|929->61|1055->664|1092->674|1180->735|1195->741|1260->784|1354->851|1369->857|1424->891|1620->1060|1635->1066|1679->1089|1893->1276|1921->1283|1958->1293
                  LINES: 21->1|26->1|28->3|33->14|34->15|34->15|34->15|34->15|36->17|36->17|36->17|44->25|44->25|44->25|51->32|51->32|52->33
                  -- GENERATED --
              */
          