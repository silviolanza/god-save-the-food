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

## Comandi MiniKube
    minikube start
    minikube dashboard --url
    minikube stop
    minikube service mongodb-express-service --url -n mongodb-namespace

## Comando Docker-HUB push image
    docker build -t silviolanza/store-spring-app:0.1 .
    docker push silviolanza/store-spring-app:0.1

## Comandi Kubectl
    kubectl apply -f .
    kubectl delete -f .
    kubectl get po

## Comandi per ricavare URL service di MiniKube
    kubectl get services --all-namespaces
    minikube service mongodb-express-service --url -n mongodb-namespace
    minikube service store-spring-app --url -n mongodb-namespace
