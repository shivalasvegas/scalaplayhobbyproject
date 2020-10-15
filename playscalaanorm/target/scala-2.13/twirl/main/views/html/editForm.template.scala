
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
  def apply/*1.2*/(id: Long, placeForm: Form[Place], companies : Seq[(String, String)])(implicit requestHeader: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import views.html.helper._


Seq[Any](format.raw/*1.118*/("""

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
                placeForm("company"),
                companies, 
                Symbol("_label") -> "Company", Symbol("_default") -> "-- Choose a company --",
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

  def render(id:Long,placeForm:Form[Place],companies:Seq[scala.Tuple2[String, String]],requestHeader:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(id,placeForm,companies)(requestHeader)

  def f:((Long,Form[Place],Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (id,placeForm,companies) => (requestHeader) => apply(id,placeForm,companies)(requestHeader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-13T17:15:51.155
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/app/views/editForm.scala.html
                  HASH: 24f41761b0aac17acf3ca66f36a84ac63ff70038
                  MATRIX: 798->1|987->122|1044->117|1074->150|1102->153|1113->157|1151->159|1189->171|1246->203|1292->241|1331->243|1378->263|1430->288|1443->292|1474->302|1516->317|1622->402|1664->417|1782->513|1824->528|1946->628|2002->657|2262->896|2299->906|2523->1103|2538->1109|2581->1131|2668->1188|2707->1201|2785->1270|2825->1272|2863->1283|2876->1287|2907->1297|2944->1307|3047->1380|3086->1389
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|36->11|37->12|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|42->17|47->22|48->23|53->28|53->28|53->28|56->31|58->33|58->33|58->33|59->34|59->34|59->34|60->35|61->36|63->38
                  -- GENERATED --
              */
          