/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeCollectionSpec {
	
	TicTacToeCollection collection;
	
	@Before
	public void before() throws UnknownHostException {
		collection = spy(TicTacToeCollection.class);
	}
	
	@Test
	public void whenInstantiatedThenMongoHasDbNameTicTacToe() {
		assertEquals(collection.getMongoCollection().getDBCollection().getDB().getName(), "tic-tac-toe");
	}
	
	@Test
	public void whenInstantiatedThenMongoCollectionHasNameGame() {
		assertEquals(collection.getMongoCollection().getDBCollection().getName(), "game");
	}
	
	@Test
	public void whenSaveMoveThenInvokeMongoCollectionSave() {
		// mock 和 spy 的区别：
		// mock 返回一个完全模拟的对象；
		// spy 返回一个监视对象，默认使用对象的实际方法。
		MongoCollection mongoCollection = mock(MongoCollection.class);
		doReturn(mongoCollection).when(collection).getMongoCollection();
		
		TicTacToeBean bean = new TicTacToeBean(1, 2, 1, 'X');
		collection.saveMove(bean);
		// 验证 mongoCollection 是否调用了 save 1次，且参数是 bean
		verify(mongoCollection, times(1)).save(bean);
	}
	
}
