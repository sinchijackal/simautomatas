/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.Stack;

/**
 *
 * @author Joaquin
 */
public class Pila {
    
    // La Pila
    private Stack<Caracter> pila;

    public Pila() {
    }
    
    /**
     * Apilamos un caracter en la pila y devolvemos su indice
     * @param caracter
     */
    public int apilar(Caracter caracter) {
        this.pila.push(caracter);
        return this.pila.size()-1;
    }

    /**
     * Desapilamos un caracter
     * @return el caracter desapilado
     */
    public Caracter desapilar() throws ExcepcionPilaVacia {
        return this.pila.pop();
    }

    /**
     * Leemos el ultimo caracter de la pila sin desapilarlo
     * @return
     * @throws simautomatas.ExcepcionPilaVacia
     */
    public Caracter leer() throws ExcepcionPilaVacia {
        return this.pila.peek();
    }

}
