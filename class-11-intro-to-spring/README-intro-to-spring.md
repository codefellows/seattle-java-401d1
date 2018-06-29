# ![CF](http://i.imgur.com/7v5ASc8.png) Intro to Spring MVC

## Resources
* [Spring Guides: Serving Web Content](https://spring.io/guides/gs/serving-web-content/)
* [Deploying Spring MVC to Heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)

## Learning Objectives
* Students will be able to configure a Java project with Spring dependencies.
* Students will be able to start a local server that serves static content.
* Students will be able to write controllers with routes that carry in
  information via URL parameters
* Students will be able to write server-side templates that render information
  inside a webpage before server it to the user.
* Students will be able to deploy their Spring server to Heroku and access it.

## Lecture Outline
* Introduce Spring MVC as a framework for Java web server that saves us from
  writing our own TCP/HTTP servers manually.
* Configure gradle to have Spring dependencies.
* Run a simple Spring server locally.
* Return simple string responses.
* Serve static content.
* Configure a route with URL parameters.
  
## Code Samples
**build.gradle**
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.7.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'

jar {
    baseName = 'gs-serving-web-content'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-devtools")
    testCompile("junit:junit")
}
```


**src/main/java/hello/HelloController.java**
```
package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
```

**src/main/java/hello/Application.java**
```java
package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
