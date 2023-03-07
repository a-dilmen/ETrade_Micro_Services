package com.dilmen.service;

import com.dilmen.dto.request.UserSaveRequestDto;
import com.dilmen.exception.EErrorType;
import com.dilmen.exception.UserException;
import com.dilmen.mapper.IUserMapper;
import com.dilmen.repository.IUserRepository;
import com.dilmen.repository.entity.User;
import com.dilmen.utils.JwtTokenManager;
import com.dilmen.utils.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
        private IUserRepository userRepository;
        @Autowired
        private JwtTokenManager tokenManager;

        public UserService(IUserRepository userRepository) {
                super(userRepository);
                this.userRepository = userRepository;
        }

        public Boolean saveDto(UserSaveRequestDto dto) {
                save(IUserMapper.INSTANCE.userFromUserSaveRequestDto(dto));
                return true;
        }

        public List<User> getAll(String token) {
                Optional<Long> authId = tokenManager.getIdFromToken(token);
                if (authId.isEmpty()) throw new UserException(EErrorType.INVALID_TOKEN);
                Optional<User> user = userRepository.findOptionalByAuthId(authId.get());
                if (user.isEmpty()) throw new UserException(EErrorType.INVALID_TOKEN,"No user found with given token");
                return findAll();
        }


//        public Boolean register(AuthRegisterRequestDto dto){
//
//                save(IUserMapper.INSTANCE.authFromAuthRegisterRequestDto(dto));
//                return true;
//        }
}