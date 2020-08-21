package edu.eci.arep.msc.mystatcal.StatCal;

import edu.eci.arep.msc.mystatcal.LinkedList.MyOwnLinkedList;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Node;

public class StatCalculator {

    /**
     * Genera el calculo matematico a partir del cual se conoce la desviacion de datos en una distribucion
     *
     * @param linkedList linkedlist a buscar
     * @return desviacion de los datos
     */
    public static String Deviation(MyOwnLinkedList linkedList) {
        int size = linkedList.getSize();
        double mean = Double.parseDouble(StatCalculator.Mean(linkedList));
        double Expo = Double.parseDouble(StatCalculator.DeviationSum(linkedList, mean));
        double sqrt = Math.sqrt(Expo / (size - 1));
        return String.valueOf(sqrt);
    }

    /**
     * Realizar el calculo matematico correspondiente a la media de una distribucion de datos
     *
     * @param linkedList linkedlist a calcular media
     * @return media de los datos
     */
    public static String Mean(MyOwnLinkedList linkedList) {
        int size = linkedList.getSize();
        String sum = StatCalculator.Sum(linkedList);
        String dataType = linkedList.getDataType();
        double mean;
        if (dataType.equals("double") || dataType.equals("integer")) {
            mean = Double.parseDouble(sum) / size;
        } else {
            throw new IllegalStateException("Unexpected value: " + dataType);
        }
        return String.valueOf(mean);
    }


    /**
     * Realiza la suma de los datos en una LinkedList
     *
     * @param linkedList linkedlist a sumar
     * @return suma de los datos
     */
    public static String Sum(MyOwnLinkedList linkedList) {
        String dataType = linkedList.getDataType();
        Node aux = linkedList.priorNode();
        if (dataType.equals("double")) {
            double value = 0;
            while (aux != null) {
                value += (Double) aux.getData();
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        } else if (dataType.equals("integer")) {
            int value = 0;
            while (aux != null) {
                value += (Integer) aux.getData();
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        } else {
            throw new IllegalStateException("Unexpected value: " + dataType);
        }
    }

    /**
     * Redondea a las cifras necesarias un numero de tipo double
     *
     * @param number numero a redondear
     * @param nDigit numero digitos a redondear
     * @return valor redondeado
     */
    public static String Round(double number, int nDigit) {
        double digits = Math.pow(10, nDigit);
        return String.valueOf((double) Math.round(number * digits) / digits);
    }

    /**
     * Realiza la suma y el elevado contenidos en una desviacion media
     *
     * @param linkedList linkedlist a sumar de manera parcial
     * @param mean       media de la linkedlist
     * @return (suma - promedio)**2
     */
    private static String DeviationSum(MyOwnLinkedList linkedList, double mean) {
        String dataType = linkedList.getDataType();
        Node aux = linkedList.priorNode();
        if (dataType.equals("double")) {
            double value = 0;
            while (aux != null) {
                value += Math.pow((Double) aux.getData() - mean, 2);
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        } else if (dataType.equals("integer")) {
            int value = 0;
            while (aux != null) {
                value += Math.pow((Integer) aux.getData() - mean, 2);
                aux = aux.getRightNode();
            }
            return String.valueOf(value);
        } else {
            throw new IllegalStateException("Unexpected value: " + dataType);
        }
    }

}
