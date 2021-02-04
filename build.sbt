name := "poker"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

scalacOptions in (Compile,doc) := Seq("-diagrams")
target in (Compile,doc) := baseDirectory.value / "doc" / "scaladoc"
