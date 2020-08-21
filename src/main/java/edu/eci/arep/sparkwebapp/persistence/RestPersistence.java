package edu.eci.arep.sparkwebapp.persistence;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;
import edu.eci.arep.msc.mystatcal.StatCal.StatCalculator;

import java.util.HashMap;

/**
 * The type Rest persistence.
 */
public class RestPersistence {


    /**
     * Gets data.
     *
     * @return the data
     */
    public static String getInputData() {
        return "<!DOCTYPE html>"
        + "<html>"
        + "<body>"
        + "<h2>CALCULATOR MEAN AND DEVIATION</h2><br>"
        + "<form action=\"/table\">"
        + "  <h3>COLUMN'S DATA</h3>"
        + "  <p>Please, put the data in follow space like the example say:</p>"
        + "<label for=\"data\">data:</label>"
        + "  <input type=\"text\" name=\"data1\" placeholder=\"1,2,3,4,5,6\">"
        + "  <br>"
        + "  <br><br>"
        + "  <input type=\"submit\" value=\"Continue\">"
        + "</form>"
        + "<p>If you click the \"Continue\" button, you will see the data table.</p>"
        + "</body>"
        + "</html>";
    }

    /**
     * Gets html table.
     *
     * @param linkedList the linked list
     * @return the html table
     */
    public static String getHTMLTable(MyOwnLinkedList linkedList) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>CALCULATOR MEAN AND DEVIATION: TABLE DATA</h2>"
                + "<form action=\"/results\">";

        pageContent += RestPersistence.getTable(linkedList)

                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Calculate\">"
                + "  <button type=\"submit\" formaction=\"/datos\">Change Data</button>"
                + "</form>"
                + "<p>If you click the \"Calculate\" button, you will see the Sum, Mean and Deviation to the Data.</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }


    /**
     * Gets results.
     *
     * @param linkedList the linked list
     * @return the results
     */
    public static String getResults(MyOwnLinkedList linkedList) {
        HashMap<String, String> calculos = CalculateDeviationRedounded(linkedList);
        StringBuilder pageContent
                = new StringBuilder("<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>CALCULATOR MEAN AND DEVIATION: CALCULATIONS</h2><br>"
                + "<h3>HTML Results in Data Type " + linkedList.getDataType() + "</h3>"
                + "<form action=\"/datos\">");

        for (String s : calculos.keySet()) {
            pageContent.append("<h4>").append(s).append(" : ").append(calculos.get(s)).append("</h4>");
        }
        pageContent.append("  <br><br>" + "  <input type=\"submit\" value=\"New Calculation\">" + "</form>" + "<p>If you click the \"New Calculation\" button, you could do a new calculation. </p>" + "</body>" + "</html>");
        return pageContent.toString();
    }

    /**
     * Generate Table HTML
     * @param linkedList Linked List to convert to HTML data
     * @return String with HTML info
     */
    private static String getTable(MyOwnLinkedList linkedList) {
        StringBuilder html =
                new StringBuilder("<table style=\"width:20%\">"
                        + "  <tr>"
                        + "    <th>Data Table: Type -> " + linkedList.getDataType() + "</th>"
                        + "  </tr>");

        Node aux = linkedList.priorNode();
        while (aux != null) {
            html.append("<tr>" + "<td>").append(aux.getData()).append("</td>").append("</tr>");
            aux = linkedList.nextNode(aux);
        }
        html.append("</table>");
        return html.toString();
    }

    /**
     * Caulate the Deviation redounded
     * @param linkedList Linked List that have to solve
     * @return info to get HTML data with Sum, mean and Deviation
     */
    private static HashMap<String, String> CalculateDeviationRedounded(MyOwnLinkedList linkedList) {
        HashMap<String, String> aux = new HashMap<>();
        if (linkedList.getDataType().equals("string")) {
            aux.put("Invalid data type", "You can't get mean or deviation from a String, please. Put right values");
            return aux;

        }
        String sum = StatCalculator.Sum(linkedList);
        String mean = StatCalculator.Mean(linkedList);
        String deviation = StatCalculator.Deviation(linkedList);

        aux.put("Sum", StatCalculator.Round(Double.parseDouble(sum), 2));
        aux.put("Mean", StatCalculator.Round(Double.parseDouble(mean), 2));
        aux.put("Deviation", StatCalculator.Round(Double.parseDouble(deviation), 2));
        return aux;
    }
}
