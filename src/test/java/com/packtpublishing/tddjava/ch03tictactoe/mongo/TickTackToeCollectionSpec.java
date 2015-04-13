package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.CommandResult;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import java.net.UnknownHostException;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: Add to book
public class TickTackToeCollectionSpec {

    private static TickTackToeCollection collection;
    private static final String dbName = "tick-tack-toe";
    private static final String collectionName = "game";
    private TickTackToeBean bean;

    @Before
    public void before() throws UnknownHostException {
        collection = new TickTackToeCollection();
        bean = new TickTackToeBean(3, 2, 1, 'Y');
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
        collection.saveMove(bean);
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue() {
        MongoCollection mongoCollection = mock(MongoCollection.class);
        collection.mongoCollection = mongoCollection;
        assertThat(collection.saveMove(bean)).isTrue();
    }

    @Test
    public void givenExceptionWhenSaveMoveThenReturnFalse() {
        MongoCollection mongoCollection = mock(MongoCollection.class);
        doThrow(new MongoException("Bla")).when(mongoCollection).save(any(TickTackToeBean.class));
        collection.mongoCollection = mongoCollection;
        assertThat(collection.saveMove(bean)).isFalse();
    }

    @Test
    public void whenDropThenInvokeMongoCollectionDrop() {
        MongoCollection mongoCollection = mock(MongoCollection.class);
        collection.mongoCollection = mongoCollection;
        collection.drop();
        verify(mongoCollection, times(1)).drop();
    }

    @Test
    public void whenDropThenReturnTrue() {
        MongoCollection mongoCollection = mock(MongoCollection.class);
        collection.mongoCollection = mongoCollection;
        assertThat(collection.drop()).isTrue();
    }

    @Test
    public void givenExceptionWhenDropThenReturnFalse() {
        MongoCollection mongoCollection = mock(MongoCollection.class);
        doThrow(new MongoException("Bla")).when(mongoCollection).drop();
        collection.mongoCollection = mongoCollection;
        assertThat(collection.drop()).isFalse();
    }

}
