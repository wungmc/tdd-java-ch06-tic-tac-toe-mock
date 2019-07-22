/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeCollectionSpec {
	
	@Test
	public void whenInstantiatedThenMongoHasDbNameTicTacToe() throws UnknownHostException {
		TicTacToeCollection collection = new TicTacToeCollection();
		assertEquals(collection.getMongoCollection().getDBCollection().getDB().getName(), "tic-tac-toe");
	}
	
}
