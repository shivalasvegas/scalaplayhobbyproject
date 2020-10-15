// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/hobbyScalaProject/playscalaanorm/conf/routes
// @DATE:Tue Oct 13 17:15:50 BST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
