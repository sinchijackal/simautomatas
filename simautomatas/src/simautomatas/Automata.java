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
public abstract class Automata {
    // atributos generales de los Automatas
    private String nombre;                      // nombre de automata (proyecto)
    private String alfEntrada;                  // conjunto de simbolos del alf de entrada
    private ArrayList<Estado> estados;          // conjunto de estados
    private Estado estadoInicial;               // el estado inicial
    private ArrayList<Estado> estadosFinales;   // conjunto de estados finales

    public Automata(String nombre, String alfEntrada, ArrayList<Estado> estados,
                    Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        this.nombre = nombre;
        this.alfEntrada = alfEntrada;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
    }

    /**
     * Determinamos si la cadena ingresada es aceptada por el automata, es decir,
     * si su ejecucion para la cadena determinada termina en un/unos estado/s
     * perteneciente/s al conjunto de estados finales
     * @param entrada
     * @return
     */
    public abstract Boolean evaluarEntrada(String entrada) throws NoDefinido;

    /**
     * Retornamos si el Estado estado pertenece a los Estados finales
     * @param estado
     * @return
     */
    public Boolean esFinal(Estado estado) {
        return estadosFinales.contains(estado);
    }

    /**
     * Determinamos si algún estado del conjunto de estados pasado por parametros
     * (normalmente para automatas no deterministas que terminan la ejecucion con
     * multiples transiciones a distintos estados) pertenece al conjunto de estados
     * finales para el Automata actual
     * @param estados
     * @return
     */
    public Boolean algunoEsFinal(ArrayList<Estado> estados) {
        // recorremos todos los elementos del conjunto
        for (int i=0; i<estados.size(); i++) {

            // si encontramos alguno final, salimos con true
            if (esFinal(estados.get(i)))
                return true;
        }

        // si llegamos aca, ninguno es FINAL!!!
        return false;
    }

    public String getAlfEntrada() {
        return alfEntrada;
    }

    public void setAlfEntrada(String alfEntrada) {
        this.alfEntrada = alfEntrada;
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public ArrayList<Estado> getEstadosFinales() {
        return estadosFinales;
    }

    public void setEstadosFinales(ArrayList<Estado> estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
