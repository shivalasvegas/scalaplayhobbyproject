
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

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Page[scala.Tuple2[Place, Option[PlaceInfo]]],Int,String,MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentPage: Page[(Place, Option[PlaceInfo])], currentOrderBy: Int, currentFilter: String)(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
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
Seq[Any](format.raw/*1.134*/("""

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
                    """),_display_(/*53.22*/header(5, "PlaceInfo")),format.raw/*53.44*/("""
                """),format.raw/*54.17*/("""</tr>
            </thead>
            <tbody>

                """),_display_(/*58.18*/places/*58.24*/.map/*58.28*/ {/*59.21*/case (place, placeInfo) =>/*59.47*/ {_display_(Seq[Any](format.raw/*59.49*/("""
                        """),format.raw/*60.25*/("""<tr>
                            <td><a href=""""),_display_(/*61.43*/routes/*61.49*/.HomeController.edit(place.id.get)),format.raw/*61.83*/("""">"""),_display_(/*61.86*/place/*61.91*/.name),format.raw/*61.96*/("""</a></td>
                            <td>
                                """),_display_(/*63.34*/place/*63.39*/.introduced.map(_.format("dd MMM yyyy")).getOrElse/*63.89*/ {_display_(Seq[Any](format.raw/*63.91*/(""" """),format.raw/*63.92*/("""<em>-</em> """)))}),format.raw/*63.104*/("""
                            """),format.raw/*64.29*/("""</td>
                            <td>
                                """),_display_(/*66.34*/place/*66.39*/.discontinued.map(_.format("dd MMM yyyy")).getOrElse/*66.91*/ {_display_(Seq[Any](format.raw/*66.93*/(""" """),format.raw/*66.94*/("""<em>-</em> """)))}),format.raw/*66.106*/("""
                            """),format.raw/*67.29*/("""</td>
                            <td>
                                """),_display_(/*69.34*/placeInfo/*69.43*/.map(_.name).getOrElse/*69.65*/ {_display_(Seq[Any](format.raw/*69.67*/(""" """),format.raw/*69.68*/("""<em>-</em> """)))}),format.raw/*69.80*/("""
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

  def render(currentPage:Page[scala.Tuple2[Place, Option[PlaceInfo]]],currentOrderBy:Int,currentFilter:String,request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(currentPage,currentOrderBy,currentFilter)(request)

  def f:((Page[scala.Tuple2[Place, Option[PlaceInfo]]],Int,String) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (currentPage,currentOrderBy,currentFilter) => (request) => apply(currentPage,currentOrderBy,currentFilter)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-10-15T12:38:35.492
                  SOURCE: C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/app/views/list.scala.html
                  HASH: 72442384aaba1e592f638185629c62421fe5f9b9
                  MATRIX: 799->1|1004->138|1033->666|1047->672|1157->705|1190->711|1232->726|1260->733|1289->734|1324->742|1378->787|1418->789|1447->791|1530->852|1564->854|1613->876|1656->898|1686->901|1712->906|1752->287|1763->291|2052->133|2082->155|2111->284|2140->549|2172->663|2201->924|2232->929|2244->933|2283->935|2318->943|2369->967|2438->1015|2478->1029|2494->1036|2528->1061|2579->1074|2616->1084|2716->1157|2744->1164|2781->1174|2824->1187|2859->1195|2917->1226|2967->1267|3007->1269|3049->1283|3129->1336|3163->1349|3341->1496|3380->1508|3446->1547|3461->1553|3506->1577|3576->1621|3610->1646|3644->1671|3694->1683|3733->1695|3865->1800|3909->1823|3959->1846|4003->1869|4053->1892|4099->1917|4149->1940|4192->1962|4238->1980|4334->2049|4349->2055|4362->2059|4373->2083|4408->2109|4448->2111|4502->2137|4577->2185|4592->2191|4647->2225|4677->2228|4691->2233|4717->2238|4822->2316|4836->2321|4895->2371|4935->2373|4964->2374|5008->2386|5066->2416|5167->2490|5181->2495|5242->2547|5282->2549|5311->2550|5355->2562|5413->2592|5514->2666|5532->2675|5563->2697|5603->2699|5632->2700|5675->2712|5733->2742|5824->2820|5868->2836|6010->2951|6030->2962|6048->2971|6096->2981|6146->3003|6226->3056|6257->3066|6343->3133|6362->3143|6402->3145|6452->3167|6603->3287|6649->3305|6733->3362|6778->3386|6807->3387|6838->3391|6893->3425|6923->3426|6955->3430|6976->3441|7004->3447|7077->3493|7097->3504|7115->3513|7163->3523|7213->3545|7293->3598|7324->3608|7406->3671|7425->3681|7465->3683|7515->3705|7663->3821|7706->3835|7755->3865|7775->3875|7816->3877|7856->3889|7971->3973|8009->3980
                  LINES: 21->1|24->3|26->18|26->18|28->18|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|29->19|30->20|30->20|30->20|30->20|32->8|32->8|38->1|40->4|41->7|42->13|44->17|45->22|47->24|47->24|47->24|49->26|49->26|49->26|51->28|51->28|51->28|51->28|52->29|53->30|53->30|54->31|55->32|57->34|59->36|59->36|59->36|60->37|60->37|60->37|62->39|64->41|64->41|64->41|64->41|68->45|68->45|68->45|68->45|70->47|73->50|73->50|74->51|74->51|75->52|75->52|76->53|76->53|77->54|81->58|81->58|81->58|81->59|81->59|81->59|82->60|83->61|83->61|83->61|83->61|83->61|83->61|85->63|85->63|85->63|85->63|85->63|85->63|86->64|88->66|88->66|88->66|88->66|88->66|88->66|89->67|91->69|91->69|91->69|91->69|91->69|91->69|92->70|94->73|96->75|101->80|101->80|101->80|101->80|102->81|103->82|103->82|105->84|105->84|105->84|106->85|109->88|110->89|111->90|111->90|111->90|111->90|111->90|111->90|111->90|111->90|111->90|113->92|113->92|113->92|113->92|114->93|115->94|115->94|117->96|117->96|117->96|118->97|121->100|122->101|125->104|125->104|125->104|127->106|131->110|134->113
                  -- GENERATED --
              */
          