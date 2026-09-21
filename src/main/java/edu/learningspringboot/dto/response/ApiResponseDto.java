package edu.learningspringboot.dto.response;

import java.time.Instant;

public record ApiResponseDto<T>(
    boolean success,
    String message,
    int status,
    T data,
    Instant timestamp,
    String path
) {

    public static<T> ApiResponseDto<T> success(
        String message,
        int status,
        T data,
        String path
    ){

        return new ApiResponseDto<T>(
            true, 
            message,
            status, 
            data, 
            Instant.now(), 
            path);
    }


    //me
    public void hello(){
        System.out.println("Hello");
    }
}
