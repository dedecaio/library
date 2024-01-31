# **_Microservice Application_**
#### This is an application built with Spring Boot 3 and JDK 17.

###### By Caio Flores.

### **Using Docker:**
**Please**, click [here](https://www.docker.com/products/docker-desktop/) to see the tutorial to install docker into your device.
After installed docker, you can download [```docker-compose.yml```](https://github.com/dedecaio/microservices-course/blob/main/docker-compose.yml).

After that, go to the directory where the file is and open a terminal there. Lastly, type the command: ```docker compose up -d```

### **Downloading the project:**
You can also download the zipped project and use it locally without using Docker.
But, don't forget to install that requirements to run the application:
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html);
- [MySQL](https://www.mysql.com/downloads/);
- Java IDE (Of your preference).
###
You will probably have to change the root user's password in each microservice's application.yml.

After installed all, just open the project at the IDE and run the naming-server, cambio-service, book-service, greeting-service and api-gateway.
Running the application, you can also check the documentation to view the endpoints by clicking [here](http://localhost:8765/swagger-ui.html).

If you have any question, please call me via email: [caio.florees2005@gmail.com]()
