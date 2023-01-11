# Eseguire RabbitMQ in Docker
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management

# Accedere alla console web localhost:15672 
## Username:guest e Password:guest