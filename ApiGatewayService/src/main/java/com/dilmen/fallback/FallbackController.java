package com.dilmen.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallbackController {
        @GetMapping("/fallbackauth")
        public ResponseEntity<String> fallbackauth(){
                return ResponseEntity.ok("Auth service is currently unavailable please try again later");
        }
        @GetMapping("/fallbackuser")
        public ResponseEntity<String> fallbackuser(){
                return ResponseEntity.ok("User service is currently unavailable please try again later");
        }
        @GetMapping("/fallbackproduct")
        public ResponseEntity<String> fallbackproduct(){
                return ResponseEntity.ok("Product service is currently unavailable please try again later");
        }
        @GetMapping("/fallbacksales")
        public ResponseEntity<String> fallbacksales(){
                return ResponseEntity.ok("Sales service is currently unavailable please try again later");
        }
}
