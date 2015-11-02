import Dependency._

name := """dashboard"""

lazy val commonSettings = Seq(
  organization := "com.feec",
  version := "1.0",
  scalaVersion := "2.11.7"
)

lazy val common = (project in file("common")).settings(commonSettings: _*)

lazy val batch = (project in file("batch-task")).settings(commonSettings: _*)

lazy val root = (project in file(".")).enablePlugins(PlayScala).aggregate(common, batch).settings(commonSettings: _*)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

/* 執行 dist 前，強制做 clean */
dist <<= dist.dependsOn(clean)