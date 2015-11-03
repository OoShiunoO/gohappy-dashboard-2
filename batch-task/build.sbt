import Dependency._
import DashboardBuild._ /* import 父專案上的 DashboardBuild, 來讀取 common 設定 */

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

/**
 *
 * 執行 assembly 前，強制做 clean；也強制 clean common 專案。
 * 以下的 dependsOn 的執行順序是 (clean in common) -> clean
 */
assembly <<= assembly.dependsOn(clean).dependsOn(clean in common)

assembly in prod <<= (assembly in prod).dependsOn(clean).dependsOn(clean in common)

assembly in preprod <<= (assembly in preprod).dependsOn(clean).dependsOn(clean in common)
