package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Test;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

public class TickTackToeBeanSpec {

    private TickTackToeBean bean;
    private final UUID id = UUID.randomUUID();
    private final int x = 2;
    private final int y = 3;
    private final char player = 'X';

    @Before
    public void before() {
        bean = new TickTackToeBean(id, x, y, player);
    }

    @Test
    public void whenInstantiatedThenIdIsStored() {
        assertThat(bean.getId()).isEqualTo(id);
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
