package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TickTackToeCollectionSpec {

    private TickTackToeCollection collection = TickTackToeCollection.getInstance();

    @Test
    public void whenGetInstanceThenSameInstance() {
        TickTackToeCollection newCollection = TickTackToeCollection.getInstance();
        assertThat(newCollection).isSameAs(collection);
    }

}
