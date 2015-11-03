import play.sbt.PlayScala
import sbt._
import Keys._

object Dependency {
  val mysql = "mysql" % "mysql-connector-java" % "5.1.37"
  val joda = "joda-time" % "joda-time" % "2.9"
  val scalatest = "org.scalatest" %% "scalatest" % "2.2.4"
  val lang3 = "org.apache.commons" % "commons-lang3" % "3.4"
  val mail =  "org.apache.commons" % "commons-email" % "1.3.3"
  val akka = "com.typesafe.akka" %% "akka-actor" % "2.3.11"
  val akkatest = "com.typesafe.akka" %% "akka-testkit" % "2.3.11"
}

/**
 * 自定 Builder.
 * 在 SBT 定義中，project 的 scala 程式(Common.scala)，
 * 是專案目錄下 build.sbt (eg: dashboard/build.sbt 的 meta 檔。
 * 也就是說是 build.sbt 的描述檔。
 *
 * 為了讓所有子專案都可以使用到父專案的值，因此將專案的設定改到這。
 */
object DashboardBuild extends Build {

  lazy val commonSettings = Seq(
    organization := "com.feec",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

  lazy val common = (project in file("common")).settings(commonSettings: _*)

  lazy val batch = (project in file("batch-task")).settings(commonSettings: _*).dependsOn(common)

  lazy val root = (project in file(".")).enablePlugins(PlayScala).aggregate(common, batch).settings(commonSettings: _*).dependsOn(common)
}