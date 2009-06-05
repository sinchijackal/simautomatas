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
public class AFD extends Automata {

    public AFD(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
    }

    /**
     * Determinamos si la cadena ingresada es aceptada
     * @param entrada
     * @return
     */
    public Boolean evaluarEntrada(String entrada) {
        // verificamos la pertenencia de q a los estados finales
        return esFinal(ejecutar(entrada).getEstado());
    }

    /**
     * Ejecutamos el AFD para toda la cadena y devolvemos la config instantanea
     * para el ultimo estado del automata con la cadena restante "" (vacia)
     * @param entrada
     * @return configuracion instantanea final
     */
    public ConfigInstantanea ejecutar(String entrada) {
        return ejecutar(entrada, entrada.length());
    }

    /**
     * Ejecutamos la iteracion del automata para una cadena dada hasta el
     * caracter numero (hasta) y devolvemos la configuracion instantanea en ese
     * momento procesando el caracter hasta inclusive
     * @param entrada
     * @param hasta
     * @return configuracion instantanea
     */
    public ConfigInstantanea ejecutar(String entrada, int hasta) {
        // obviamente empezamos con el estado inicial
        Estado q = getEstadoInicial();

        // recorremos todos los caracteres de la entrada
        for (int i=0; i<hasta; i++) {
            q = q.valuar(entrada.charAt(i)).get(0);
        }

        // verificamos la pertenencia de q a los estados finales
        return new ConfigInstantanea(q, entrada.substring(hasta));
    }

}
