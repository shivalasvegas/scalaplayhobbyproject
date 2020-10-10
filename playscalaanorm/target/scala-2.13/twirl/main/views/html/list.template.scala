
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

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Page[scala.Tuple2[Computer, Option[Company]]],Int,String,MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentPage: Page[(Computer, Option[Company])], currentOrderBy: Int, currentFilter: String)(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._

def /*18.2*/header/*18.8*/(orderBy: Int, title: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*18.41*/("""
    """),format.raw/*19.5*/("""<th class="col"""),_display_(/*19.20*/orderBy),format.raw/*19.27*/(""" """),format.raw/*19.28*/("""header """),_display_(/*19.36*/if(scala.math.abs(currentOrderBy) == orderBy)/*19.81*/ {_display_(Seq[Any](format.raw/*19.83*/(""" """),_display_(/*19.85*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}),format.raw/*19.146*/(""" """)))}),format.raw/*19.148*/("""">
        <a href=""""),_display_(/*20.19*/link(0, Some(orderBy))),format.raw/*20.41*/("""">"""),_display_(/*20.44*/title),format.raw/*20.49*/("""</a>
    </th>
""")))};def /*8.2*/link/*8.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.HomeController.list(newPage, newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy), currentFilter)

}};
Seq[Any](format.raw/*1.135*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*7.42*/("""
"""),format.raw/*13.2*/("""

"""),format.raw/*17.37*/("""
"""),format.raw/*22.2*/("""

"""),_display_(/*24.2*/main/*24.6*/ {_display_(Seq[Any](format.raw/*24.8*/("""

    """),format.raw/*26.5*/("""<h1 id="section-title">"""),_display_(/*26.29*/Messages("computers.list.title", currentPage.total)),format.raw/*26.80*/("""</h1>

    """),_display_(/*28.6*/request/*28.13*/.flash.get("success").map/*28.38*/ { message =>_display_(Seq[Any](format.raw/*28.51*/("""
        """),format.raw/*29.9*/("""<div class="alert-message warning">
            <strong>Done!</strong> """),_display_(/*30.37*/message),format.raw/*30.44*/("""
        """),format.raw/*31.9*/("""</div>
    """)))}),format.raw/*32.6*/("""

    """),format.raw/*34.5*/("""<div id="actions">

        """),_display_(/*36.10*/form(action=routes.HomeController.list())/*36.51*/ {_display_(Seq[Any](format.raw/*36.53*/("""
            """),format.raw/*37.13*/("""<input type="search" id="searchbox" name="f" value=""""),_display_(/*37.66*/currentFilter),format.raw/*37.79*/("""" placeholder="Filter by computer name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        """)))}),format.raw/*39.10*/("""

        """),format.raw/*41.9*/("""<a class="btn success" id="add" href=""""),_display_(/*41.48*/routes/*41.54*/.HomeController.create()),format.raw/*41.78*/("""">Add a new computer</a>

    </div>

    """),_display_(/*45.6*/Option(currentPage.items)/*45.31*/.filterNot(_.isEmpty).map/*45.56*/ { computers =>_display_(Seq[Any](format.raw/*45.71*/("""

        """),format.raw/*47.9*/("""<table class="computers zebra-striped">
            <thead>
                <tr>
                    """),_display_(/*50.22*/header(2, "Computer name")),format.raw/*50.48*/("""
                    """),_display_(/*51.22*/header(3, "Introduced")),format.raw/*51.45*/("""
                    """),_display_(/*52.22*/header(4, "Discontinued")),format.raw/*52.47*/("""
                    """),_display_(/*53.22*/header(5, "Company")),format.raw/*53.42*/("""
                """),format.raw/*54.17*/("""</tr>
            </thead>
            <tbody>

                """),_display_(/*58.18*/computers/*58.27*/.map/*58.31*/ {/*59.21*/case (computer, company) =>/*59.48*/ {_display_(Seq[Any](format.raw/*59.50*/("""
                        """),format.raw/*60.25*/("""<tr>
                            <td><a href=""""),_display_(/*61.43*/routes/*61.49*/.HomeController.edit(computer.id.get)),format.raw/*61.86*/("""">"""),_display_(/*61.89*/computer/*61.97*/.name),format.raw/*61.102*/("""</a></td>
                            <td>
                                """),_display_(/*63.34*/computer/*63.42*/.introduced.map(_.format("dd MMM yyyy")).getOrElse/*63.92*/ {_display_(Seq[Any](format.raw/*63.94*/(""" """),format.raw/*63.95*/("""<em>-</em> """)))}),format.raw/*63.107*/("""
                            """),format.raw/*64.29*/("""</td>
                            <td>
                                """),_display_(/*66.34*/computer/*66.42*/.discontinued.map(_.format("dd MMM yyyy")).getOrElse/*66.94*/ {_display_(Seq[Any](format.raw/*66.96*/(""" """),format.raw/*66.97*/("""<em>-</em> """)))}),format.raw/*66.109*/("""
                            """),format.raw/*67.29*/("""</td>
                            <td>
                                """),_display_(/*69.34*/company/*69.41*/.map(_.name).getOrElse/*69.63*/ {_display_(Seq[Any](format.raw/*69.65*/(""" """),format.raw/*69.66*/("""<em>-</em> """)))}),format.raw/*69.78*/("""
                            """),format.raw/*70.29*/("""</td>
                        </tr>
                    """)))}}),format.raw/*73.18*/("""

            """),format.raw/*75.13*/("""</tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(/*80.18*/currentPage/*80.29*/.prev.map/*80.38*/ { page =>_display_(Seq[Any](format.raw/*80.48*/("""
                    """),format.raw/*81.21*/("""<li class="prev">
                        <a href=""""),_display_(/*82.35*/link(page)),format.raw/*82.45*/("""">&larr; Previous</a>
                    </li>
                """)))}/*84.18*/.getOrElse/*84.28*/ {_display_(Seq[Any](format.raw/*84.30*/("""
                    """),format.raw/*85.21*/("""<li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))}),format.raw/*88.18*/("""
                """),format.raw/*89.17*/("""<li class="current">
                    <a>Displaying """),_display_(/*90.36*/(currentPage.offset + 1)),format.raw/*90.60*/(""" """),format.raw/*90.61*/("""to """),_display_(/*90.65*/(currentPage.offset + computers.size)),format.raw/*90.102*/(""" """),format.raw/*90.103*/("""of """),_display_(/*90.107*/currentPage/*90.118*/.total),format.raw/*90.124*/("""</a>
                </li>
                """),_display_(/*92.18*/currentPage/*92.29*/.next.map/*92.38*/ { page =>_display_(Seq[Any](format.raw/*92.48*/("""
                    """),format.raw/*93.21*/("""<li class="next">
                        <a href=""""),_display_(/*94.35*/link(page)),format.raw/*94.45*/("""">Next &rarr;</a>
                    </li>
                """)))}/*96.18*/.getOrElse/*96.28*/ {_display_(Seq[Any](format.raw/*96.30*/("""
                    """),format.raw/*97.21*/("""<li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))}),format.raw/*100.18*/("""
            """),format.raw/*101.13*/("""</ul>
        </div>

    """)))}/*104.6*/.getOrElse/*104.16*/ {_display_(Seq[Any](format.raw/*104.18*/("""

        """),format.raw/*106.9*/("""<div class="well">
            <em>Nothing to display</em>
        </div>

    """)))}),format.raw/*110.6*/("""


""")))}),format.raw/*113.2*/("""

"""))
      }
    }
  }

  def render(currentPage:Page[scala.Tuple2[Computer, Option[Company]]],currentOrderBy:Int,currentFilter:String,request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(currentPage,currentOrderBy,currentFilter)(request)

  def f:((Page[scala.Tuple2[Computer, Option[Company]]],Int,String) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (currentPage,currentOrderBy,currentFilter) => (request) => apply(currentPage,currentOrderBy,currentFilter)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-10T11:34:42.453
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/playExamples/play-samples/play-scala-anorm-example/app/views/list.scala.html
                  HASH: 2d36c54384e6920ac7ebffc2622b36e5dc37858f
                  MATRIX: 800->1|1006->139|1035->667|1049->673|1159->706|1192->712|1234->727|1262->734|1291->735|1326->743|1380->788|1420->790|1449->792|1532->853|1566->855|1615->877|1658->899|1688->902|1714->907|1754->288|1765->292|2054->134|2084->156|2113->285|2142->550|2174->664|2203->925|2234->930|2246->934|2285->936|2320->944|2371->968|2443->1019|2483->1033|2499->1040|2533->1065|2584->1078|2621->1088|2721->1161|2749->1168|2786->1178|2829->1191|2864->1199|2922->1230|2972->1271|3012->1273|3054->1287|3134->1340|3168->1353|3349->1503|3388->1515|3454->1554|3469->1560|3514->1584|3587->1631|3621->1656|3655->1681|3708->1696|3747->1708|3879->1813|3926->1839|3976->1862|4020->1885|4070->1908|4116->1933|4166->1956|4207->1976|4253->1994|4349->2063|4367->2072|4380->2076|4391->2100|4427->2127|4467->2129|4521->2155|4596->2203|4611->2209|4669->2246|4699->2249|4716->2257|4743->2262|4848->2340|4865->2348|4924->2398|4964->2400|4993->2401|5037->2413|5095->2443|5196->2517|5213->2525|5274->2577|5314->2579|5343->2580|5387->2592|5445->2622|5546->2696|5562->2703|5593->2725|5633->2727|5662->2728|5705->2740|5763->2770|5854->2848|5898->2864|6040->2979|6060->2990|6078->2999|6126->3009|6176->3031|6256->3084|6287->3094|6373->3161|6392->3171|6432->3173|6482->3195|6633->3315|6679->3333|6763->3390|6808->3414|6837->3415|6868->3419|6927->3456|6957->3457|6989->3461|7010->3472|7038->3478|7111->3524|7131->3535|7149->3544|7197->3554|7247->3576|7327->3629|7358->3639|7440->3702|7459->3712|7499->3714|7549->3736|7697->3852|7740->3866|7789->3896|7809->3906|7850->3908|7890->3920|8005->4004|8043->4011
                  LINES: 21->1|24->3|26->18|26->18|28->18|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|30->20|30->20|30->20|30->20|32->8|32->8|38->1|40->4|41->7|42->13|44->17|45->22|47->24|47->24|47->24|49->26|49->26|49->26|51->28|51->28|51->28|51->28|52->29|53->30|53->30|54->31|55->32|57->34|59->36|59->36|59->36|60->37|60->37|60->37|62->39|64->41|64->41|64->41|64->41|68->45|68->45|68->45|68->45|70->47|73->50|73->50|74->51|74->51|75->52|75->52|76->53|76->53|77->54|81->58|81->58|81->58|81->59|81->59|81->59|82->60|83->61|83->61|83->61|83->61|83->61|83->61|85->63|85->63|85->63|85->63|85->63|85->63|86->64|88->66|88->66|88->66|88->66|88->66|88->66|89->67|91->69|91->69|91->69|91->69|91->69|91->69|92->70|94->73|96->75|101->80|101->80|101->80|101->80|102->81|103->82|103->82|105->84|105->84|105->84|106->85|109->88|110->89|111->90|111->90|111->90|111->90|111->90|111->90|111->90|111->90|111->90|113->92|113->92|113->92|113->92|114->93|115->94|115->94|117->96|117->96|117->96|118->97|121->100|122->101|125->104|125->104|125->104|127->106|131->110|134->113
                  -- GENERATED --
              */
          