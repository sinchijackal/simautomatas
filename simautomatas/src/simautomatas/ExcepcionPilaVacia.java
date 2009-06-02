/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

/**
 *
 * @author Joaquin
 */
public class ExcepcionPilaVacia extends Exception {

    public ExcepcionPilaVacia(String message) {
        super(message);
    }

    public ExcepcionPilaVacia() {
        super("Error: La Pila está vacía, mal diseñado el AP?");
    }

}
