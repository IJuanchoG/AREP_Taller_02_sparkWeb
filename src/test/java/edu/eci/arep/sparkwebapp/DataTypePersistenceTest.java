package edu.eci.arep.sparkwebapp;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;
import edu.eci.arep.sparkwebapp.persistence.DataTypePersistence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class DataTypePersistenceTest {
    MyOwnLinkedList linkedList;
    String[] dataString, dataDouble, dataInteger;
    @Before
    public void createLinkedList(){
        try {
            linkedList = new MyOwnLinkedList("1","integer");
            linkedList.addNode("2");
            linkedList.addNode("8");
            linkedList.addNode("6");
            linkedList.addNode("4");
        } catch (NodesException | MyOwnLinkedListException e) {
            fail("It should not fail");
        }
    }
    @Before
    public void createStringData(){
        dataInteger = new String[]{"1","2","3","4","5","6"};
        dataDouble = new String[]{"1.2","2.4","3.4","5"};
        dataString = new String[]{"Ciao","Hello","Hej","Hola","Ohayou"};
    }
    @Test
    public void shouldCreate(){
        MyOwnLinkedList parse = DataTypePersistence.parse(dataDouble);
        Assert.assertNotEquals(parse,null);
        MyOwnLinkedList parse1 = DataTypePersistence.parse(dataInteger);
        Assert.assertNotEquals(parse1,null);
        MyOwnLinkedList parse2 = DataTypePersistence.parse(dataString);
        Assert.assertNotEquals(parse2,null);
    }
    @Test
    public void shouldAssignTypeDouble(){
        MyOwnLinkedList parse = DataTypePersistence.parse(dataDouble);
        assert parse != null;
        Assert.assertEquals(parse.getDataType(),"double");
    }
    @Test
    public void shouldAssignTypeInteger(){
        MyOwnLinkedList parse = DataTypePersistence.parse(dataInteger);
        assert parse != null;
        Assert.assertEquals(parse.getDataType(),"integer");
    }
    @Test
    public void shouldAssignTypeString(){
        MyOwnLinkedList parse = DataTypePersistence.parse(dataString);
        assert parse != null;
        Assert.assertEquals(parse.getDataType(),"string");
    }

}
