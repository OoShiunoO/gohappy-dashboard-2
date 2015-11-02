import Dependency._

name := """common"""

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  scalatest % "test",
  lang3,
  mail,
  joda
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

