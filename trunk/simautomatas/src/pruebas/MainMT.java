/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import simautomatas.*;

/**
 *
 * @author Joaquin
 */
public class MainMT {

    public static void main(String[] argv) {
        Cinta cinta = new Cinta("0010*1101");
        //cinta.grabar(2, 'c');
        //cinta.grabar(0, 'q');
        cinta.grabar(cinta.getSize()-1, 'a');

        System.out.println(cinta);
    }

}
