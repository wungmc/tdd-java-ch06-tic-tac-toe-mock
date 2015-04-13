package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TickTackToeBeanSpec {

    private TickTackToeBean bean;
    private final int turn = 17;
    private final int x = 2;
    private final int y = 3;
    private final char player = 'X';

    @Before
    public void before() {
        bean = new TickTackToeBean(turn, x, y, player);
    }

    @Test
    public void whenInstantiatedThenIdIsStored() {
        assertThat(bean.getTurn()).isEqualTo(turn);
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertThat(bean.getX()).isEqualTo(x);
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertThat(bean.getY()).isEqualTo(y);
    }

    @Test
    public void whenInstantiatedThenPlayerIsStored() {
        assertThat(bean.getPlayer()).isEqualTo(player);
    }

}
