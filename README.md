## Comando Docker-HUB per il push delle immagini aggiornate su docker-hub
    docker build -t silviolanza/store-spring-app:latest ./store-service/
    docker push silviolanza/store-spring-app:latest

## Comandi Kubectl per il deploy su Kubernetes
    kubectl apply -f customer-service/k8s/. -f order-service/k8s/. -f store-service/k8s/. -f product-service/k8s/.
    kubectl delete -f customer-service/k8s/. -f order-service/k8s/. -f store-service/k8s/. -f product-service/k8s/.
    kubectl get po
