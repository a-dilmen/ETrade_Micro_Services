package com.dilmen.service;


import com.dilmen.dto.request.UserProfileSaveRequestDto;
import com.dilmen.mapper.IUserMapper;
import com.dilmen.repository.IUserRepository;
import com.dilmen.repository.entity.User;
import com.dilmen.utils.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceManager<User, String> {
        private final IUserRepository userRepository;
        public UserService(IUserRepository userRepository){
                super(userRepository);
                this.userRepository = userRepository;
        }

        public void saveDto(UserProfileSaveRequestDto dto) {
                userRepository.save(IUserMapper.INSTANCE.userFromUserSaveRequestDto(dto));
        }
}