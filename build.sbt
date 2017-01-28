name := "akka-http-gzip"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-core" % "10.0.2",
  "com.typesafe.akka" %% "akka-http" % "10.0.2",
  "com.typesafe.akka" %% "akka-actor" % "2.4.16"
)
