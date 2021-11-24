package com.zo.sonda.core;

import com.zo.sonda.exceptions.NotEnoughArgumentsException;
import com.zo.sonda.model.Direction;
import com.zo.sonda.model.Planalto;
import com.zo.sonda.model.Pontos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandCenter {

    public List<Pontos> readCommands(String comandos) {
        List<String> listaComandos = comandos.lines().map(String::trim).collect(Collectors.toList());

        String planaltoParams = listaComandos.remove(0);
        Planalto planalto = buildPlanalto(planaltoParams);

        List<Pontos> listaPontos = new ArrayList<>();

        int qtdSondas = listaComandos.size() / 2;
        if (qtdSondas * 2 != listaComandos.size()) {
            throw new NotEnoughArgumentsException("Quantidade insuficiente de comandos.");
        }

        for (int i = 1;  i <= qtdSondas; i++) {
            List<String> pontosParams = Arrays.asList(listaComandos.remove(0).split(" "));

            Pontos pontos = buildPontos(pontosParams);
            char[] movimentos = listaComandos.remove(0).toCharArray();

            for (char c : movimentos) {
                pontos.input(planalto, c);
            }

            listaPontos.add(pontos);
        }

        return listaPontos;
    }

    private static Pontos buildPontos(List<String> params) {
        return new Pontos(
                Integer.parseInt(params.get(0)),
                Integer.parseInt(params.get(1)),
                Direction.valueOf(params.get(2)));
    }

    private static Planalto buildPlanalto(String params) {
        List<Integer> paramsList = Arrays.stream(params.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Planalto(paramsList.get(0), paramsList.get(1));
    }
}
