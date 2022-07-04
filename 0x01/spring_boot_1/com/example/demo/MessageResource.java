package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.getUser().isEmpty() || loginRequest.getUser().isBlank() || loginRequest.getPassword().isEmpty() || loginRequest.getPassword().isBlank()) {
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        }

        if (loginRequest.getUser().length() > 15 || loginRequest.getPassword().length() > 15) {
            return "USUÁRIO E SENHA INVÁLIDOS";
        }

        return "LOGIN EFETUADO COM SUCESSO !!!";
    }

    public static class LoginRequest {
        String user;
        String password;

        public LoginRequest(String user, String password) {
            this.user = user;
            this.password = password;
        }

        public String getUser() {
            return user;
        }

        public String getPassword() {
            return password;
        }

    }

}
