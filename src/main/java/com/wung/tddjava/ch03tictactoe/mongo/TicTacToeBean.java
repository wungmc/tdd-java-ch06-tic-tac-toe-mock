/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe.mongo;

import org.jongo.marshall.jackson.oid.Id;

import java.util.Objects;

/**
 * 保存每步棋的bean
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeBean {
	/**
	 * 轮次（从1开始，依次递增）
	 */
	@Id
	private int turn;
	
	private int x;
	
	private int y;
	
	private char player;
	
	public TicTacToeBean() {
	
	}
	
	public TicTacToeBean(int turn, int x, int y, char player) {
		this.turn = turn;
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public char getPlayer() {
		return player;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TicTacToeBean that = (TicTacToeBean) o;
		return turn == that.turn &&
				x == that.x &&
				y == that.y &&
				player == that.player;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(turn, x, y, player);
	}
}
