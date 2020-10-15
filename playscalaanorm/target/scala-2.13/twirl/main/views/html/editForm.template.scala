
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

object editForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Long,Form[Place],Seq[scala.Tuple2[String, String]],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long, placeForm: Form[Place], placeInfos : Seq[(String, String)])(implicit requestHeader: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import views.html.helper._


Seq[Any](format.raw/*1.119*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""
    
    """),format.raw/*7.5*/("""<h1>Edit place</h1>
    
    """),_display_(/*9.6*/form(routes.HomeController.update(id))/*9.44*/ {_display_(Seq[Any](format.raw/*9.46*/("""
        
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
            <input type="submit" value="Save this place" class="btn primary"> or
            <a href=""""),_display_(/*28.23*/routes/*28.29*/.HomeController.list()),format.raw/*28.51*/("""" class="btn">Cancel</a>
        </div>
        
    """)))}),format.raw/*31.6*/("""
    
    """),_display_(/*33.6*/form(routes.HomeController.delete(id), Symbol("class") -> "topRight")/*33.75*/ {_display_(Seq[Any](format.raw/*33.77*/("""
        """),_display_(/*34.10*/CSRF/*34.14*/.formField),format.raw/*34.24*/("""
        """),format.raw/*35.9*/("""<input type="submit" value="Delete this place" class="btn danger">
    """)))}),format.raw/*36.6*/("""
    
""")))}),format.raw/*38.2*/("""
"""))
      }
    }
  }

  def render(id:Long,placeForm:Form[Place],placeInfos:Seq[scala.Tuple2[String, String]],requestHeader:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(id,placeForm,placeInfos)(requestHeader)

  def f:((Long,Form[Place],Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (id,placeForm,placeInfos) => (requestHeader) => apply(id,placeForm,placeInfos)(requestHeader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-15T12:38:35.376
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/app/views/editForm.scala.html
                  HASH: 80b8b9608788c23bec6448a7081050dca81e453b
                  MATRIX: 798->1|988->123|1045->118|1075->151|1103->154|1114->158|1152->160|1190->172|1247->204|1293->242|1332->244|1379->264|1431->289|1444->293|1475->303|1517->318|1623->403|1665->418|1783->514|1825->529|1947->629|2003->658|2270->904|2307->914|2531->1111|2546->1117|2589->1139|2676->1196|2715->1209|2793->1278|2833->1280|2871->1291|2884->1295|2915->1305|2952->1315|3055->1388|3094->1397
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|36->11|37->12|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|42->17|47->22|48->23|53->28|53->28|53->28|56->31|58->33|58->33|58->33|59->34|59->34|59->34|60->35|61->36|63->38
                  -- GENERATED --
              */
          