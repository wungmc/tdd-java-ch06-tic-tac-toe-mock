/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeCollectionSpec {
	
	TicTacToeCollection collection;
	
	@Before
	public void before() throws UnknownHostException {
		collection = new TicTacToeCollection();
	}
	
	@Test
	public void whenInstantiatedThenMongoHasDbNameTicTacToe() {
		assertEquals(collection.getMongoCollection().getDBCollection().getDB().getName(), "tic-tac-toe");
	}
	
	@Test
	public void whenInstantiatedThenMongoCollectionHasNameGame() {
		assertEquals(collection.getMongoCollection().getDBCollection().getName(), "game");
	}
	
}
