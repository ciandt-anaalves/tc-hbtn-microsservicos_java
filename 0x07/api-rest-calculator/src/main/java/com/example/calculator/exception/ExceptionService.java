package com.example.calculator.exception;

import com.example.calculator.payload.CalculatorErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    ResponseEntity<CalculatorException> handleCalculatorException(CalculatorException err) {
        CalculatorErrorResponse calculatorErrorResponse = new CalculatorErrorResponse();
        calculatorErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        calculatorErrorResponse.setMessage(err.getMessage());
        return new ResponseEntity(calculatorErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<MissingServletRequestParameterException> handleMissingServletRequestParameterException(MissingServletRequestParameterException err) {
        CalculatorErrorResponse calculatorErrorResponse = new CalculatorErrorResponse();
        calculatorErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        calculatorErrorResponse.setMessage("Parâmetro Não Informado");
        return new ResponseEntity(calculatorErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<MethodArgumentTypeMismatchException> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException err) {
        CalculatorErrorResponse calculatorErrorResponse = new CalculatorErrorResponse();
        calculatorErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        calculatorErrorResponse.setMessage("Formato ou Tipo Incorreto");
        return new ResponseEntity(calculatorErrorResponse, HttpStatus.BAD_REQUEST);
    }

}