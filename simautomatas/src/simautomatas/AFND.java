/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;

/**
 * Consideramos & como lambda, palabra vacia |&|=0
 * @author Joaquin
 */
public class AFND extends Automata {

    public AFND(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
    }

    @Override
    /**
     * Valor de aceptacion de la cadena de entrada
     */
    public Boolean evaluarEntrada(String entrada) throws NoExisteEntrada {
        // definimos el conjunto de estados de la configuracion instantanea
        ArrayList<Estado> estados = new ArrayList<Estado>();
        
        // Agregamos el estado inicial
        estados.add(this.getEstadoInicial());
        
        // modificamos la cadena para considerar lambda al principio, final, e intercalado
        String cadena = "&";
        for (int i=0; i<entrada.length(); i++) {
            cadena += entrada.charAt(i) + "&";
        }
        System.out.println("Cadena a analizar: " + cadena);
        
        // recorremos la cadena modificada para determinar el conjunto de estados
        for (int i=0; i<cadena.length(); i++) {
            System.out.println("Analizando caracter: " + cadena.charAt(i));

            // definimos el conjunto de estados proximos
            ArrayList<Estado> estadosProximos = new ArrayList<Estado>();
            
            // recorremos todos los estados del conjunto de estados de la config instantanea
            for (int b=0; b<estados.size(); b++) {
                Estado q = estados.get(b);
                System.out.println("Recorriendo estado: " + q.getNombre());

                ArrayList<Estado> qs = q.valuar(cadena.charAt(i));

                if (qs.size() > 0) {
                    estadosProximos.addAll(qs);
                    System.out.println("Agregamos al conjunto de estados: " + qs.size());
                }
                else {
                    if (cadena.charAt(i)=='&') {
                        estadosProximos.add(q);
                    }
                    else {
                        System.out.println("No agregamos ningun estado porq no hay transiciones para " + cadena.charAt(i));
                    }
                }
            }

            // Comprobamos que haya al menos 1 estado en el conjunto de los siguientes
            if (estadosProximos.size() <= 0)
                throw new NoExisteEntrada();
            // definimos estados como los estados siguientes para usarlos en la proxima iteracion
            estados = estadosProximos;
        }
        
        // si todo va bien salimos con el resultado
        if (estados.size() > 0)
            return algunoEsFinal(estados);

        // si llegamos aca paso algo!! salimos con excepcion!
        throw new NoExisteEntrada();
    }

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

}
