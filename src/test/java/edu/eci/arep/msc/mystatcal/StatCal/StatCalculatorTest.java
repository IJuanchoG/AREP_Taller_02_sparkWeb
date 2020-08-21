package edu.eci.arep.msc.mystatcal.StatCal;


import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class StatCalculatorTest {
    MyOwnLinkedList linkedList;

    @Before
    public void crearLinkedList(){
        try {
            linkedList = new MyOwnLinkedList("1","integer");
            linkedList.addNode("2", "integer");
            linkedList.addNode("8", "integer");
            linkedList.addNode("6", "integer");
            linkedList.addNode("4", "integer");
        } catch (NodesException | MyOwnLinkedListException e) {
            fail("No deberia");
        }
    }

    @Test
    public void deberiaSumar(){
        String sum = StatCalculator.Sum(linkedList);
        Assert.assertTrue(sum.matches("21"));
    }

    @Test
    public void noDeberiaSumar(){
        String sum = StatCalculator.Sum(linkedList);
        Assert.assertFalse(sum.matches("8"));
    }
    @Test
    public void deberiaPromediar(){
        String mean = StatCalculator.Mean(linkedList);
        Assert.assertEquals(4.2,Double.valueOf(mean),0.2);
    }

    @Test
    public void noDeberiaPromediar(){
        String mean = StatCalculator.Mean(linkedList);
        Assert.assertNotEquals(4,Double.valueOf(mean),0.2);
    }

    @Test
    public void deberiaDeviation(){
        String deviation = StatCalculator.Deviation(linkedList);
        Assert.assertEquals(2.86,Double.valueOf(deviation),0.1);
    }
    @Test
    public void noDeberiaDeviation(){
        String deviation = StatCalculator.Deviation(linkedList);
        Assert.assertNotEquals(3,Double.valueOf(deviation),0.1);
    }
}
