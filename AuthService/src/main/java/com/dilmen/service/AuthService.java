package com.dilmen.service;

import com.dilmen.dto.request.AuthRegisterRequestDto;
import com.dilmen.dto.request.LoginRequestDto;
import com.dilmen.exception.AuthException;
import com.dilmen.exception.EErrorType;
import com.dilmen.manager.IUserManager;
import com.dilmen.mapper.IAuthMapper;
import com.dilmen.repository.IAuthRepository;
import com.dilmen.repository.entity.Auth;
import com.dilmen.utils.JwtTokenManager;
import com.dilmen.utils.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {
        private IAuthRepository authRepository;
        private IUserManager userManager;
        @Autowired
        private JwtTokenManager tokenManager;

        public AuthService(IAuthRepository authRepository, IUserManager userManager) {
                super(authRepository);
                this.authRepository = authRepository;
                this.userManager = userManager;
        }

        public Boolean register(AuthRegisterRequestDto dto) {
                Auth auth = save(IAuthMapper.INSTANCE.authFromAuthRegisterRequestDto(dto));
                userManager.save(IAuthMapper.INSTANCE.userSaveRequestDtoFromAuth(auth));
                return true;
        }

        public String login(LoginRequestDto dto) {
                Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
                if (auth.isEmpty()) throw new AuthException(EErrorType.USER_NOT_FOUND);
                Optional<String> token = tokenManager.createToken(auth.get().getId());
                if (token.isEmpty()) throw new AuthException(EErrorType.TOKEN_EROOR);
                return token.get();
        }
}