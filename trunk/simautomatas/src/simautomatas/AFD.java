/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class AFD extends Automata {

    public AFD(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
    }

    /**
     * Determinamos si la cadena ingresada es aceptada
     * @param entrada
     * @return
     */
    public Boolean evaluarEntrada(String entrada) {

        // obviamente empezamos con el estado inicial
        Estado q = getEstadoInicial();

        // recorremos todos los caracteres de la entrada
        for (int i=0; i<entrada.length(); i++) {
            q = q.valuar(entrada.charAt(i)).get(0);
        }

        // verificamos la pertenencia de q a los estados finales
        return esFinal(q);
    }

}
