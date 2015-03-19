# Spring Boot Restful Web Services with Swagger Documentation and Docker Image creation

Spring Boot is the framework to create standalone production ready restful web services. This opens the way for designing SAAS solution as microservices. Traditionally Spring MVC application which used to provide restful apis would be generated as a war. In case of Spring Boot it is created as a jar. This jar file also includes the application server (tomcat/jetty). The reason we call Spring Boot Production ready is because it provides numerous features out of the box. Few examples of these are autoconfig, which can be looked at as convention for production configuration. Additional End Points to monitor and gauge the health of the system. Other end points also provies you metrics, thread trace etc. These can be turned on or off.

## Future Integration with Netflix Microservices framework via Spring Cloud
More over Sprint Boot is appealing because it can easily integrate with Netflix OSS (Microservices framework) via Spring Cloud. With Spring Cloud, you can 
* launch a central configuration server and all other servers will fetch configuration from that
* launch a Service Discovery registery to discover services
* launch a Circuit Breaker server which injects a fallback mechanism in your code when certain services go down
* launch a API Gateway for security, proxy (to consolidate web services) etc

All these servers are spring boot servers and most of the time require only one Application class with few Spring Cloud Annotations.

## Documenting the Web Services
Swagger is a tool to 
* provide auto generated docummentation for your restful apis
* provide a UI playground to test your restful apis
* provide code generators to generate iOS, Android, Java, C# restful clients 

This projects shows an example of how you can integrate Swagger to document the restful apis


## Gradle build to churn our Docker Images as Artifact along side Executable Jars
With the advent of Docker the focus changes from creating application binary as artifacts to creating complete Dockerized Image of your application (or part of your application like a microservices). This project show an example as to how a gradle code creates a Docker Image for the Business Application. This image can be launched on laptop, QA machines, Staging and Even in Production and will behave exactly the same way.

