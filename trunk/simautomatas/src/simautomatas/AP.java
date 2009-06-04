/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Automata a Pila
 * @author Joaquin
 */
public class AP extends Automata {

    // La Pila
    private Stack<Caracter> pila;

    public AP(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
        // apilamos el TOPE de la pila (#)
        this.apilar(new Caracter('#'));
    }

    @Override
    public Boolean evaluarEntrada(String entrada) throws NoExisteEntrada {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Apilamos un caracter en la pila y devolvemos su indice
     * @param caracter
     */
    private int apilar(Caracter caracter) {
        this.pila.push(caracter);
        return this.pila.size()-1;
    }

    /**
     * Desapilamos un caracter
     * @return el caracter desapilado
     */
    private Caracter desapilar() throws ExcepcionPilaVacia {
        return this.pila.pop();
    }

    /**
     * Leemos el ultimo caracter de la pila sin desapilarlo
     * @return
     * @throws simautomatas.ExcepcionPilaVacia
     */
    private Caracter leer() throws ExcepcionPilaVacia {
        return this.pila.peek();
    }

}