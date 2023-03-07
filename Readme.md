## RabbitMQ

    docker run -d --hostname my-rabbit --name rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=user rabbitmq:3-management
