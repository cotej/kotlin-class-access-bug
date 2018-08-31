# kotlin-class-access-bug

mvn -f liblower/pom.xml install
mvn -f libupper/pom.xml install
mvn -f app/pom.xml compile

now bump version of upper-lib to 2.0.0
mvn -f upperlib/pom.xml install

then force reload by changing app/pom.xml with a trivial detail
->  error revealed!
