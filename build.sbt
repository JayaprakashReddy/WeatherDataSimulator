name := """WeatherDataSimulator"""

version := "1.0"

scalaVersion := "2.10.5"

scalacOptions in (Compile, doc) ++= Seq("-doc-root-content", baseDirectory.value+"/root-doc.txt")

libraryDependencies += "org.scalacheck" % "scalacheck_2.10" % "1.13.0"
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.1"
libraryDependencies += "com.typesafe" % "config" % "1.2.1"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.3.0"
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.3.0"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.2"
libraryDependencies += "log4j" % "log4j" % "1.2.14"
libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "joda-time" % "joda-time" % "2.9.4"
resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

mainClass in ( Compile, run ) := Some("com.jpreddy.tests.weathersimulator.WeatherDataSimulatorApp")


