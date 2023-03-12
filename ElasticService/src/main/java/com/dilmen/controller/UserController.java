package com.dilmen.controller;

import com.dilmen.dto.request.UserProfileSaveRequestDto;
import com.dilmen.repository.entity.User;
import com.dilmen.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.dilmen.constants.RestEndPoints.*;

@RestController
@RequestMapping(ELASTIC)
@RequiredArgsConstructor
public class UserController {
        private final UserService userService;
        @PostMapping(SAVE)
        private ResponseEntity<Void> save(@RequestBody UserProfileSaveRequestDto dto){
              userService.saveDto(dto);
              return ResponseEntity.ok().build();
        }

        @GetMapping(FINDALL)
        public ResponseEntity<Iterable<User>> findAll(){
                return ResponseEntity.ok(userService.findAll());
        }


}
