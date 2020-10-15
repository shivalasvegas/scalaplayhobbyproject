
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

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Page[scala.Tuple2[Place, Option[Company]]],Int,String,MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentPage: Page[(Place, Option[Company])], currentOrderBy: Int, currentFilter: String)(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
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
Seq[Any](format.raw/*1.132*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*7.42*/("""
"""),format.raw/*13.2*/("""

"""),format.raw/*17.37*/("""
"""),format.raw/*22.2*/("""

"""),_display_(/*24.2*/main/*24.6*/ {_display_(Seq[Any](format.raw/*24.8*/("""

    """),format.raw/*26.5*/("""<h1 id="section-title">"""),_display_(/*26.29*/Messages("places.list.title", currentPage.total)),format.raw/*26.77*/("""</h1>

    """),_display_(/*28.6*/request/*28.13*/.flash.get("success").map/*28.38*/ { message =>_display_(Seq[Any](format.raw/*28.51*/("""
        """),format.raw/*29.9*/("""<div class="alert-message warning">
            <strong>Done!</strong> """),_display_(/*30.37*/message),format.raw/*30.44*/("""
        """),format.raw/*31.9*/("""</div>
    """)))}),format.raw/*32.6*/("""

    """),format.raw/*34.5*/("""<div id="actions">

        """),_display_(/*36.10*/form(action=routes.HomeController.list())/*36.51*/ {_display_(Seq[Any](format.raw/*36.53*/("""
            """),format.raw/*37.13*/("""<input type="search" id="searchbox" name="f" value=""""),_display_(/*37.66*/currentFilter),format.raw/*37.79*/("""" placeholder="Filter by place name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        """)))}),format.raw/*39.10*/("""

        """),format.raw/*41.9*/("""<a class="btn success" id="add" href=""""),_display_(/*41.48*/routes/*41.54*/.HomeController.create()),format.raw/*41.78*/("""">Add a new place</a>

    </div>

    """),_display_(/*45.6*/Option(currentPage.items)/*45.31*/.filterNot(_.isEmpty).map/*45.56*/ { places =>_display_(Seq[Any](format.raw/*45.68*/("""

        """),format.raw/*47.9*/("""<table class="computers zebra-striped">
            <thead>
                <tr>
                    """),_display_(/*50.22*/header(2, "Place name")),format.raw/*50.45*/("""
                    """),_display_(/*51.22*/header(3, "Introduced")),format.raw/*51.45*/("""
                    """),_display_(/*52.22*/header(4, "Discontinued")),format.raw/*52.47*/("""
                    """),_display_(/*53.22*/header(5, "Company")),format.raw/*53.42*/("""
                """),format.raw/*54.17*/("""</tr>
            </thead>
            <tbody>

                """),_display_(/*58.18*/places/*58.24*/.map/*58.28*/ {/*59.21*/case (place, company) =>/*59.45*/ {_display_(Seq[Any](format.raw/*59.47*/("""
                        """),format.raw/*60.25*/("""<tr>
                            <td><a href=""""),_display_(/*61.43*/routes/*61.49*/.HomeController.edit(place.id.get)),format.raw/*61.83*/("""">"""),_display_(/*61.86*/place/*61.91*/.name),format.raw/*61.96*/("""</a></td>
                            <td>
                                """),_display_(/*63.34*/place/*63.39*/.introduced.map(_.format("dd MMM yyyy")).getOrElse/*63.89*/ {_display_(Seq[Any](format.raw/*63.91*/(""" """),format.raw/*63.92*/("""<em>-</em> """)))}),format.raw/*63.104*/("""
                            """),format.raw/*64.29*/("""</td>
                            <td>
                                """),_display_(/*66.34*/place/*66.39*/.discontinued.map(_.format("dd MMM yyyy")).getOrElse/*66.91*/ {_display_(Seq[Any](format.raw/*66.93*/(""" """),format.raw/*66.94*/("""<em>-</em> """)))}),format.raw/*66.106*/("""
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
                    <a>Displaying """),_display_(/*90.36*/(currentPage.offset + 1)),format.raw/*90.60*/(""" """),format.raw/*90.61*/("""to """),_display_(/*90.65*/(currentPage.offset + places.size)),format.raw/*90.99*/(""" """),format.raw/*90.100*/("""of """),_display_(/*90.104*/currentPage/*90.115*/.total),format.raw/*90.121*/("""</a>
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

  def render(currentPage:Page[scala.Tuple2[Place, Option[Company]]],currentOrderBy:Int,currentFilter:String,request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(currentPage,currentOrderBy,currentFilter)(request)

  def f:((Page[scala.Tuple2[Place, Option[Company]]],Int,String) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (currentPage,currentOrderBy,currentFilter) => (request) => apply(currentPage,currentOrderBy,currentFilter)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-13T17:15:51.221
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/app/views/list.scala.html
                  HASH: 25370c537e3e2dadc95834ad949ea14450ab9020
                  MATRIX: 797->1|1000->136|1029->664|1043->670|1153->703|1186->709|1228->724|1256->731|1285->732|1320->740|1374->785|1414->787|1443->789|1526->850|1560->852|1609->874|1652->896|1682->899|1708->904|1748->285|1759->289|2048->131|2078->153|2107->282|2136->547|2168->661|2197->922|2228->927|2240->931|2279->933|2314->941|2365->965|2434->1013|2474->1027|2490->1034|2524->1059|2575->1072|2612->1082|2712->1155|2740->1162|2777->1172|2820->1185|2855->1193|2913->1224|2963->1265|3003->1267|3045->1281|3125->1334|3159->1347|3337->1494|3376->1506|3442->1545|3457->1551|3502->1575|3572->1619|3606->1644|3640->1669|3690->1681|3729->1693|3861->1798|3905->1821|3955->1844|3999->1867|4049->1890|4095->1915|4145->1938|4186->1958|4232->1976|4328->2045|4343->2051|4356->2055|4367->2079|4400->2103|4440->2105|4494->2131|4569->2179|4584->2185|4639->2219|4669->2222|4683->2227|4709->2232|4814->2310|4828->2315|4887->2365|4927->2367|4956->2368|5000->2380|5058->2410|5159->2484|5173->2489|5234->2541|5274->2543|5303->2544|5347->2556|5405->2586|5506->2660|5522->2667|5553->2689|5593->2691|5622->2692|5665->2704|5723->2734|5814->2812|5858->2828|6000->2943|6020->2954|6038->2963|6086->2973|6136->2995|6216->3048|6247->3058|6333->3125|6352->3135|6392->3137|6442->3159|6593->3279|6639->3297|6723->3354|6768->3378|6797->3379|6828->3383|6883->3417|6913->3418|6945->3422|6966->3433|6994->3439|7067->3485|7087->3496|7105->3505|7153->3515|7203->3537|7283->3590|7314->3600|7396->3663|7415->3673|7455->3675|7505->3697|7653->3813|7696->3827|7745->3857|7765->3867|7806->3869|7846->3881|7961->3965|7999->3972
                  LINES: 21->1|24->3|26->18|26->18|28->18|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|30->20|30->20|30->20|30->20|32->8|32->8|38->1|40->4|41->7|42->13|44->17|45->22|47->24|47->24|47->24|49->26|49->26|49->26|51->28|51->28|51->28|51->28|52->29|53->30|53->30|54->31|55->32|57->34|59->36|59->36|59->36|60->37|60->37|60->37|62->39|64->41|64->41|64->41|64->41|68->45|68->45|68->45|68->45|70->47|73->50|73->50|74->51|74->51|75->52|75->52|76->53|76->53|77->54|81->58|81->58|81->58|81->59|81->59|81->59|82->60|83->61|83->61|83->61|83->61|83->61|83->61|85->63|85->63|85->63|85->63|85->63|85->63|86->64|88->66|88->66|88->66|88->66|88->66|88->66|89->67|91->69|91->69|91->69|91->69|91->69|91->69|92->70|94->73|96->75|101->80|101->80|101->80|101->80|102->81|103->82|103->82|105->84|105->84|105->84|106->85|109->88|110->89|111->90|111->90|111->90|111->90|111->90|111->90|111->90|111->90|111->90|113->92|113->92|113->92|113->92|114->93|115->94|115->94|117->96|117->96|117->96|118->97|121->100|122->101|125->104|125->104|125->104|127->106|131->110|134->113
                  -- GENERATED --
              */
          