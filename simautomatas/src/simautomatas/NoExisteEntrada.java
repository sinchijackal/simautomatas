/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

/**
 *
 * @author Joaquin
 */
public class NoExisteEntrada extends Exception {

    public NoExisteEntrada() {
        super ("Error en el conjunto de transiciones para el caracter de entrada");
    }

}
