
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html lang="en">
    <head>

        <title>"""),_display_(/*6.17*/title),format.raw/*6.22*/("""</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" media="screen" href='"""),_display_(/*9.54*/routes/*9.60*/.Assets.versioned("stylesheets/bootstrap.css")),format.raw/*9.106*/("""'>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*10.54*/routes/*10.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*10.101*/("""'>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*11.54*/routes/*11.60*/.Assets.versioned("stylesheets/App.css")),format.raw/*11.100*/("""'>
        <link rel="stylesheet" media="screen" href='"""),_display_(/*12.54*/routes/*12.60*/.Assets.versioned("stylesheets/index.css")),format.raw/*12.102*/("""'>
        <link rel="shortcut icon" type="image/png" href='"""),_display_(/*13.59*/routes/*13.65*/.Assets.versioned("/favicon.png")),format.raw/*13.98*/("""'>

    </head>
    <body>

        """),_display_(/*18.10*/content),format.raw/*18.17*/("""

      """),format.raw/*20.7*/("""<script src='"""),_display_(/*20.21*/routes/*20.27*/.Assets.versioned("javascripts/main.js")),format.raw/*20.67*/("""' type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-05T08:14:42.878618
                  SOURCE: /Users/shivaking/Documents/CC_SCALAPROJECTS/scalaplayhobbyproject/playframeworkhobby/app/views/main.scala.html
                  HASH: 0b648a3e17f3c8346187edf511e6079e85955822
                  MATRIX: 733->1|857->32|884->33|955->78|980->83|1146->223|1160->229|1227->275|1310->331|1325->337|1388->378|1471->434|1486->440|1548->480|1631->536|1646->542|1710->584|1798->645|1813->651|1867->684|1931->721|1959->728|1994->736|2035->750|2050->756|2111->796
                  LINES: 21->1|26->2|27->3|30->6|30->6|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|42->18|42->18|44->20|44->20|44->20|44->20
                  -- GENERATED --
              */
          