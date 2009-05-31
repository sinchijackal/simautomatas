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
    public Boolean evaluarEntrada(String entrada) {
        // obtenemos la cadena como array de caracteres
        char cadena[] = {};
        entrada.getChars(0, entrada.length(), cadena, 0);

        return true;
    }

}
