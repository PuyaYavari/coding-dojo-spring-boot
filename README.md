Spring Boot Coding Dojo
---

Welcome to my Spring Boot Coding Dojo!

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. I was surprisingly busy the past month so this assignment took a little long but the important thing is I am happy with the result.

### Technologies

#### [PostgreSQL](https://www.postgresql.org/)

PostgreSQL is used to store the data.

#### [Maven](https://maven.apache.org/)

Maven is the preferred build automation tool.

#### [Docker](https://www.docker.com/)

The application runs inside a Docker Linux container. Docker sets up everything needed for the application on the container start; it sets up the database, tests and packages application using maven, and lastly automatically starts the application. This isolates the application from the host OS and makes deployment easier.

#### [Springfox](https://github.com/springfox/springfox)

Used to generate Swagger documentation.

#### [Mapstruct](https://mapstruct.org/)

Used to map OpenWeatherResponse model to entities.

#### [SLF4J](http://www.slf4j.org/)

Logging is done using slf4j. Logging is kept simple due to the small size of the application.

#### [JUnit](https://junit.org/junit5/)

Used for unit and integration tests.

#### [JUnitParams](https://github.com/Pragmatists/JUnitParams)

Pragmatists's JUnitParams is used in order to manage test params.

#### [MockServer](https://www.mock-server.com/)

Used to mock [OpenWeather](https://openweathermap.org/) for tests.

#### [TestContainers](https://www.testcontainers.org/)

Used to mock database for tests.

### Architecture

I kept the architecture simple and straightforward. There are eight main packages:

* **Controllers** 
* **Entities** 
* **Handlers** 
* **Mappers**
* **Models**
* **Repositories**
* **Services**

Models and Services both have subpackages. 

For Models the subpackage is externals, which contains models of the external
services; this package also contains of subpackages for each external service being used. 

Services package contains the services of the application. These services are separated into
three main groups.
1. Normal domain specific services which are directly under services package.
2. Core Services which are under services.core package. These services are not domain specific and are used by other services for domain specific purposes.
3. External services which are under services.external package. These services are used to communicate with external services like apis.

### Deployment

You need Docker with Linux containers backend to be able to run the application.

You also have to have an [OpenWeather api key](https://openweathermap.org/appid) (you can use the one I sent in my email).

Last step is to create a .env file (or use the one I sent in my email) containing `DBUser` and `DBPassword`.

After you completed all the requirements you can run `docker-compose build --build-arg "AppId={YourOpenWeatherAppId}"` to build the containers
and then run `docker-compose up` to start the application.

### Error Handling

In case of any errors an error model is being returned to the client. The error model contains a code and a message.
Message is the message of the problem that caused the error. Code is a unique indicator of any problem and error. In
programs current state error codes are as below:

|Code|Meaning|
|----|-------|
|1000|Unknown Error|
|1001-1999|Internal Server Errors|
|2000|Missing City Parameter|
|2001|No Data Found For Given City|
|2002-9999|Other Client Related Errors|

