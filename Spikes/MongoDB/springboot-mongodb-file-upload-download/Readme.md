## File Upload / Download Example using Spring Boot and MongoDB

Tutorial : [File Upload & Download with SpringBoot and MongoDB](https://hansanitharaka.medium.com/file-upload-with-springboot-and-mongodb-76a8f5b9f75d)

## Getting Started
**1. Clone the repository**
```bash
git clone https://github.com/hansitharaka/springboot-mongodb-file-upload-download.git
```
**2. Specify your database**

Open `src/main/resources/application.properties` file and change following properties accordingly.

```properties
spring.data.mongodb.port = [db port]
spring.data.mongodb.host = [host]
spring.data.mongodb.database = [database name]
spring.data.mongodb.username = [username]
spring.data.mongodb.password = [password]
```

## REST end-points
* Upload a File: `http://localhost:8080/file/upload`
* Download a File: `http://localhost:8080/file/download/{id}`

##
The application can be accessed at `http://localhost:8080` or open `src/main/resources/static/index.html` to access frontend

![File upload frontend snapshot](/src/main/resources/images/frontend.png)

## Per il corretto funzionamento dell'esempio bisogna creare in MongoDB un database di nome Uploads
Dunque basta utilizzare MongoDB Express collegandosi se si è usato il Docker-Compose precedente all'url http://localhost:8081

## Successivamente per effettuare la pulizia e la compilazione usare i seguenti comandi
mvn clean package

## In fine per l'esecuzione usare il seguente comando
java -jar target\fileUpload-0.0.1-SNAPSHOT.jar
