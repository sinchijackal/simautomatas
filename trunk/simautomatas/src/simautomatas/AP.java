/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;

/**
 * Automata a Pila
 * @author Joaquin
 */
public class AP extends Automata {

    // La Pila
    private char[] pila;

    public AP(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
        // apilamos el TOPE de la pila (#)
        this.apilar('#');
    }

    @Override
    public Boolean evaluarEntrada(String entrada) throws NoExisteEntrada {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Apilamos un caracter en la pila y devolvemos su indice
     * @param caracter
     */
    private int apilar(char caracter) {
        return 0;
    }

    /**
     * Desapilamos un caracte
     * @return el caracter desapilado
     */
    private char desapilar() throws ExcepcionPilaVacia {
        return '&';
    }

}