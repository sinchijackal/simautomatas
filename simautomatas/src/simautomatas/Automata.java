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
public class Automata {
    // atributos generales de los Automatas
    private String alfEntrada;
    private ArrayList<Estado> estados;
    private Estado estadoInicial;
    private ArrayList<Estado> estadosFinales;

    public Automata(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
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
    public Boolean evaluarEntrada(String entrada) throws NoExisteEntrada {
        
        // obviamente empezamos con el estado inicial
        Estado q = this.estadoInicial;

        // recorremos todos los caracteres de la entrada
        for (int i=0; i<entrada.length(); i++) {
            q = q.valuar(entrada.charAt(i));
        }

        // verificamos la pertenencia de q a los estados finales
        return esFinal(q);
    }

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

}
