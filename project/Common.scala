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