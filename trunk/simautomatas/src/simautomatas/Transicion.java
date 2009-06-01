/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;

/**
 * Funcion de transicion para un AF
 * @author Joaquin
 */
public class Transicion {
    private char entrada;
    private ArrayList<Estado> estadoSiguiente;

    public Transicion(char entrada, ArrayList<Estado> estadoSiguiente) {
        this.entrada = entrada;
        this.estadoSiguiente = estadoSiguiente;
    }

    public Transicion(char entrada, Estado estado) {
        this.estadoSiguiente = new ArrayList<Estado>();
        this.entrada = entrada;
        this.estadoSiguiente.add(estado);
    }

    public Transicion() {
    }

    public char getEntrada() {
        return entrada;
    }

    public void setEntrada(char entrada) {
        this.entrada = entrada;
    }

    public ArrayList<Estado> getEstadoSiguiente() {
        return estadoSiguiente;
    }

    public void setEstadoSiguiente(ArrayList<Estado> estadoSiguiente) {
        this.estadoSiguiente = estadoSiguiente;
    }

}
