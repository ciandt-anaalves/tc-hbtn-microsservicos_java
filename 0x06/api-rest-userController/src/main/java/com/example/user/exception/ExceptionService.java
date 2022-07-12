package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    ResponseEntity<UserIdException> handleUserIdException(UserIdException err) {
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setMessage("You have entered invalid ID");
        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<UserNameException> handleUserNameException(UserNameException err) {
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setMessage("You have entered invalid USERNAME");
        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<CPFException> handleCpfException(CPFException err) {
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setMessage("You have entered invalid CPF");
        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }

}
