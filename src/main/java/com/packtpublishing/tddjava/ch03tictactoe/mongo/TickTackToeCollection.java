package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

public class TickTackToeCollection {

    protected static MongoCollection mongoCollection;
    private static final String dbName = "tick-tack-toe";
    private static final String collectionName = "game";

    public TickTackToeCollection() throws UnknownHostException {
        DB db = new MongoClient().getDB(dbName);
        mongoCollection = new Jongo(db).getCollection(collectionName);
    }

    public void saveMove(TickTackToeBean bean) {
        mongoCollection.save(bean);
    }

}
