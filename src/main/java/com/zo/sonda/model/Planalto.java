package com.zo.sonda.model;

import com.zo.sonda.exceptions.OuterSpaceException;

public class Planalto {
    private final int x;
    private final int y;

    public Planalto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void comparar(Pontos pontos) {
        if ((pontos.getX() > this.x || pontos.getX() < 0)
                || (pontos.getY() > this.y || pontos.getY() < 0)) {
            throw new OuterSpaceException("Sua sonda saiu do planalto e está flutuando no espaço.");
        }
    }
}
