# Smart Host Codding Challenge  #

## -- Room Occupancy Manager --

<<<<<<< HEAD
## Java Modules and Clean/Hexagonal Architecture
=======
**Java Modules and Clean/Hexagonal Architecture**
>>>>>>> 7d2db01... Fix readme

Java 11, Quarkus and Maven are the technologies utilized to build this project.

For this application architecture I've defined the following hexagons:

- **Domain**
  <br> The most critical software code resides on Domain. It's here that we define entities and rules for Guests, Rooms, and so on.   <br><br>
- **Application**
  <br> Application is a place to handle application-specific rules. They are operations not directly related to the domain problem but are needed to fulfill business needs—for example, data transformation, automation, and things like that we put in Application. We execute application specific-rules with Ports and Use Cases.<br><br>
- **Framework**
  <br> That's the location where we define the technologies that will allow communication with our system. With Adapters, we can expose APIs and connect the application to a database or a filesystem to retrieve data.

In the JPMS (Java Platform Module System) context, each hexagon becomes a module.

There is also an additional module called bootstrap that is responsible for aggregating all the other three modules. This module is in charge of starting the application along with the other modules.


![Hexagonal](src/main/resources/hexagon.png?raw=true)

**Architecture Fundamentals**

This system shows the basis for cloud-native development with clean architecture principles together with Quarkus Framework. The idea is to develop software ready to be easily integrated into cloud environments based on Docker and Kubernetes.

With clean architecture, we aim to decrease technical debt in the long run by developing software more loosely coupled.

**Unit Tests**

<<<<<<< HEAD
To make sure the APIs are right, we also the endpoint against each test case.
=======
Unit tests are executed on Domain to assure the algorithms and business rules are working as expected.
>>>>>>> d5a9cb9... Add markdown to Readme

**Integration Tests**

To make sure the APIs are right, we also test the endpoint against each test case. Those tests occur on Framework.


**To compile and run**
```
mvn compile quarkus:dev
```

**To test a request**
```
curl -X POST "http://localhost:8080/api/v1/rooms/occupancy" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"freeEconomyRooms\":3,\"freePremiumRooms\":3}"
```

**To generate a Docker image**
```
mvn clean package
docker build . -t room-occupancy-manager:latest
```

**To run the application directly without build**
```
docker run -p 8080:8080 s4intlaurent/room-occupancy-manager:latest
```

**To install on Kubernetes (Istio supported)**
```
kubectl apply -f k8s/
```

**Swagger OpenAPI on Azure Cloud for online tests**
```
http://room-occupancy-manager.centralus.azurecontainer.io:8080/q/swagger-ui/
```