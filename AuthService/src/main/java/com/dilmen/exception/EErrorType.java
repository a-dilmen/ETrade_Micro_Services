package com.dilmen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {
        BAD_REQUEST_ERROR(1201,"Invalid parameter entry",BAD_REQUEST),
        INTERNAL_ERROR(3000,"Sunucuda beklenmeyen hata",INTERNAL_SERVER_ERROR),
        USER_NOT_FOUND(1111,"User not found",INTERNAL_SERVER_ERROR),
        TOKEN_EROOR(1213,"Token error",INTERNAL_SERVER_ERROR);

        private int code;
        private String message;
        private HttpStatus httpStatus;


}
