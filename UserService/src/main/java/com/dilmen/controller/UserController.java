package com.dilmen.controller;

import com.dilmen.dto.request.UserSaveRequestDto;
import com.dilmen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.dilmen.constants.RestEndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
        private final UserService userService;

        @PostMapping(SAVE)
        public ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto) {
                return ResponseEntity.ok(userService.saveDto(dto));
        }

}
