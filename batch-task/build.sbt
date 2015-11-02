import Dependency._

name := """batch-task"""

libraryDependencies ++= Seq(
  akka,
  akkatest % "test",
  scalatest %  "test")

val prod = config("prod")

val preprod = config("pre-prod")

inConfig(prod)(Defaults.configSettings ++ baseAssemblySettings ++ Defaults.resourceConfigPaths ++ Seq (
  assemblyJarName := s"${name.value}-production-${version.value}.jar",
  resourceDirectory := { baseDirectory.value / "src" / "prod" / "resources" },
  test in assembly := {}
))

inConfig(preprod)(Defaults.configSettings ++ baseAssemblySettings ++ Defaults.resourceConfigPaths ++ Seq (
  assemblyJarName := s"${name.value}-pre-prod-${version.value}.jar",
  resourceDirectory := baseDirectory.value / "src" / "pre-prod" / "resources",
  test in assembly := {}
))

/* 做 assembly 前，都強制先做 clean */
assembly <<= assembly.dependsOn(clean)

assembly in prod <<= (assembly in prod).dependsOn(clean)

assembly in preprod <<= (assembly in preprod).dependsOn(clean)
