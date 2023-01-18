## Esempio di file Upload / Download utilizzando Spring Boot e MongoDB

Tutorial : [File Upload & Download with SpringBoot and MongoDB](https://hansanitharaka.medium.com/file-upload-with-springboot-and-mongodb-76a8f5b9f75d)

##

Aprire il file `src/main/resources/application.properties` e notare le seguenti properties
dove vengono definiti i parametri di connessione al database mongo.

```properties
spring.data.mongodb.port = ${MONGO_DB_PORT}
spring.data.mongodb.host = ${MONGO_DB_HOST}
spring.data.mongodb.database = ${MONGO_DB_NAME}
spring.data.mongodb.username = ${MONGO_DB_USER}
spring.data.mongodb.password = ${MONGO_DB_PASS}
```
##

Aprire il file `pom.xml` e notare il plugin usato per il testing `maven-surefire-plugin`
all'interno del quale vengono specificati i valori delle variabili d'ambiente da usare
per la fase di testing del codice.

```plugins
			<plugin>
        		<groupId>org.apache.maven.plugins</groupId>
				<!-- 	Si tratta di un plugin usato nel testing per passare le giuste variabili
						d'ambiente del server di Mongo le quali dovranno essere successivamente 
						specificate nel Dockerfile	 -->
        		<artifactId>maven-surefire-plugin</artifactId>
        		<configuration>
           			<environmentVariables>
                		<MONGO_DB_PORT>27017</MONGO_DB_PORT>
						<MONGO_DB_HOST>localhost</MONGO_DB_HOST>
						<MONGO_DB_NAME>local</MONGO_DB_NAME>
						<MONGO_DB_USER>root</MONGO_DB_USER>
						<MONGO_DB_PASS>example</MONGO_DB_PASS>
            		</environmentVariables>
       		 	</configuration>
    		</plugin>
```

## REST end-points
* Upload a File: `http://localhost:8080/file/upload`
* Download a File: `http://localhost:8080/file/download/{id}`

##
L'applicazzione è accessibile dal link: `http://localhost:8080` 
o aprendo il file del front-end: `src/main/resources/static/index.html`

![File upload frontend snapshot](/src/main/resources/images/frontend.png)

## Per il corretto funzionamento dell'esempio bisogna installere MongoDB attraverso Docker-Compose

## Successivamente per effettuare la pulizia e la compilazione usare i seguenti comandi
mvn clean package && java -jar target\fileUpload-0.0.1-SNAPSHOT.jar

## In fine per l'esecuzione usare il seguente comando
java -jar target\fileUpload-0.0.1-SNAPSHOT.jar