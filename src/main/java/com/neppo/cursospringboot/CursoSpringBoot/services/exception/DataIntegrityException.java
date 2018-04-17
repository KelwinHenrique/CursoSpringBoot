package com.neppo.cursospringboot.CursoSpringBoot.services.exception;

public class DataIntegrityException extends RuntimeException{
    public DataIntegrityException(String msg){
        super(msg);
    }
    public DataIntegrityException(String msg, Throwable cause){
        super(msg, cause);
    }
}
