lazy val commonSettings = Seq(
 organization := "com.manju.twitter",
 name := "twitter-sentiment",
 version := "1.0",
 scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
 "org.apache.spark" %% "spark-core" % "2.4.4" % "provided",
 "org.apache.spark" %% "spark-mllib" % "2.4.4" % "provided",
 "org.apache.spark" %% "spark-sql" % "2.4.4" % "provided",
 "org.apache.bahir" %% "spark-streaming-twitter" % "2.3.3",
 "org.apache.kafka" % "kafka-clients" % "2.3.0",
 "com.typesafe" % "config" % "1.3.4",
 "org.scalatest" %% "scalatest" % "3.0.8" % "test",
 "com.google.cloud" % "google-cloud-language" % "1.90.0"
)

lazy val shaded = (project in file("."))
 .settings(commonSettings)

mainClass in (Compile, packageBin) := Some("com.manju.twitter.TwitterStreaming")

assemblyMergeStrategy in assembly := {
   case PathList("META-INF", xs @ _*) => MergeStrategy.discard
   case x => MergeStrategy.first
}

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("com.google.common.**" -> "repackaged.com.google.common.@1").inAll
)
