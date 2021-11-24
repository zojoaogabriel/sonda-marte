package com.zo.sonda.controller;

import com.zo.sonda.core.CommandCenter;
import com.zo.sonda.model.Pontos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SondaController {

    private final CommandCenter commandCenter;

    public SondaController(CommandCenter commandCenter) {
        this.commandCenter = commandCenter;
    }

    @PostMapping(value = "sonda")
    ResponseEntity<String> marsComms(@RequestBody String commands) {
        List<Pontos> pontos = commandCenter.readCommands(commands);

        String pontosResponse = pontos.stream().map(Pontos::toString).collect(Collectors.joining("\n"));

        return ResponseEntity.ok(pontosResponse);
    }
}
