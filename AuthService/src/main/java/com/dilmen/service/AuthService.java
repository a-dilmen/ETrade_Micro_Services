package com.dilmen.service;

import com.dilmen.dto.request.AuthRegisterRequestDto;
import com.dilmen.mapper.IAuthMapper;
import com.dilmen.repository.IAuthRepository;
import com.dilmen.repository.entity.Auth;
import com.dilmen.utils.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
        private IAuthRepository authRepository;

        public AuthService(IAuthRepository authRepository) {
                super(authRepository);
                this.authRepository = authRepository;
        }

        public Boolean register(AuthRegisterRequestDto dto){

                save(IAuthMapper.INSTANCE.authFromAuthRegisterRequestDto(dto));
                return true;
        }
}