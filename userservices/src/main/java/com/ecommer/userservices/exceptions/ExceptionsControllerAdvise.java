package com.ecommer.userservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice// gloable exception handlers
public class ExceptionsControllerAdvise {
    @ExceptionHandler(UserNotFoundException.class)// user not found exception
    public ResponseEntity<MessageResponseDto> userNotFound(UserNotFoundException e){
        MessageResponseDto dto=new MessageResponseDto(
                e.getMessage(),
                404,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNotFoundException.class)// email not found exception
    public ResponseEntity<MessageResponseDto> emailNotFound(EmailNotFoundException e){
        MessageResponseDto dto=new MessageResponseDto(
                e.getMessage(),
                404,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RoleNotFoundExceptions.class)// role not exists exception
    public ResponseEntity<MessageResponseDto>roleNotFound(RoleNotFoundExceptions e){
        MessageResponseDto dto=new MessageResponseDto(
                e.getMessage(),
                404,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SignUpUserException.class)// sign up exception is user not exists
    public ResponseEntity<MessageResponseDto>signupexpention(SignUpUserException e){
        MessageResponseDto dto=new MessageResponseDto(
                e.getMessage(),
                500,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExists.class)// user already exists exception
    public ResponseEntity<MessageResponseDto>userAlreadyExits(UserAlreadyExists e){
        MessageResponseDto dto=new MessageResponseDto(
                e.getMessage(),
                404,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NotCorrectEmailProvidedException.class)// wrong email provided exception
    public ResponseEntity<MessageResponseDto> notCorrectEmail(NotCorrectEmailProvidedException e){
        MessageResponseDto dto=new MessageResponseDto(
                e.getMessage(),
                404,
                LocalDateTime.now()

        );
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
