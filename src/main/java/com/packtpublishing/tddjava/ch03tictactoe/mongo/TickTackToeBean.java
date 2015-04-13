package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import org.jongo.marshall.jackson.oid.Id;

import java.util.UUID;

public class TickTackToeBean {

    @Id
    private UUID id;
    public UUID getId() {
        return id;
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
    public TickTackToeBean(UUID id, int x, int y, char player) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.player = player;
    }

}
