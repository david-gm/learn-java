# Maven

## Create a new maven project:
```shell
mvn archetype:generate -DgroupId=com.polymorphism.app -DartifactId=ex4Polymorphism -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

where the parameters are:
- `groupId:`  This is generally unique amongst an organization or a project. For example, all core Maven artifacts do (well, should) live under the groupId org.apache.maven. Group ID's do not necessarily use the dot notation, for example, the junit project. Note that the dot-notated groupId does not have to correspond to the package structure that the project contains. It is, however, a good practice to follow. When stored within a repository, the group acts much like the Java packaging structure does in an operating system. The dots are replaced by OS specific directory separators (such as '/' in Unix) which becomes a relative directory structure from the base repository. 
- `artifactId:` The artifactId is generally the name that the project is known by.
- `version:` This is the last piece of the naming puzzle. groupId:artifactId denotes a single project but they cannot delineate which incarnation of that project we are talking about.
- `archetypeArtifactId:` In short, Archetype is a Maven project templating toolkit.
- `archetypeVersion:` version of archetype

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>my-project</artifactId>
    <version>1.0</version>
</project>
```

## Lifecycle goals

- to build your targets, Maven offers several lifecycle-goals:

| goal        | description |
|-------------|-------------|
| validate    | validate the project is correct and all necessary information is available |
| compile     | compile the source code of the project |
| test        | test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed |
| package     | take the compiled code and package it in its distributable format, such as a JAR. |
| verify      | run any checks on results of integration tests to ensure quality criteria are met |
| install     | install the package into the local repository, for use as a dependency in other projects locally |
| deploy      | done in the build environment, copies the final package to the remote repository for sharing with other developers and projects. |

- the default packaging is JAR, but WAR or others can be configured
- process of building your app:
```shell
mvn clean # cleanse target folder
mvn compile # compiles to source code
mvn package # package source code to JAR
```

## To create executable JAR

```xml
<build>
  <plugins>
    <plugin>
      <!-- Build an executable JAR -->
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-jar-plugin</artifactId>
      <version>3.1.0</version>
      <configuration>
        <archive>
          <manifest>
            <addClasspath>true</addClasspath>
            <classpathPrefix>lib/</classpathPrefix>
            <mainClass>com.mypackage.MyClass</mainClass>
          </manifest>
        </archive>
      </configuration>
    </plugin>
  </plugins>
</build>

```

## Add javadoc plugin:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-javadoc-plugin</artifactId>
      <version>3.2.0</version>
      <configuration>
      </configuration>
    </plugin>
  </plugins>
</build>
```
execute:

```shell
 mvn javadoc:javadoc
 ```