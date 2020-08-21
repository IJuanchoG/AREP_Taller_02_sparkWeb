package edu.eci.arep.msc.mystatcal.LinkedList;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class MyOwnLinkedListTest {

    @Test
    public void deberiaAgregar(){
        MyOwnLinkedList linkedList = new MyOwnLinkedList("double");
        try {
            linkedList.addNode("4", "double");
            Assert.assertTrue("Se agrego correctamente", linkedList.getSize() == 1);
        } catch (NodesException e) {
            fail("Ha lanzado error en Nodos");
        } catch (MyOwnLinkedListException e) {
            fail("Ha lanzado error en MyOwnLinkedList");
        }

    }

    @Test
    public void deberiaAgregarString(){
        MyOwnLinkedList linkedList = new MyOwnLinkedList("string");
        try {
            boolean aDouble = linkedList.addNode("4", "string");
            Assert.assertTrue("Se agrego correctamente", linkedList.getSize() == 1);
        } catch (NodesException e) {
            fail("Ha lanzado error en Nodos");
        } catch (MyOwnLinkedListException e) {
            fail("Ha lanzado error en MyOwnLinkedList");
        }

    }


    @Test
    public void deberiaAgregar2(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","double");
            boolean aDouble = linkedList.addNode("4", "double");
            Assert.assertTrue("Se agrego correctamente", linkedList.getSize() == 2);
        } catch (NodesException e) {
            fail("Ha lanzado error en Nodos");
        } catch (MyOwnLinkedListException e) {
            fail("Ha lanzado error en MyOwnLinkedList");
        }

    }

    @Test
    public void deberiaAgregar2String(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","string");
            boolean aDouble = linkedList.addNode("4", "string");
            Assert.assertTrue("Se agrego correctamente", linkedList.getSize() == 2);
        } catch (NodesException e) {
            fail("Ha lanzado error en Nodos");
        } catch (MyOwnLinkedListException e) {
            fail("Ha lanzado error en MyOwnLinkedList");
        }

    }
    @Test
    public void noDeberiaAgregar1(){
        MyOwnLinkedList linkedList = new MyOwnLinkedList("double");
        try {
            boolean aDouble = linkedList.addNode("4", "Lel");
            fail("Agrego");
        } catch (NodesException e) {
            fail("Excepcion incorrecta");
        } catch (MyOwnLinkedListException e) {
            Assert.assertTrue("Excepcion correcta", e.getMessage().matches(MyOwnLinkedListException.INVALID_DATATYPE));
        }

    }

    @Test
    public void noDeberiaAgregarString(){
        MyOwnLinkedList linkedList = new MyOwnLinkedList("string");
        try {
            boolean aDouble = linkedList.addNode("4", "Lel");
            fail("Agrego");
        } catch (NodesException e) {
            fail("Excepcion incorrecta");
        } catch (MyOwnLinkedListException e) {
            Assert.assertTrue("Excepcion correcta", e.getMessage().matches(MyOwnLinkedListException.INVALID_DATATYPE));
        }

    }

    @Test
    public void noDeberiaAgregar2(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","double");
            boolean aDouble = linkedList.addNode("4", "lel");
            fail("Agrego");
        } catch (NodesException e) {
            fail("Excepcion incorrecta");
        } catch (MyOwnLinkedListException e) {
            Assert.assertTrue("Excepcion correcta", e.getMessage().matches(MyOwnLinkedListException.INVALID_DATATYPE));
        }

    }

    @Test
    public void noDeberiaAgregar2String(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","string");
            boolean aDouble = linkedList.addNode("4", "xD");
            fail("Agrego");
        } catch (NodesException e) {
            fail("Excepcion incorrecta");
        } catch (MyOwnLinkedListException e) {
            Assert.assertTrue("Excepcion correcta", e.getMessage().matches(MyOwnLinkedListException.INVALID_DATATYPE));
        }

    }

    @Test
    public void deberiaEliminar(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","integer");

            linkedList.addNode("4", "integer");
            linkedList.addNode("7", "integer");
            linkedList.addNode("45", "integer");
            linkedList.addNode("442", "integer");
            linkedList.addNode("44", "integer");
            linkedList.addNode("341", "integer");
            Node node = linkedList.lastNode();
            Node last = linkedList.removeLastNode();
            Assert.assertTrue(node.equals(last));

        } catch (NodesException | MyOwnLinkedListException e) {
            fail("Excepcion incorrecta"+e.getMessage());
        }

    }

    @Test
    public void deberiaEliminarString(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","string");

            linkedList.addNode("4", "string");
            linkedList.addNode("7", "string");
            linkedList.addNode("45", "string");
            linkedList.addNode("442", "string");
            linkedList.addNode("44", "string");
            linkedList.addNode("341", "string");
            Node node = linkedList.lastNode();
            Node last = linkedList.removeLastNode();
            Assert.assertTrue(node.equals(last));

        } catch (NodesException | MyOwnLinkedListException e) {
            fail("Excepcion incorrecta"+e.getMessage());
        }

    }

    @Test
    public void noDeberiaEliminar(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("integer");
            Node last = linkedList.removeLastNode();
            fail("It doesn't let remove");

        } catch (NodesException e) {
            Assert.assertTrue(e.getMessage().matches(NodesException.LINKEDLIST_EMPTY));
        }

    }

    @Test
    public void deberiaLastCorrecto(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","integer");

            linkedList.addNode("4", "integer");
            linkedList.addNode("7", "integer");
            linkedList.addNode("45", "integer");
            linkedList.addNode("442", "integer");
            Node node = linkedList.priorNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            Node last = linkedList.removeLastNode();
            Assert.assertTrue(node.equals(last));

        } catch (NodesException | MyOwnLinkedListException e) {
            fail("Excepcion incorrecta: "+e.getMessage());
        }

    }

    @Test
    public void deberiaLastCorrecto2(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","integer");

            linkedList.addNode("4", "integer");
            linkedList.addNode("7", "integer");
            linkedList.addNode("45", "integer");
            linkedList.addNode("442", "integer");
            Node node = linkedList.priorNode().getRightNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            Node last = linkedList.removeLastNode();
            Assert.assertTrue(node.equals(last));

        } catch (NodesException | MyOwnLinkedListException e) {
            fail("Excepcion incorrecta: "+e.getMessage());
        }

    }

    @Test
    public void noDeberiaLastCorrecto(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","integer");

            linkedList.addNode("4", "integer");
            linkedList.addNode("7", "integer");
            linkedList.addNode("45", "integer");
            linkedList.addNode("442", "integer");
            Node node = linkedList.lastNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            linkedList.removeLastNode();
            Node last = linkedList.removeLastNode();
            Assert.assertFalse(node.equals(last));

        } catch (NodesException | MyOwnLinkedListException e) {
            fail("Excepcion incorrecta: "+e.getMessage());
        }
    }
}