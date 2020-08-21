package edu.eci.arep.sparkwebapp;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.sparkwebapp.persistence.DataTypePersistence;
import edu.eci.arep.sparkwebapp.persistence.RestPersistence;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * The type Spark web app.
 */
public class SparkWebApp {

    private static MyOwnLinkedList linkedList = null;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        port(getPort());
        get("/datos", SparkWebApp::inputDataPage);
        get("/table", SparkWebApp::putDataPage);
        get("/results", SparkWebApp::resultsPage);
    }

    /**
     * Put the data in a table
     * @param req request on the server
     * @param res response on the server
     * @return String HTML info
     */
    private static String putDataPage(Request req, Response res) {
        String[] data1 = req.queryParams("data1").split(",");
        linkedList = DataTypePersistence.parse(data1);
        if (linkedList != null) {
            return RestPersistence.getHTMLTable(linkedList);
        }
        return "We don't have correct information.";
    }

    /**
     * Input Data on the server
     * @param req request on the server
     * @param res response on the server
     * @return String HTML info
     */
    private static String inputDataPage(Request req, Response res) {
        return RestPersistence.getInputData();
    }


    /**
     * Result data with info about calculator
     * @param req request on the server
     * @param res response on the server
     * @return String HTML info
     */
    private static String resultsPage(Request req, Response res) {
        if (linkedList != null) {
            return RestPersistence.getResults(linkedList);
        }
        return "We don't have correct information.";
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}