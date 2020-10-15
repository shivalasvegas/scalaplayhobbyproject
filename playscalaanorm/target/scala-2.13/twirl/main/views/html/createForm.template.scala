
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

object createForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Place],Seq[scala.Tuple2[String, String]],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(placeForm: Form[Place], companies: Seq[(String, String)])(implicit requestHeader: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import views.html.helper._


Seq[Any](format.raw/*1.107*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""
    
    """),format.raw/*7.5*/("""<h1>Add a place</h1>
    
    """),_display_(/*9.6*/form(routes.HomeController.save())/*9.40*/ {_display_(Seq[Any](format.raw/*9.42*/("""
        
        """),format.raw/*11.9*/("""<fieldset>
            """),_display_(/*12.14*/CSRF/*12.18*/.formField),format.raw/*12.28*/("""
            """),_display_(/*13.14*/inputText(placeForm("name"), Symbol("_label") -> "Place name", Symbol("_help") -> "")),format.raw/*13.99*/("""
            """),_display_(/*14.14*/inputText(placeForm("introduced"), Symbol("_label") -> "Introduced date", Symbol("_help") -> "")),format.raw/*14.110*/("""
            """),_display_(/*15.14*/inputText(placeForm("discontinued"), Symbol("_label") -> "Discontinued date", Symbol("_help") -> "")),format.raw/*15.114*/("""

            """),_display_(/*17.14*/select(
                placeForm("company"),
                companies, 
                Symbol("_label") -> "Company", Symbol("_default") -> "-- Choose a company --",
                Symbol("_showConstraints") -> false
            )),format.raw/*22.14*/("""
        """),format.raw/*23.9*/("""</fieldset>

        <p>Dates are in yyyy-MM-dd format</p>
        
        <div class="actions">
            <input type="submit" value="Create this place" class="btn primary"> or
            <a href=""""),_display_(/*29.23*/routes/*29.29*/.HomeController.list()),format.raw/*29.51*/("""" class="btn">Cancel</a>
        </div>
        
    """)))}),format.raw/*32.6*/("""
    
""")))}),format.raw/*34.2*/("""
"""))
      }
    }
  }

  def render(placeForm:Form[Place],companies:Seq[scala.Tuple2[String, String]],requestHeader:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(placeForm,companies)(requestHeader)

  def f:((Form[Place],Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (placeForm,companies) => (requestHeader) => apply(placeForm,companies)(requestHeader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-13T17:15:51.114
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/app/views/createForm.scala.html
                  HASH: 486b0bb46126faa3edd95383ccb426bf2603d9fb
                  MATRIX: 795->1|973->111|1030->106|1060->139|1088->142|1099->146|1137->148|1175->160|1233->193|1275->227|1314->229|1361->249|1413->274|1426->278|1457->288|1499->303|1605->388|1647->403|1765->499|1807->514|1929->614|1973->631|2233->870|2270->880|2506->1089|2521->1095|2564->1117|2651->1174|2690->1183
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|36->11|37->12|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|42->17|47->22|48->23|54->29|54->29|54->29|57->32|59->34
                  -- GENERATED --
              */
          