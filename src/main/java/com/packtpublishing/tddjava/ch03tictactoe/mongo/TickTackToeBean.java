package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import org.jongo.marshall.jackson.oid.Id;

public class TickTackToeBean {

    @Id
    private int turn;
    public int getTurn() {
        return turn;
    }

    private int x;
    public int getX() {
        return x;
    }

    private int y;
    public int getY() {
        return y;
    }

    private char player;
    public char getPlayer() {
        return player;
    }

    public TickTackToeBean() { }
    public TickTackToeBean(int turn, int x, int y, char player) {
        this.turn = turn;
        this.x = x;
        this.y = y;
        this.player = player;
    }

}
