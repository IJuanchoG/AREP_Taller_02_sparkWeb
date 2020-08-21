package edu.eci.arep.msc.mystatcal;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;
import edu.eci.arep.msc.mystatcal.StatCal.StatCalculator;

/**
 * Lista encadadenada propuesta por
 *
 * @author Juan Carlos Garcia
 */
public class App {
    /**
     * The Linked list.
     */
    MyOwnLinkedList linkedList;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new App();

    }


    /**
     * Instantiates a new App.
     */
    public App() {
        linkedList = new MyOwnLinkedList("double");
        System.out.println("First Case: ");
        LlenarListaCaso1();
        MostrarLista();
        CalcularDesviacion();
        CalcularDesviacionRedondeada();
        linkedList = new MyOwnLinkedList("double");
        System.out.println("Second Case: ");
        LlenarListaCaso2();
        MostrarLista();
        CalcularDesviacion();
        CalcularDesviacionRedondeada();
    }

    /**
     * Realiza la adicion de informacion en una linkedlist
     */
    public void LlenarListaCaso1() {
        try {
            linkedList.addNode("160", "double");
            linkedList.addNode("591", "double");
            linkedList.addNode("114", "double");
            linkedList.addNode("229", "double");
            linkedList.addNode("230", "double");
            linkedList.addNode("270", "double");
            linkedList.addNode("128", "double");
            linkedList.addNode("1657", "double");
            linkedList.addNode("624", "double");
            linkedList.addNode("1503", "double");
        } catch (NodesException | MyOwnLinkedListException e) {
            e.printStackTrace();
        }

    }

    /**
     * realiza el llenado de informacion de una linkedlist
     */
    public void LlenarListaCaso2() {
        try {
            linkedList.addNode("15", "double");
            linkedList.addNode("69.9", "double");
            linkedList.addNode("6.5", "double");
            linkedList.addNode("22.4", "double");
            linkedList.addNode("28.4", "double");
            linkedList.addNode("65.9", "double");
            linkedList.addNode("19.4", "double");
            linkedList.addNode("198.7", "double");
            linkedList.addNode("38.8", "double");
            linkedList.addNode("138.2", "double");
        } catch (NodesException | MyOwnLinkedListException e) {
            e.printStackTrace();
        }

    }

    /**
     * Realiza los calculos correspondientes a la informacion contenida en la Linkedlist
     */
    public void CalcularDesviacion() {
        System.out.println("Desviacion");
        System.out.println("Sum: " + StatCalculator.Sum(linkedList));
        System.out.println("Mean: " + StatCalculator.Mean(linkedList));
        System.out.println("Deviation: " + StatCalculator.Deviation(linkedList) + "\n");
    }

    /**
     * Realiza los calculos correspondientes, pero genera un redondeo de dos digitos a la informacion
     */
    public void CalcularDesviacionRedondeada() {
        System.out.println("Desviacion Redondeada");
        String sum = StatCalculator.Sum(linkedList);
        String mean = StatCalculator.Mean(linkedList);
        String deviation = StatCalculator.Deviation(linkedList);
        System.out.println("Sum: " + StatCalculator.Round(Double.parseDouble(sum), 2));
        System.out.println("Mean: " + StatCalculator.Round(Double.parseDouble(mean), 2));
        System.out.println("Deviation: " + StatCalculator.Round(Double.parseDouble(deviation), 2) + "\n");
    }

    /**
     * Muestra la linkedlist
     */
    public void MostrarLista() {
        System.out.println(linkedList);
    }
}
