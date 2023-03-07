package com.dilmen.rabbitmq.consumer;

import com.dilmen.rabbitmq.model.CreateUser;
import com.dilmen.repository.entity.User;
import com.dilmen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {
        private final UserService userService;
        @RabbitListener(queues = "queue-auth-create-user")
        public void createUserConsumerListener(CreateUser createUser){
                System.out.println("Incoming message..:  "+createUser);
                userService.save(User.builder()
                                .authId(createUser.getAuthid())
                                .email(createUser.getEmail())
                                .username(createUser.getUsername())
                        .build());
        }
}
