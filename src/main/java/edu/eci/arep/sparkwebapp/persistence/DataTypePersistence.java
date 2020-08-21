package edu.eci.arep.sparkwebapp.persistence;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.MyOwnLinkedListException;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

/**
 * The type Data type persistence.
 */
public class DataTypePersistence {

    /**
     * Parse my own linked list.
     *
     * @param data the data
     * @return the my own linked list
     */
    public static MyOwnLinkedList parse(String[] data) {
        MyOwnLinkedList linkedList;
        if (isInteger(data)) {
            linkedList = new MyOwnLinkedList("integer");
        } else if (isDouble(data)) {
            linkedList = new MyOwnLinkedList("double");
        } else {
            linkedList = new MyOwnLinkedList("string");
        }
        for (String s : data) {
            try {
                linkedList.addNode(s);
            } catch (NodesException | MyOwnLinkedListException e) {
                return null;
            }
        }
        return linkedList;
    }

    /**
     * Verify if data is parse to integer
     *
     * @return if data can be parse
     */
    private static boolean isInteger(String[] data) {
        try {
            for (int i = 0; i < data.length; i++) {
                String s = data[i];
                if (!s.equals("")) {
                    Integer.parseInt(s);
                } else {
                    data[i] = "0";
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verify if data is parse to double
     *
     * @return if data can be parse
     */
    private static boolean isDouble(String[] data) {
        try {
            for (int i = 0; i < data.length; i++) {
                String s = data[i];
                if (!s.equals("")) {
                    Double.parseDouble(s);
                } else {
                    data[i] = "0";
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
