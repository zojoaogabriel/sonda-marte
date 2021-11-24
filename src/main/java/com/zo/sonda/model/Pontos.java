package com.zo.sonda.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Pontos {

    private int x;
    private int y;
    private Direction direction;

    public Pontos(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }

    private void mover() {
        switch (this.direction) {
            case E:
                this.setX(this.x + 1);
                break;
            case N:
                this.setY(this.y + 1);
                break;
            case S:
                this.setY(this.y - 1);
                break;
            case W:
                this.setX(this.x - 1);
                break;
        }
    }

    public void input(Planalto planalto, char comando) {
        switch (comando) {
            case 'L':
                this.setDirection(this.direction.getLeft());
                break;
            case 'R':
                this.setDirection(this.direction.getRight());
                break;
            case 'M':
                mover();
                planalto.comparar(this);
                break;
            default:
                throw new IllegalStateException("Comando não reconhecido: " + comando);
        }
    }
}
