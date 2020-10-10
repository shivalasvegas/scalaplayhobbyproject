
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

object createForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[Computer],Seq[scala.Tuple2[String, String]],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(computerForm: Form[Computer], companies: Seq[(String, String)])(implicit requestHeader: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import views.html.helper._


Seq[Any](format.raw/*1.113*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""
    
    """),format.raw/*7.5*/("""<h1>Add a computer</h1>
    
    """),_display_(/*9.6*/form(routes.HomeController.save())/*9.40*/ {_display_(Seq[Any](format.raw/*9.42*/("""
        
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
            <input type="submit" value="Create this computer" class="btn primary"> or 
            <a href=""""),_display_(/*29.23*/routes/*29.29*/.HomeController.list()),format.raw/*29.51*/("""" class="btn">Cancel</a>
        </div>
        
    """)))}),format.raw/*32.6*/("""
    
""")))}),format.raw/*34.2*/("""
"""))
      }
    }
  }

  def render(computerForm:Form[Computer],companies:Seq[scala.Tuple2[String, String]],requestHeader:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(computerForm,companies)(requestHeader)

  def f:((Form[Computer],Seq[scala.Tuple2[String, String]]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (computerForm,companies) => (requestHeader) => apply(computerForm,companies)(requestHeader)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-10T11:34:42.341
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/playExamples/play-samples/play-scala-anorm-example/app/views/createForm.scala.html
                  HASH: 3a9422265877a5b0078fe60ab00ac55622c6d649
                  MATRIX: 798->1|982->117|1039->112|1069->145|1097->148|1108->152|1146->154|1184->166|1245->202|1287->236|1326->238|1373->258|1425->283|1438->287|1469->297|1511->312|1624->403|1666->418|1787->517|1829->532|1954->635|1998->652|2262->895|2299->905|2539->1118|2554->1124|2597->1146|2684->1203|2723->1212
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|32->7|34->9|34->9|34->9|36->11|37->12|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|42->17|47->22|48->23|54->29|54->29|54->29|57->32|59->34
                  -- GENERATED --
              */
          