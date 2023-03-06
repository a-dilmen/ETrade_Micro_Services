package com.dilmen.controller;

import com.dilmen.dto.request.AuthRegisterRequestDto;
import com.dilmen.dto.request.LoginRequestDto;
import com.dilmen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.dilmen.constants.RestEndPoints.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
        private final AuthService authService;

        @PostMapping(REGISTER)
        public ResponseEntity<Boolean> register(@RequestBody @Valid AuthRegisterRequestDto dto) {
                authService.register(dto);
                return ResponseEntity.ok(true);
        }

        @PostMapping(LOGIN)
        public ResponseEntity<String > login(@RequestBody @Valid LoginRequestDto dto){
                return ResponseEntity.ok(authService.login(dto));
        }

        @GetMapping("/test")
        public ResponseEntity<String> test(){
                return ResponseEntity.ok("hurray");
        }

}
