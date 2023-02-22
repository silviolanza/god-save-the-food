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

## Links per il testing dei microservizi

### store-service
    Per l'inizializzazione del db con un dataset di test:
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/stores/init
    
    Per accedere a Mongo Express (user: admin@admin.com     pass: root):
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/stores/express
    
	Per effettuare la ricerca di un negozio per nome:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/stores/name/Stratta
	
	Per avere la lista dei negozio disponibili per una specifica categoria:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/stores/category/pasticceria
### product-service
    Per l'inizializzazione del db con un dataset di test:
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/products/init
    
    Per accedere a Mongo Express (user: admin@admin.com     pass: root):
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/products/express
    
	Per effettuare la ricerca di un prodotto per nome:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/products/name/Gianduiotti
	
	Per avere la lista dei prodotti di uno specifico negozio:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/products/store/1234
### customer-service
    Per accedere a pgAdmin 4 (user: admin@admin.com     pass: root):
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/customers/pgadmin
    
	Per effettuare la ricerca di un cliente per mail:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/customers/profile/email/silviolanza@gmail.com
	
	Per effettuare la ricerca di un cliente per codice fiscale:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/customers/profile/cf/lcaodn95m28f698k
	
	Per avere la lista di tutti i clienti:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/customers
### order-service
    Per l'inizializzazione del db con un dataset di test:
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/orders/init

    Per accedere a pgAdmin 4 (user: admin@admin.com     pass: root):
    http://gsf.mastercc.hpc4ai.unito.it/api/v1/orders/pgadmin
	
	Per avere la lista di tutti gli ordini:
	http://gsf.mastercc.hpc4ai.unito.it/api/v1/orders