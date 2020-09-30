
lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """playframeworkHobby""",
    organization := "com.qa",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.3",

    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "com.typesafe.play" %% "play" % "2.8.2",
      "org.reactivemongo" %% "reactivemongo" % "1.0.0",
      "org.reactivemongo" %% "reactivemongo-play-json-compat" % "1.0.0-play28"

    ),

    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    ))

routesGenerator := InjectedRoutesGenerator




