package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "BEM VINDO A API REST DA LOTERIA MEGA SENA USANDO SPRING SECURITY !!!";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        return generateIntegerListWithRandomNumbers(6, 1, 60);
    }

    private List<Integer> generateIntegerListWithRandomNumbers(int size, int lowerBound, int upperBound) {
        Set<Integer> setRandom = new LinkedHashSet<Integer>();
        while (setRandom.size() < size) {
            setRandom.add((int) (Math.random() * (upperBound + 1 - lowerBound) + lowerBound));
        }

        List<Integer> result = new ArrayList<Integer>(setRandom);

        Collections.sort(result);

        return result;
    }

}
