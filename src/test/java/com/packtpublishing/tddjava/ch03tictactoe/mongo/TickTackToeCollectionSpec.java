package com.packtpublishing.tddjava.ch03tictactoe.mongo;

import com.mongodb.MongoException;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import java.net.UnknownHostException;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: Add to book
public class TickTackToeCollectionSpec {

    private static TickTackToeCollection collection;
    MongoCollection mongoCollection;
    private static final String dbName = "tick-tack-toe";
    private static final String collectionName = "game";
    private TickTackToeBean bean;

    @Before
    public void before() throws UnknownHostException {
        collection = spy(new TickTackToeCollection());
        mongoCollection = mock(MongoCollection.class);
        bean = new TickTackToeBean(3, 2, 1, 'Y');
    }


    @Test
    public void whenInstantiatedThenMongoCollectionHasDbNameTickTackToe() {
        assertThat(collection.getMongoCollection().getDBCollection().getDB().getName()).isEqualTo(dbName);
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() {
        assertThat(collection.getMongoCollection().getName()).isEqualTo(collectionName);
    }

    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveMove(bean);
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertThat(collection.saveMove(bean)).isTrue();
    }

    @Test
    public void givenExceptionWhenSaveMoveThenReturnFalse() {
        doThrow(new MongoException("Bla")).when(mongoCollection).save(any(TickTackToeBean.class));
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertThat(collection.saveMove(bean)).isFalse();
    }

    @Test
    public void whenDropThenInvokeMongoCollectionDrop() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.drop();
        verify(mongoCollection, times(1)).drop();
    }

    @Test
    public void whenDropThenReturnTrue() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertThat(collection.drop()).isTrue();
    }

    @Test
    public void givenExceptionWhenDropThenReturnFalse() {
        doThrow(new MongoException("Bla")).when(mongoCollection).drop();
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertThat(collection.drop()).isFalse();
    }

}
