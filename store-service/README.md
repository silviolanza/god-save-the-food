## Comandi Maven ed esecuzione Java
mvn clean package 

java -jar target\store-service-0.0.1-SNAPSHOT.jar

## Comandi Docker
docker build -t store-service .

docker run store-service

## Comandi Docker Compose
docker compose up -d

docker compose down -v