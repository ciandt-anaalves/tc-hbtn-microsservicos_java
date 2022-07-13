package com.example.calculator.controller;

import com.example.calculator.payload.CalculatorSuccessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void messageWelcome() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("Bem vindo à CALCULATOR API REST.")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Bem vindo à CALCULATOR API REST.", response.getMessage());
    }

    @Test
    void addNumbers() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/addNumbers")
                .param("number1", "1")
                .param("number2", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("A soma entre 1.0 e 1.0 é igual a 2.0")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("A soma entre 1.0 e 1.0 é igual a 2.0", response.getMessage());
    }

    @Test
    void addNumbersWithoutParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/addNumbers"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void addNumbersWithInvalidParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/addNumbers")
                .param("number1", "1")
                .param("number2", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void subNumbers() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/subNumbers")
                .param("number1", "1")
                .param("number2", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("A subtração entre 1.0 e 1.0 é igual a 0.0")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("A subtração entre 1.0 e 1.0 é igual a 0.0", response.getMessage());
    }

    @Test
    void subNumbersWithoutParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/subNumbers"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void subNumbersWithInvalidParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/subNumbers")
                .param("number1", "1")
                .param("number2", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void divideNumbers() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/divideNumbers")
                .param("number1", "1")
                .param("number2", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("A divisão entre 1.0 e 1.0 é igual a 1.0")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("A divisão entre 1.0 e 1.0 é igual a 1.0", response.getMessage());
    }

    @Test
    void divideNumbersWithoutParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/divideNumbers"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void divideNumbersWithInvalidParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/divideNumbers")
                .param("number1", "1")
                .param("number2", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void divideNumbersWithDivisionByZero() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/divideNumbers")
                .param("number1", "1")
                .param("number2", "0"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Divisão por zero não é permitido.")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Divisão por zero não é permitido.", response.getMessage());
    }

    @Test
    void multiplyNumbers() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/multiplyNumbers")
                .param("number1", "1")
                .param("number2", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("A multiplição entre 1.0 e 1.0 é igual a 1.0")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("A multiplição entre 1.0 e 1.0 é igual a 1.0", response.getMessage());
    }

    @Test
    void multiplyNumbersWithoutParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/multiplyNumbers"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void multiplyNumbersWithInvalidParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/multiplyNumbers")
                .param("number1", "1")
                .param("number2", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void factorial() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/factorial")
                .param("factorial", "6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("O fatorial de 6 é igual a 720")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("O fatorial de 6 é igual a 720", response.getMessage());
    }

    @Test
    void factorialWithoutParam() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/factorial"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void factorialWithInvalidParam() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/factorial")
                .param("factorial", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void factorialWithNumberNegative() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/factorial")
                .param("factorial", "-1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Não existe fatorial para números negativos.")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Não existe fatorial para números negativos.", response.getMessage());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/calculeDayBetweenDate")
                .param("localDate1", "2020-03-15")
                .param("localDate2", "2020-03-29"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("A diferença (em dias) entre <2020-03-15> e <2020-03-29> é igual a 14")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("A diferença (em dias) entre <2020-03-15> e <2020-03-29> é igual a 14", response.getMessage());
    }

    @Test
    void calculeDayBetweenDateWithoutParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/calculeDayBetweenDate"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void calculeDayBetweenDateWithInvalidParams() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/calculeDayBetweenDate")
                .param("localDate1", "15-03-2020")
                .param("localDate2", "2020-03-29"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void integerToBinary() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/integerToBinary")
                .param("number1", "5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("O binário de 5 é igual a 101")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("O binário de 5 é igual a 101", response.getMessage());
    }

    @Test
    void integerToBinaryWithoutParam() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/integerToBinary"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void integerToBinaryWithInvalidParam() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/integerToBinary")
                        .param("number1", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/integerToHexadecimal")
                        .param("number1", "170"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(200)))
                .andExpect(jsonPath("$.message", is("O hexadecimal de 170 é igual a AA")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("O hexadecimal de 170 é igual a AA", response.getMessage());
    }

    @Test
    void integerToHexadecimalWithoutParam() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/integerToHexadecimal"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Parâmetro Não Informado")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Parâmetro Não Informado", response.getMessage());
    }

    @Test
    void integerToHexadecimalWithInvalidParam() throws Exception {
        ResultActions resultActions = mvc.perform(get("/calculator/integerToHexadecimal")
                        .param("number1", "dsfd"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", is("Formato ou Tipo Incorreto")));

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

        int status = result.getResponse().getStatus();
        assertEquals(400, status);

        CalculatorSuccessResponse response = objectMapper.readValue(contentAsString, CalculatorSuccessResponse.class);
        assertEquals("Formato ou Tipo Incorreto", response.getMessage());
    }

}
