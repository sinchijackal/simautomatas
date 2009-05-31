/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

/**
 *
 * @author Joaquin
 */
public class Automata {
    // atributos generales de los Automatas
    private char[] alfEntrada;
    private Estado[] estados;
    private Estado estadoInicial;
    private Estado[] estadosFinales;

    public Automata(char[] alfEntrada, Estado[] estados, Estado estadoInicial, Estado[] estadosFinales) {
        this.alfEntrada = alfEntrada;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
    }

    public Automata(String alfEntrada, Estado[] estados, Estado estadoInicial, Estado[] estadosFinales) {
        // obtenemos la cadena como array de caracteres
        char cadena[] = {};
        alfEntrada.getChars(0, alfEntrada.length(), cadena, 0);

        this.alfEntrada = cadena;
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
        // obtenemos la cadena como array de caracteres
        char cadena[] = {};
        entrada.getChars(0, entrada.length(), cadena, 0);
        
        // obviamente empezamos con el estado inicial
        Estado q = this.estadoInicial;

        // recorremos todos los caracteres de la entrada
        for (int i=0; i<cadena.length; i++) {
            q = q.valuar(cadena[i]);
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
        for (int i=0; i<this.estadosFinales.length; i++) {
            if (estadosFinales[i].equals(estado))
                return true;
        }

        // si no era igual, es distinto!!!
        return false;
    }

}
