# kotlin-class-access-bug

This project aims to reproduce a bug with Kotlin plugin for
IntelliJ, as described at (https://youtrack.jetbrains.com/issue/KT-26535)

## Project Setup
- Clone this repository
```
git clone https://github.com/cotej/kotlin-class-access-bug
```

- Open the IntelliJ project at `kotlin-class-access-bug/app`
  - This is a Kotlin application, which depends on a Java library `libupper`,
    which in turn depends on another Java library `liblower`.
  - If prompted, configure a Java SDK for the project.
  - Using Maven (either on CLI or in IntelliJ panel), install the libraries
    and compile the app.
```
mvn -f liblower/pom.xml install
mvn -f libupper/pom.xml install
mvn -f app/pom.xml compile
```

   - Open `app/App.kt` in the editor. At this point, all should be well.
     The project compiles in both IntelliJ and Maven, no errors are reported,
     and can be run.
     
## Revealing the Error
- Edit `upperlib/pom.xml` and change the version to `2.0.0`.
- Now we make a trivial change to `app/pom.xml` to force IntelliJ to reload
  its pom.
  - Edit `app/pom.xml` and change the `<name>` element by appending a `.` to the end
- Return to `app/App.kt` in the editor, and suddenly a `Cannot access class` error 
  appears on line 8.
  - However, the project still compiles in IntelliJ and Maven! And it runs!  The `app`
    project still depends on version `1.0.0` of upperlib which is installed in our local
    Maven repository, so there should be no issue.
