package edu.eci.arep.msc.mystatcal.Persistence.Exceptions;

public class MyOwnLinkedListException extends Exception {
    public static final String INVALID_DATATYPE = "Datatype is incorrect, please verify it";

    public MyOwnLinkedListException(String message) {
        super(message);
    }

}
