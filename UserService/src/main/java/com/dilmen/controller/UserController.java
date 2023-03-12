package com.dilmen.controller;

import com.dilmen.dto.request.BaseRequestDto;
import com.dilmen.dto.request.UserSaveRequestDto;
import com.dilmen.repository.entity.User;
import com.dilmen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

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
        @GetMapping(FINDALL)
        public ResponseEntity<List<User>> getAll(@Valid BaseRequestDto dto){
                return ResponseEntity.ok(userService.getAll(dto.getToken()));
        }
        @GetMapping("/getname")
        public ResponseEntity<String > getUpperName(String name){
                return ResponseEntity.ok(userService.getUpperName(name));
        }

        @GetMapping("/clearcache")
        public ResponseEntity<String > clearCache(){
                userService.clearCache();
                return ResponseEntity.ok().build();
        }

}
