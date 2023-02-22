## Configurare le variabili d'ambiente nel IDE per l'esecuzione le variabili d'ambiente definiscono la connessione al Database

## Comandi Maven ed esecuzione Java
    mvn clean package
    java -jar target\customer-service-0.0.1-SNAPSHOT.jar

## Comandi Docker
    docker build -t customer-spring-app .
    docker run customer-service

## Comandi Docker Compose
    docker-compose build --no-cache
    docker-compose up -d
    docker compose down -v

## Comandi MiniKube
    minikube start
    minikube dashboard --url
    minikube stop
## Comando Docker-HUB push image
    docker build -t silviolanza/customer-spring-app:latest .
    docker push silviolanza/customer-spring-app:latest

## Comandi Kubectl
    kubectl apply -f .
    kubectl delete -f .
    kubectl get po

## Comandi per ricavare URL service di MiniKube
    kubectl get services --all-namespaces
    minikube service customer-spring-app --url -n slanza
