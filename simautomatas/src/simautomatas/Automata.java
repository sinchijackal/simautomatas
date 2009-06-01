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
    private String alfEntrada;
    private ArrayList<Estado> estados;
    private Estado estadoInicial;
    private ArrayList<Estado> estadosFinales;

    public Automata(String alfEntrada, ArrayList<Estado> estados,
                    Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        this.alfEntrada = alfEntrada;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
    }

    /**
     * Determinamos si la cadena ingresada es aceptada
     * @param entrada
     * @return
     */
    public abstract Boolean evaluarEntrada(String entrada) throws NoExisteEntrada;

    /**
     * Retornamos si el Estado estado pertenece a los Estados finales
     * @param estado
     * @return
     */
    public Boolean esFinal(Estado estado) {
        // recorremos todos los Estados Finales
        for (int i=0; i<this.estadosFinales.size(); i++) {
            if (estadosFinales.get(i).equals(estado))
                return true;
        }

        // si no era igual, es distinto!!!
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

}
