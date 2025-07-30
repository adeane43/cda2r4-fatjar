ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.1"

val cda2FhirVersion =  "0.1.3"

javacOptions ++= Seq("--release", "21")
scalacOptions ++= Seq("-release", "21")

resolvers += Resolver.mavenLocal

// CDA2R4 package from local maven
libraryDependencies ++= Seq(
  "tr.com.srdc" % "cda2fhir" % cda2FhirVersion,
  // CDA library
  "org.openehealth.ipf.modules" % "ipf-modules-cda-mdht" % "4.5.0",
  "org.openehealth.ipf.oht.mdht" % "ipf-oht-mdht-uml-cda-consol" % "1.2.0.201212201425"
)

assembly / assemblyJarName := "cda2r4.jar"
assembly / assemblyMergeStrategy := {
  //  case PathList("META-INF", xs @ _*) if xs.nonEmpty && xs.head.startsWith("ca/uhn/fhir") =>
  //    MergeStrategy.deduplicate // FHIR needs this
  case PathList("META-INF", "services", xs @ _*) => MergeStrategy.concat
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case path if path.endsWith("module-info.class") => MergeStrategy.discard
  case path if path.endsWith(".class") => MergeStrategy.deduplicate
  case _ => MergeStrategy.first
}

lazy val root = (project in file("."))
  .settings(
    name := "cda2r4"
  )