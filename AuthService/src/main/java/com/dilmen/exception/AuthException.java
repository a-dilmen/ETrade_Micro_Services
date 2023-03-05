package com.dilmen.exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException{
        private EErrorType errorType;

        public AuthException(EErrorType errorType){
                super(errorType.getMessage());
                this.errorType = errorType;
        }public AuthException(EErrorType errorType, String message){
                super(message);
                this.errorType = errorType;
        }


}
