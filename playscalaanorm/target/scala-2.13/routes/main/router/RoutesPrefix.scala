// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/shiva/Documents/AA_PROJECTS/AA_scala/playExamples/play-samples/play-scala-anorm-example/conf/routes
// @DATE:Sat Oct 10 11:34:41 BST 2020


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
