/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import com.mongodb.MongoException;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeCollectionSpec {
	
	TicTacToeCollection collection;
	MongoCollection mongoCollection;
	TicTacToeBean bean;
	
	
	@Before
	public void before() throws UnknownHostException {
		collection = spy(TicTacToeCollection.class);
	 	mongoCollection = mock(MongoCollection.class);
		bean = new TicTacToeBean(1, 2, 1, 'X');
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
		doReturn(mongoCollection).when(collection).getMongoCollection();
		
		collection.saveMove(bean);
		// 验证 mongoCollection 是否调用了 save 1次，且参数是 bean
		verify(mongoCollection, times(1)).save(bean);
	}
	
	@Test
	public void whenSaveMoveThenReturnTrue() {
		doReturn(mongoCollection).when(collection).getMongoCollection();
		
		assertTrue(collection.saveMove(bean));
	}
	
	@Test
	public void givenExceptionWhenSaveMoveThenReturnFalse() {
		doThrow(new MongoException("bla")).when(mongoCollection).save(any(TicTacToeBean.class));
		doReturn(mongoCollection).when(collection).getMongoCollection();
		assertFalse(collection.saveMove(bean));
	}
	
	@Test
	public void whenDropThenInvokeMongoCollectionDrop() {
		doReturn(mongoCollection).when(collection).getMongoCollection();
		
		collection.drop();
		verify(mongoCollection, times(1)).drop();
	}
	
}
