/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Joaquin
 */
public class Pila {
    
    // La Pila
    private Stack<Caracter> pila;

    public Pila() {
        this.pila = new Stack<Caracter>();
    }

    public Pila(Caracter inicial) {
        this.pila = new Stack<Caracter>();
        apilar(inicial);
    }

    public Pila(char c) {
        this.pila = new Stack<Caracter>();
        apilar(new Caracter(c));
    }
    
    /**
     * Apilamos un Caracter en la pila y devolvemos su indice
     * @param caracter
     */
    public int apilar(Caracter caracter) {
        this.pila.push(caracter);
        return this.pila.size()-1;
    }

    /**
     * Apilamos un caracter en la pila y devolvemos su indice
     * @param caracter
     */
    public int apilar(char caracter) {
        this.pila.push(new Caracter(caracter));
        return this.pila.size()-1;
    }

    /**
     * Desapilamos un caracter
     * @return el caracter desapilado
     */
    public char desapilar() throws ExcepcionPilaVacia {
        return this.pila.pop().getCaracter();
    }

    /**
     * Leemos el ultimo caracter de la pila sin desapilarlo
     * @return
     * @throws simautomatas.ExcepcionPilaVacia
     */
    public char leer() throws ExcepcionPilaVacia {
        return this.pila.peek().getCaracter();
    }

    @Override
    public String toString() {
        String retorno = "";
        ArrayList<Caracter> pilaProvisoria = new ArrayList<Caracter>();

        // desapilamos y guardarmos en la pila provisoria
        for (int i=0; i<this.pila.size(); i++) {
            retorno += this.pila.get(i).getCaracter() + " ";
        }

        return retorno + "(FIN)";
    }

}
