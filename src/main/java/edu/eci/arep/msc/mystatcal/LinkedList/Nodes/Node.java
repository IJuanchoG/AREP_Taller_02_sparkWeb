package edu.eci.arep.msc.mystatcal.LinkedList.Nodes;

import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl.DoubleNode;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl.IntegerNode;
import edu.eci.arep.msc.mystatcal.LinkedList.Nodes.Impl.StringNode;
import edu.eci.arep.msc.mystatcal.Persistence.Exceptions.NodesException;

/**
 * The interface Node.
 */
public interface Node {

    /**
     * Contruccion de los nodos
     *
     * @param data     Informacion a convertir en nodo
     * @param dataType tipo de informacion que se maneja
     * @param tail     nodo cola existente hasta el momento
     * @return nodo contruido
     * @throws NodesException excepcion de nodos
     */
    static Node BuildNode(String data, String dataType, Node tail) throws NodesException {
        dataType = dataType.toLowerCase();
        switch (dataType) {
            case ("double"):
                if (tail == null) return new DoubleNode(Double.parseDouble(data), null);
                return new DoubleNode(Double.parseDouble(data), null, (DoubleNode) tail);
            case ("integer"):
                if (tail == null) return new IntegerNode(Integer.parseInt(data), null);
                return new IntegerNode(Integer.parseInt(data), null, (IntegerNode) tail);
            case ("string"):
                if (tail == null) return new StringNode(String.valueOf(data), null);
                return new StringNode(String.valueOf(data), null, (StringNode) tail);
            default:
                throw new NodesException(NodesException.INCORRECT_DATATYPE);
        }
    }

    /**
     * Setea el nodo derecho de al que se encuentra
     *
     * @param rightNode nodo derecho al que se le cambiará el nodo
     * @return confirmacion del nodo seteado
     * @throws NodesException excepcion de nodos
     */
    boolean setRightNode(Node rightNode) throws NodesException;

    /**
     * Retorna el nodo derecho
     *
     * @return retorna el nodo derecho al manejado
     */
    Node getRightNode();


    /**
     * setea nodo izquierdo
     *
     * @param leftNode nuevo nodo a asignar
     * @return confirmacion de nodo seteado
     * @throws NodesException excepcion de nodo
     */
    boolean setLeftNode(Node leftNode) throws NodesException;


    /**
     * Gets left node.
     *
     * @return the left node
     */
    Node getLeftNode();

    /**
     * Gets data.
     *
     * @return the data
     */
    Object getData();

    /**
     * Gets node type.
     *
     * @return the node type
     */
    String getNodeType();

    String toString();


}
