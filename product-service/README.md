## Configurare le variabili d'ambiente nel IDE per l'esecuzione le variabili d'ambiente definiscono la connessione al Database

## Comandi Maven ed esecuzione Java
    mvn clean package
    java -jar target\store-service-0.0.1-SNAPSHOT.jar

## Comandi Docker
    docker build -t store-spring-app .
    docker run store-service

## Comandi Docker Compose
    docker-compose build --no-cache
    docker-compose up -d
    docker compose down -v