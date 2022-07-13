package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import com.example.calculator.payload.CalculatorSuccessResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public ResponseEntity<CalculatorSuccessResponse> messageWelcome() {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "Bem vindo à CALCULATOR API REST."));
    }

    @GetMapping("/addNumbers")
    public ResponseEntity<CalculatorSuccessResponse> addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "A soma entre " + n1 + " e " + n2 + " é igual a " + calculator.sum(n1, n2)));
    }

    @GetMapping("/subNumbers")
    public ResponseEntity<CalculatorSuccessResponse> subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "A subtração entre " + n1 + " e " + n2 + " é igual a " + calculator.sub(n1, n2)));
    }

    @GetMapping("/divideNumbers")
    public ResponseEntity<CalculatorSuccessResponse> divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "A divisão entre " + n1 + " e " + n2 + " é igual a " + calculator.divide(n1, n2)));
    }

    @GetMapping("/multiplyNumbers")
    public ResponseEntity<CalculatorSuccessResponse> multiplyNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "A multiplição entre " + n1 + " e " + n2 + " é igual a " + calculator.multiply(n1, n2)));
    }

    @GetMapping("/factorial")
    public ResponseEntity<CalculatorSuccessResponse> factorial(@RequestParam(name = "factorial") Integer factorial) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "O fatorial de " + factorial + " é igual a " + calculator.factorial(factorial)));
    }

    @GetMapping("/calculeDayBetweenDate")
    public ResponseEntity<CalculatorSuccessResponse> calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "A diferença (em dias) entre <" + localDate1 + "> e <" + localDate2 + "> é igual a " + calculator.calculeDayBetweenDate(localDate1, localDate2)));
    }

    @GetMapping("/integerToBinary")
    public ResponseEntity<CalculatorSuccessResponse> integerToBinary(@RequestParam(name = "number1") Integer n1) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "O binário de " + n1 + " é igual a " + calculator.integerToBinary(n1)));
    }

    @GetMapping("/integerToHexadecimal")
    public ResponseEntity<CalculatorSuccessResponse> integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        return ResponseEntity.ok(new CalculatorSuccessResponse(200, "O hexadecimal de " + n1 + " é igual a " + calculator.integerToHexadecimal(n1)));
    }

}

