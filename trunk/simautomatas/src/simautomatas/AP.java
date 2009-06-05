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

    private Pila pila;

    public AP(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
        // apilamos el TOPE de la pila (#)
        this.pila.apilar(new Caracter('#'));
    }

    @Override
    public Boolean evaluarEntrada(String entrada) throws NoDefinido {
        return true;
    }

    public ArrayList<ConfigInstantanea> ejecutar(String entrada) throws NoDefinido {
        return new ArrayList<ConfigInstantanea>();
    }

    public ArrayList<ConfigInstantanea> ejecutar(String entrada, int hasta) throws NoDefinido {
        return new ArrayList<ConfigInstantanea>();
    }

}