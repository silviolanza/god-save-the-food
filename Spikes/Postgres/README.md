# Eseguire Postgres e pgAdmin4 usando Docker-Compose
Esegui il comando docker-compose up, attendi per il completamento.
## PGadmin4
è un interfaccia grafica per il controllo del database postgres
puoi accedere all'interfaccia tramite il link http://localhost:5050
per accedere puoi usare le seguenti credenziali specificate nel
docker-compose file 
### Email: test@test.com
### Passw: admin
la prima volta che esegui l'acceso hai bisogno di connettere
il client di pgAdmin4 al server del database postgress usando
i seguenti paramentri configurabili nel docker-compose file
### host: postgres_container
### user: user
### pass: admin
