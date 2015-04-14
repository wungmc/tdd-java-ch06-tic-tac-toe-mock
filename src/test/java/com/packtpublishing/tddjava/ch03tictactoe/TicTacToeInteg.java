package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Test;
import java.net.UnknownHostException;
import static org.assertj.core.api.Assertions.assertThat;

//TODO: Add to book
public class TicTacToeInteg {

    @Test
    public void givenMongoDbIsRunningWhenPlayThenNoException() throws UnknownHostException {
        TicTacToe ticTacToe = new TicTacToe();
        assertThat(ticTacToe.play(1, 1)).isEqualTo(TicTacToe.NO_WINNER);
    }

}
