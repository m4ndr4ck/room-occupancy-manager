# Smart Host Codding Challenge  #

## -- Room Occupancy Manager --

## Java Modules and Clean/Hexagonal Architecture

For this application architecture I've defined the following hexagons:

- <b>Domain</b>
  <br> The most critical software code resides on Domain. It's here that we define entities and rules for Guests, Rooms, and so on.<br><br>
- <b>Application</b>
  <br> Application is a place to handle application-specific rules. They are operations not directly related to the domain problem but are needed to fulfill business needs—for example, data transformation, automation, and things like that we put in Application. We execute application specific-rules with Ports and Use Cases.<br><br>
- <b>Framework</b>
  <br> That's the location where we define the technologies that will allow communication with our system. With Adapters, we can expose APIs and connect the application to a database or a filesystem to retrieve data.

In the JPMS (Java Platform Module System) context, each hexagon becomes a module.

There is also an additional module called bootstrap that is responsible for aggregating all the other three modules. This module is in charge of starting the application along with the other modules.


![Hexagonal](src/main/resources/hexagon.png?raw=true)


## Unit Tests

Unit tests are executed on Domain to assure the algorithms and business rules are working as expected.

## Integration Tests

To make sure the APIs are right, we also the endpoint against each test case.

## Architecture Fundamentals

This system shows the basis for cloud-native development with clean architecture principles together with Quarkus Framework. The idea is to develop software ready to be easily integrated into cloud environments based on Docker and Kubernetes. 

With clean architecture, we aim to decrease technical debt in the long run by developing software more loosely coupled.

## To compile and run
```
mvn compile quarkus:dev
```

## To test a request
```
curl -X POST "http://localhost:8080/api/v1/rooms/occupancy" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"freeEconomyRooms\":3,\"freePremiumRooms\":3}"
```

## To generate a Docker Image
```
mvn clean package
docker build . -t room-occupancy-manager:latest
```

## To run the application directly without build
```
docker run -p 8080:8080 s4intlaurent/room-occupancy-manager:latest
```

## To install on Kubernetes (Istio Supported)
```
kubectl apply -f k8s/
```

## Swagger OpenAPI on Azure Cloud for Online Tests
```
http://room-occupancy-manager.centralus.azurecontainer.io:8080/q/swagger-ui/
```