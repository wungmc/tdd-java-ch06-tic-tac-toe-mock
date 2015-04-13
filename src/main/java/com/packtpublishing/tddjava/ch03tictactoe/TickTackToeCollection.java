package com.packtpublishing.tddjava.ch03tictactoe;

import org.jongo.MongoCollection;

public class TickTackToeCollection {

    private static TickTackToeCollection instance;

    private TickTackToeCollection() { }

    public static TickTackToeCollection getInstance() {
        if (instance == null) {
            instance = new TickTackToeCollection();
        }
        return instance;
    }

}
