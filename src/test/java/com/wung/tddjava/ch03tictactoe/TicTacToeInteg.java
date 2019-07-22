/*
 * Copyright (C), 2011-2019.
 */
package com.wung.tddjava.ch03tictactoe;

import org.junit.Test;

import java.net.UnknownHostException;

/**
 * 集成测试例子。
 *
 * 当然，由于没有安装 mongo ，所以这个集成测试是失败的。
 * 当安装了 mongo 并启动后，该用例应该通过才对。
 *
 * @author wung 2019-07-22.
 */
public class TicTacToeInteg {
	
	@Test
	public void givenMongoDbIsRunningWhenPlayThenNoException() throws UnknownHostException {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.play(2, 1);
		
	}
	
}
