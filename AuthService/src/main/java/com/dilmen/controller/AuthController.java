package com.dilmen.controller;

import com.dilmen.dto.request.AuthRegisterRequestDto;
import com.dilmen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dilmen.constants.RestEndPoints.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
        private final AuthService authService;

        @PostMapping(REGISTER)
        public ResponseEntity<Boolean> register(@RequestBody AuthRegisterRequestDto dto) {
                authService.register(dto);
                return ResponseEntity.ok(true);
        }

}
