package com.dilmen.rabbitmq.producer;

import com.dilmen.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {
        private final RabbitTemplate rabbitTemplate;

        public void createSendMessage(CreateUser createUser){
                rabbitTemplate.convertAndSend("exchange-direct-auth","key-auth",createUser);
                rabbitTemplate.convertAndSend(createUser);
        }
}
