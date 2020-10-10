
package views.html.helper

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

object date extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[play.api.data.Field,Array[scala.Tuple2[Symbol, Any]],FieldConstructor,play.api.i18n.MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: play.api.data.Field, args: (Symbol,Any)*)(implicit handler: FieldConstructor, messages: play.api.i18n.MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/inputType/*3.11*/ = {{ "date" }};
Seq[Any](format.raw/*1.129*/("""

"""),format.raw/*3.25*/("""

"""),_display_(/*5.2*/input(field, args.filter(_._1 != Symbol("type")):_*)/*5.54*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*5.87*/("""
  """),format.raw/*6.3*/("""<input type=""""),_display_(/*6.17*/inputType),format.raw/*6.26*/("""" id=""""),_display_(/*6.33*/id),format.raw/*6.35*/("""" name=""""),_display_(/*6.44*/name),format.raw/*6.48*/("""" value=""""),_display_(/*6.58*/value),format.raw/*6.63*/("""" """),_display_(/*6.66*/toHtmlArgs(htmlArgs)),format.raw/*6.86*/("""/>
""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(field:play.api.data.Field,args:Array[scala.Tuple2[Symbol, Any]],handler:FieldConstructor,messages:play.api.i18n.MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(field,args.toIndexedSeq:_*)(handler,messages)

  def f:((play.api.data.Field,Array[scala.Tuple2[Symbol, Any]]) => (FieldConstructor,play.api.i18n.MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (field,args) => (handler,messages) => apply(field,args.toIndexedSeq:_*)(handler,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-10T11:34:42.401
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/playExamples/play-samples/play-scala-anorm-example/app/views/helper/date.scala.html
                  HASH: a55869e8809f6b169a02635e5ea7d936cbc17811
                  MATRIX: 829->1|1034->133|1051->142|1096->128|1127->156|1157->161|1217->213|1287->246|1317->250|1357->264|1386->273|1419->280|1441->282|1476->291|1500->295|1536->305|1561->310|1590->313|1630->333|1664->338
                  LINES: 21->1|25->3|25->3|26->1|28->3|30->5|30->5|30->5|31->6|31->6|31->6|31->6|31->6|31->6|31->6|31->6|31->6|31->6|31->6|32->7
                  -- GENERATED --
              */
          