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
        super ("f(a) no existe para la entrada a...");
    }

}
