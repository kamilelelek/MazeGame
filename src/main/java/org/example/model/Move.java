package org.example.model;

public class Move implements Comparable<Move> {
    int x;
    int y;
    int g;  //how many moves the program did before
    int h; //heuristic method-how many moves left us to reach the destination(meta)
    int f; //f=g+h
    Move lastMove;

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
                ", g=" + g +
                ", h=" + h +
                ", f=" + f +
                ", lastMove=" + lastMove +
                '}';
    }

    public Move(int x, int y, int g, int h, Move lastMove) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = h + g;
        this.lastMove = lastMove;
    }

    public int getF() {
        return f;
    }

    public int getH() {
        return h;
    }

    public int getG() {
        return g;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public static int dynamicDistance(int x, int y, int x1, int y1) {
        return Math.abs(x1 - x) + Math.abs(y1 - y);
    }

    @Override
    public int compareTo(Move o) {
        return Integer.compare(this.getF(), o.getF());
    }
}
