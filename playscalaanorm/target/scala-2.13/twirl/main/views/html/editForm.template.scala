
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

object editForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Long,Form[Computer],Seq[scala.Tuple2[String, String]],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long, computerForm: Form[Computer], companies : Seq[(String, String)])(implicit requestHeader: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import views.html.helper._


Seq[Any](format.raw/*1.124*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""
    
    """),format.raw/*7.5*/("""<h1>Edit computer</h1>
    
    """),_display_(/*9.6*/form(routes.HomeController.update(id))/*9.44*/ {_display_(Seq[Any](format.raw/*9.46*/("""
        
        """),format.raw/*11.9*/("""<fieldset>
            """),_display_(/*12.14*/CSRF/*12.18*/.formField),format.raw/*12.28*/("""
            """),_display_(/*13.14*/inputText(computerForm("name"), Symbol("_label") -> "Computer name", Symbol("_help") -> "")),format.raw/*13.105*/("""
            """),_display_(/*14.14*/inputText(computerForm("introduced"), Symbol("_label") -> "Introduced date", Symbol("_help") -> "")),format.raw/*14.113*/("""
            """),_display_(/*15.14*/inputText(computerForm("discontinued"), Symbol("_label") -> "Discontinued date", Symbol("_help") -> "")),format.raw/*15.117*/("""
            
            """),_display_(/*17.14*/select(
                computerForm("company"), 
                companies, 
                Symbol("_label") -> "Company", Symbol("_default") -> "-- Choose a company --",
                Symbol("_showConstraints") -> false
            )),format.raw/*22.14*/("""
        """),format.raw/*23.9*/("""</fieldset>
        <p>Dates are in yyyy-MM-dd format</p>

        <div class="actions">
            <input type="submit" value="Save this computer" class="btn primary"> or 
            <a href=""""),_display_(/*28.23*/routes/*28.29*/.HomeController.list()),format.raw/*28.51*/("""" class="btn">Cancel</a>
        </div>
        
    """)))}),format.raw/*31.6*/("""
    
    """),_display_(/*33.6*/form(routes.HomeController.delete(id), Symbol("class") -> "topRight")/*33.75*/ {_display_(Seq[Any](format.raw/*33.77*/("""
        """),_display_(/*34.10*/CSRF/*34.14*/.formField),format.raw/*34.24*/("""
        """),format.raw/*35.9*/("""<input type="submit" value="Delete this computer" class="btn danger">
    """)))}),format.raw/*36.6*/("""
    
""")))}),format.raw/*38.2*/("""
"""))
      }
    }
  }

  def render(id:Long,computerForm:Form[Computer],companies:Seq[scala.Tuple2[String, String]],requestHeader:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(id,computerForm,companies)(requestHeader)

  def f:((Long,Form[Computer],Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (id,computerForm,companies) => (requestHeader) => apply(id,computerForm,companies)(requestHeader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-10T11:34:42.376
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/playExamples/play-samples/play-scala-anorm-example/app/views/editForm.scala.html
                  HASH: b9f63eb228e03a0ea1f1afb44ae43f67e3399ec0
                  MATRIX: 801->1|996->128|1053->123|1083->156|1111->159|1122->163|1160->165|1198->177|1258->212|1304->250|1343->252|1390->272|1442->297|1455->301|1486->311|1528->326|1641->417|1683->432|1804->531|1846->546|1971->649|2027->678|2291->921|2328->931|2556->1132|2571->1138|2614->1160|2701->1217|2740->1230|2818->1299|2858->1301|2896->1312|2909->1316|2940->1326|2977->1336|3083->1412|3122->1421
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|36->11|37->12|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|42->17|47->22|48->23|53->28|53->28|53->28|56->31|58->33|58->33|58->33|59->34|59->34|59->34|60->35|61->36|63->38
                  -- GENERATED --
              */
          