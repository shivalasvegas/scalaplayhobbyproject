// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/shivaking/Documents/CC_SCALAPROJECTS/scalaplayhobbyproject/playframeworkhobby/conf/routes
// @DATE:Tue Jan 05 08:14:42 GMT 2021


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
