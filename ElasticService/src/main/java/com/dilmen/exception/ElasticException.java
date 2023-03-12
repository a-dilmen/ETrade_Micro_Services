package com.dilmen.exception;

import lombok.Getter;

@Getter
public class ElasticException extends RuntimeException{
        private EErrorType errorType;

        public ElasticException(EErrorType errorType){
                super(errorType.getMessage());
                this.errorType = errorType;
        }public ElasticException(EErrorType errorType, String message){
                super(message);
                this.errorType = errorType;
        }


}
