package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.UUID;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TickTackToeCollectionSpec {

    private static TickTackToeCollection collection;
    private static final String dbName = "tick-tack-toe";
    private static final String collectionName = "game";

    @Before
    public void before() throws UnknownHostException {
        collection = new TickTackToeCollection();
    }


    @Test
    public void whenInstantiatedThenMongoCollectionHasDbNameTickTackToe() {
        assertThat(collection.mongoCollection.getDBCollection().getDB().getName()).isEqualTo(dbName);
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() {
        assertThat(collection.mongoCollection.getName()).isEqualTo(collectionName);
    }

    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave() {
        MongoCollection mongoCollection = mock(MongoCollection.class);
        collection.mongoCollection = mongoCollection;
        TickTackToeBean bean = new TickTackToeBean(UUID.randomUUID(), 2, 1, 'Y');
        collection.saveMove(bean);
        verify(mongoCollection, times(1)).save(bean);
    }

}
