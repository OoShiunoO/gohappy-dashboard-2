import Dependency._
import DashboardBuild._

name := """dashboard"""

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

/**
 * 執行 dist 前，強制做 clean；也強制 clean common 專案。
 * 以下的 dependsOn 的執行順序是 (clean in common) -> clean
 */
dist <<= dist.dependsOn(clean).dependsOn(clean in common)