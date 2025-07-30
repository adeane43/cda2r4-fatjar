To build the JAR:

1. Clone the https://github.com/amida-tech/cda2r4 repository
2. (Optional) alter the semantic version in the `pom.xml` of cda2r4
3. Run `mvn install` in the root directory of cda2r4 which will add it to your local mvn repo
4. Set the correct version string in [./build.sbt](./build.sbt)
5. Run `sbt assembly`
6. JAR will be output to `./target/scala-3.7.1/cda2r4.jar`
