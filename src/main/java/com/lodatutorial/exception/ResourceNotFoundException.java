package com.lodatutorial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (String message){
        super(message);
        System.out.println("hello world");
        // cho nay massage se duoc day vao trong class cha exception roi dunng handle exception de goi ra

    }
}
