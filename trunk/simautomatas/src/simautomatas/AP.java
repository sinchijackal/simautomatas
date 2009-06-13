/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;

/**
 * Automata a Pila
 * @author Joaquin
 */
public class AP extends Automata {

    private Pila pila;
    private String alfPila;
    private char inicialPila;

    public AP(String alfEntrada, String alfPila, ArrayList<Estado> estados, char inicialPila, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
        // apilamos el TOPE de la pila (#)
        this.alfPila = alfPila;
        this.pila = new Pila(new Caracter(inicialPila));
    }

    @Override
    public Boolean evaluarEntrada(String entrada) throws NoDefinido {
        ArrayList<Estado> estados = new ArrayList<Estado>();
        ArrayList<ConfigInstantanea> cfgs = ejecutar(entrada);

        // obtenemos los estados de las configuraciones instantaneas
        for (int i=0; i<cfgs.size(); i++)
            estados.add(cfgs.get(i).getEstado());

        // alguno de ellos es estado final?
        return algunoEsFinal(estados);
    }

    public ArrayList<ConfigInstantanea> ejecutar(String entrada) throws NoDefinido {
        return ejecutar(entrada, entrada.length());
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
        System.out.println("Leemos: " + entrada);
        entrada += "&";

        // recorremos la cadena modificada para determinar el conjunto de estados
        for (int i=0; i<=hasta; i++) {

            System.out.println("Pila: " + pila.toString());

            // definimos el conjunto de estados proximos
            ArrayList<Estado> estadosProximos = new ArrayList<Estado>();

            // recorremos todos los estados del conjunto de estados de la config instantanea
            for (int b=0; b<estados.size(); b++) {
                Estado q = estados.get(b);
                System.out.println("Estamos en el estado: " + q.getNombre());
                ArrayList<Estado> qs = new ArrayList<Estado>();

                try {
                    System.out.println("Analizamos: " + entrada.charAt(i) + ", " + pila.leer());
                    qs = q.valuar(entrada.charAt(i), this.pila);
                }
                catch (ExcepcionPilaVacia e) {
                    System.out.println("Pila Vacia...");
                }

                // si corresponde agregar un estado
                if (qs.size() > 0) {
                    estadosProximos.addAll(qs);
                    System.out.println("...y pasamos al estado: " + qs.get(0).getNombre());
                }
                else {
                    // si no hay transiciones pero el caracter es lambda nos quedamos en el estado actual
                    if (entrada.charAt(i)=='&') {
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

    public String getAlfPila() {
        return alfPila;
    }

    public void setAlfPila(String alfPila) {
        this.alfPila = alfPila;
    }

    public Pila getPila() {
        return pila;
    }

    public void setPila(Pila pila) {
        this.pila = pila;
    }

}