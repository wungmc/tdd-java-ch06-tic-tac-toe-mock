/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

/**
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeCollection {
	private MongoCollection mongoCollection;
	
	public MongoCollection getMongoCollection() {
		return mongoCollection;
	}
	
	public TicTacToeCollection() throws UnknownHostException {
		DB db = new MongoClient().getDB("tic-tac-toe");
		mongoCollection = new Jongo(db).getCollection("game");
	}
	
}
