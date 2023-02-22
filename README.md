## Comando Docker-HUB per la compilazione ed il push delle immagini aggiornate dei servizi su docker-hub
    docker build --no-cache -t silviolanza/product-spring-app:latest ./product-service
    docker push silviolanza/product-spring-app:latest
	
    docker build --no-cache -t silviolanza/store-spring-app:latest ./store-service
    docker push silviolanza/store-spring-app:latest
	
    docker build --no-cache -t silviolanza/order-spring-app:latest ./order-service
    docker push silviolanza/order-spring-app:latest
	
    docker build --no-cache -t silviolanza/customer-spring-app:latest ./customer-service
    docker push silviolanza/customer-spring-app:latest

## Comandi Kubectl per il deploy su Kubernetes
    kubectl apply -f customer-service/k8s/. -f order-service/k8s/. -f store-service/k8s/. -f product-service/k8s/.
    kubectl delete -f customer-service/k8s/. -f order-service/k8s/. -f store-service/k8s/. -f product-service/k8s/.
    kubectl get po
