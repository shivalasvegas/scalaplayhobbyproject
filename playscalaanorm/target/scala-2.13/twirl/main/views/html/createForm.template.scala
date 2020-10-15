
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
  def apply/*1.2*/(placeForm: Form[Place], placeInfos: Seq[(String, String)])(implicit requestHeader: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import views.html.helper._


Seq[Any](format.raw/*1.108*/("""

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
                placeForm("placeInfo"),
                placeInfos, 
                Symbol("_label") -> "PlaceInfo", Symbol("_default") -> "-- Choose a placeInfo --",
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

  def render(placeForm:Form[Place],placeInfos:Seq[scala.Tuple2[String, String]],requestHeader:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(placeForm,placeInfos)(requestHeader)

  def f:((Form[Place],Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (placeForm,placeInfos) => (requestHeader) => apply(placeForm,placeInfos)(requestHeader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-15T12:38:35.291
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/app/views/createForm.scala.html
                  HASH: f0633ef5a8249fc7294b385df45863daccdffe32
                  MATRIX: 795->1|974->112|1031->107|1061->140|1089->143|1100->147|1138->149|1176->161|1234->194|1276->228|1315->230|1362->250|1414->275|1427->279|1458->289|1500->304|1606->389|1648->404|1766->500|1808->515|1930->615|1974->632|2241->878|2278->888|2514->1097|2529->1103|2572->1125|2659->1182|2698->1191
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|36->11|37->12|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|42->17|47->22|48->23|54->29|54->29|54->29|57->32|59->34
                  -- GENERATED --
              */
          