package com.dilmen.utils;

import com.dilmen.manager.IElasticServiceManager;
import com.dilmen.mapper.IUserMapper;
import com.dilmen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestAndRun {
        private final UserService userService;
        private final IElasticServiceManager elasticUserManager;
        @PostConstruct
        public void init(){
                new Thread(() -> run());
        }

        public void run(){
                try {
                        userService.findAll().forEach(user->{
                                elasticUserManager.save(IUserMapper.INSTANCE.userProfileSaveRequestDtofromUser(user));
                        });
                } catch (Exception exception){
                        System.err.println("TestAndRun Error");
                }
        }

}
