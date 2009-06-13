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

    /**
     * Ejecutamos un AFND para una cadena dada hasta el caracter cuyo numero
     * es indicado por parametros y devolvemos el vector de configuraciones
     * instantaneas al momento
     * @param cadena
     * @param hasta
     * @return vector de configuraciones instantaneas
     */
    public ArrayList<ConfigInstantanea> ejecutar(String entrada, int hasta) throws NoDefinido {
        // definimos el conjunto de estados de la configuracion instantanea
        ArrayList<Estado> estados = new ArrayList<Estado>();

        // Agregamos el estado inicial
        estados.add(this.getEstadoInicial());

        // modificamos la cadena para considerar lambda al principio, final, e intercalado
        String cadena = "&";
        for (int i=0; i<entrada.length(); i++) {
            cadena += entrada.charAt(i) + "&";
        }

        // recorremos la cadena modificada para determinar el conjunto de estados
        for (int i=0; i<=(2*hasta); i++) {
            // definimos el conjunto de estados proximos
            ArrayList<Estado> estadosProximos = new ArrayList<Estado>();

            // recorremos todos los estados del conjunto de estados de la config instantanea
            for (int b=0; b<estados.size(); b++) {
                Estado q = estados.get(b);

                ArrayList<Estado> qs = q.valuar(cadena.charAt(i));

                if (qs.size() > 0) {
                    estadosProximos.addAll(qs);
                }
                else {
                    // si no hay transiciones pero el caracter es lambda nos quedamos en el estado actual
                    if (cadena.charAt(i)=='&') {
                        estadosProximos.add(q);
                    }
                }
            }

            // Comprobamos que haya al menos 1 estado en el conjunto de los siguientes
            if (estadosProximos.size() <= 0)
                throw new NoDefinido();

            // definimos estados como los estados siguientes para usarlos en la proxima iteracion
            estados = estadosProximos;
        }

        // si todo va bien salimos con el vector de configuraciones instantaneas
        if (estados.size() > 0) {
            // cadena restante por leer
            String cadenaRestante = entrada.substring(hasta);
            // creamos un vector para las configuraciones instantaneas
            ArrayList<ConfigInstantanea> cfgs = new ArrayList<ConfigInstantanea>();

            // recorremos los estados al momento
            for (int j=0; j<estados.size(); j++)
                cfgs.add(new ConfigInstantanea(estados.get(j), cadenaRestante));

            return cfgs;
        }

        // si llegamos aca paso algo!! salimos con excepcion!
        throw new NoDefinido();
    }

    /**
     * Ejecutamos el AFND para toda la cadena de entrada y retornamos las
     * configuraciones instantaneas para el momento final
     * @param entrada
     * @return
     * @throws simautomatas.NoDefinido
     */
    public ArrayList<ConfigInstantanea> ejecutar(String entrada) throws NoDefinido {
        return ejecutar(entrada, entrada.length());
    }

    @Override
    /**
     * Valor de aceptacion de la cadena de entrada
     */
    public Boolean evaluarEntrada(String entrada) throws NoDefinido {
        ArrayList<Estado> estados = new ArrayList<Estado>();
        ArrayList<ConfigInstantanea> cfgs = ejecutar(entrada);

        // obtenemos los estados de las configuraciones instantaneas
        for (int i=0; i<cfgs.size(); i++)
            estados.add(cfgs.get(i).getEstado());

        // alguno de ellos es estado final?
        return algunoEsFinal(estados);
    }

}
