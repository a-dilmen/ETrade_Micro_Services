package com.dilmen.service;

import com.dilmen.dto.request.UserSaveRequestDto;
import com.dilmen.mapper.IUserMapper;
import com.dilmen.repository.IUserRepository;
import com.dilmen.repository.entity.User;
import com.dilmen.utils.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceManager<User,Long> {
        private IUserRepository userRepository;

        public UserService(IUserRepository userRepository) {
                super(userRepository);
                this.userRepository = userRepository;
        }

        public Boolean saveDto(UserSaveRequestDto dto) {
                save(IUserMapper.INSTANCE.userFromUserSaveRequestDto(dto));
                return true;
        }

//        public Boolean register(AuthRegisterRequestDto dto){
//
//                save(IUserMapper.INSTANCE.authFromAuthRegisterRequestDto(dto));
//                return true;
//        }
}