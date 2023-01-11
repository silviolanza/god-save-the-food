# Eseguire RabbitMQ in Docker (in modalità non persistente)

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management

## per accedere alla console web localhost:15672 
## username: guest e password :guest

# Eseguire RabbitMQ usando Docker-Compose
docker compose up