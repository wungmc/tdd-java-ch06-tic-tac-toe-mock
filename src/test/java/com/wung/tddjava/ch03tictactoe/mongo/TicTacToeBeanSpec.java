/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * equals 和 hashCode 方法是 IDEA 自动生成的，所以，不需要测。
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeBeanSpec {

	private static final int turn = 1;
	private static final int x = 1;
	private static final int y = 2;
	private static final char player = 'X';
	
	
	private TicTacToeBean ticTacToeBean;
	
	@Before
	public void before() {
		ticTacToeBean = new TicTacToeBean(turn, x, y, player);
	}
	
	@Test
	public void whenInstantiatedThenTurnIsStored() {
		assertEquals(ticTacToeBean.getTurn(), turn);
	}
	
	@Test
	public void whenInstantiatedThenXIsStored() {
		assertEquals(ticTacToeBean.getX(), x);
	}
	
	@Test
	public void whenInstantiatedThenYIsStored() {
		assertEquals(ticTacToeBean.getY(), y);
	}

	@Test
	public void whenInstantiatedThenPlayerIsStored() {
		assertEquals(ticTacToeBean.getPlayer(), player);
	}
	
}
