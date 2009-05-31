/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

/**
 * Funcion de transicion para un AF
 * @author Joaquin
 */
public class Transicion {
    private char entrada;
    private Estado estadoSiguiente;

    public Transicion(char entrada, Estado estadoSiguiente) {
        this.entrada = entrada;
        this.estadoSiguiente = estadoSiguiente;
    }

    public Transicion() {
    }

    public char getEntrada() {
        return entrada;
    }

    public void setEntrada(char entrada) {
        this.entrada = entrada;
    }

    public Estado getEstadoSiguiente() {
        return estadoSiguiente;
    }

    public void setEstadoSiguiente(Estado estadoSiguiente) {
        this.estadoSiguiente = estadoSiguiente;
    }
}
