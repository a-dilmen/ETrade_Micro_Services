package com.dilmen.configuration.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
        private String exchangeDirectAuth = "exchange-direct-auth";
        private String keyAuth = "key-auth";
        private String queueAuthCreateUser = "queue-auth-create-user";
        @Bean
        DirectExchange directExchange(){
                return new DirectExchange(exchangeDirectAuth);
        }
        @Bean
        Queue createAuthUserQueue(){
                return new Queue(queueAuthCreateUser);
        }
        @Bean
        Binding bindingAuthCreateUser(final Queue createAuthUserQueue, final DirectExchange directExchange){
                return BindingBuilder.bind(createAuthUserQueue).to(directExchange).with(keyAuth);
        }

}
