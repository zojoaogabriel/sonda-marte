package com.zo.sonda;

import com.zo.sonda.exceptions.NotEnoughArgumentsException;
import com.zo.sonda.model.Direction;
import com.zo.sonda.model.Planalto;
import com.zo.sonda.model.Pontos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String str = "5 5 \n 1 2 N \n LMLMLMLMM \n 3 3 E \n MMRMMRMRRM";

        List<String> ls = str.lines().map(String::trim).collect(Collectors.toList());

        List<String> planaltoParams = Arrays.asList(ls.remove(0).split(" "));
        Planalto planalto = new Planalto(Integer.parseInt(planaltoParams.get(0)), Integer.parseInt(planaltoParams.get(1)));

        List<Pontos> todosPontos = new ArrayList<>();

        int qtdSondas = ls.size() / 2;
        if (qtdSondas * 2 != ls.size()) {
            throw new NotEnoughArgumentsException("Quantidade insuficiente de comandos.");
        }

        for (int i = 1;  i <= qtdSondas; i++) {
            List<String> pontosParams = Arrays.asList(ls.remove(0).split(" "));

            Pontos pontos = getPontos(pontosParams);

            char[] movimentos = ls.remove(0).toCharArray();
            for (char c : movimentos) {
                pontos.input(planalto, c);
            }
            todosPontos.add(pontos);
        }

        System.out.println(todosPontos);
    }

    private static Pontos getPontos(List<String> params) {
        return new Pontos(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                Direction.valueOf(params.get(2)));
    }
}
