package edu.eci.arep.msc.mystatcal.Persistence.Exceptions;

public class NodesException extends Exception {
    public static final String NOT_EXTEND_YET = "The Insertion of nodes isn't implemented yet";
    public static final String NODE_UNEXPECTED = "The node isn't the right type on the list";
    public static final String INCORRECT_DATATYPE = "Datatype unsupported by linkedlist";
    public static final String LINKEDLIST_EMPTY = "There's any node to delete.";

    public NodesException(String message) {
        super(message);
    }
}
