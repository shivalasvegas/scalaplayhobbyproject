
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
      "com.adrianhurt" %% "play-bootstrap" % "1.6.1-P28-B4"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    ))






