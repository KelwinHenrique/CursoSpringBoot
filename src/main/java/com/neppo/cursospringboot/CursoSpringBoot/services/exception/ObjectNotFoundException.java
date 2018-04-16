package com.neppo.cursospringboot.CursoSpringBoot.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String msg){
        super(msg);
    }
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
