package com.zo.sonda.model;

public enum Direction {
    E,
    W,
    S,
    N;

    static {
        N.left = W;
        N.right = E;

        W.left = S;
        W.right = N;

        S.left = E;
        S.right = W;

        E.left = N;
        E.right = S;
    }

    private Direction left;
    private Direction right;

    public Direction getLeft() {
        return this.left;
    }

    public Direction getRight() {
        return this.right;
    }
}
