/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin
 */
public class MT extends Automata {

    private String alfCinta;
    private Cinta cinta;
    private int cabezal;

    public MT(String nombre, String alfEntrada, String alfCinta, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(nombre, alfEntrada, estados, estadoInicial, estadosFinales);
        this.cinta = new Cinta();
        this.alfCinta = alfCinta;
    }

    @Override
    public Boolean evaluarEntrada(String entrada) throws NoDefinido {
        return esFinal(ejecutar(entrada, this.getCabezal()).getEstado());
    }

    public Boolean evaluarEntrada(String entrada, int cabezal) throws NoDefinido {
        return esFinal(ejecutar(entrada, cabezal).getEstado());
    }

    /**
     * Ejecutamos la MT hasta el ultimo movimiento
     * @param entrada
     * @return
     */
    public ConfigInstantanea ejecutar(String entrada) {
        return ejecutar(entrada, this.getCabezal());
    }

    public ConfigInstantanea ejecutar(String entrada, int cabezalInicial) {
        return ejecutar(entrada, cabezalInicial, this.getTotalMovimientos(entrada, cabezalInicial));
    }

    /**
     * Ejecutamos la MT hasta el movimiento pasado por parametros
     * @param entrada cadena de entrada (en cinta)
     * @param hasta movimientos a ejecutar
     * @return
     */
    public ConfigInstantanea ejecutar(String entrada, int cabezalInicial, int hasta) {
        // ponemos la cadena en la cinta
        this.cinta = new Cinta();
        this.cinta.grabarCadena(entrada);
        this.setCabezal(cabezalInicial);
        
         // comenzamos desde el estado inicial
        Estado q = this.getEstadoInicial();
        char caracterCinta = this.cinta.leer(cabezal);
        int i=0;
        
        try {
            Transicion f = q.getTransicion(caracterCinta);

            // mientras la MT no nos indique parar
            while (f.getOperacion() != Operacion.PARAR && i<hasta) {
//                System.out.println("Estado Actual: " + q);
//                System.out.println("El cabezal esta sobre: " + cinta.leer(cabezal));
//                System.out.println("Cinta: " + cinta);
                
                // obtenemos el estado siguiente
                f = q.getTransicion(caracterCinta);
                q = q.valuar(caracterCinta).get(0);
                
                // realizamos las operaciones sobre la cinta
                getCinta().grabar(cabezal, f.getEntradaMemoria());
//                System.out.println("Escribimos " + f.getEntradaMemoria() + " en la posicion " + cabezal);
                // desplazamos el cabezal
                cabezal += f.getOperacion();
//                System.out.println("Nos desplazamos " + f.getOperacion() + " sobre el caracter " + getCinta().leer(cabezal));

                // obtenemos el siguiente caracter a analizar
                caracterCinta = this.cinta.leer(cabezal);
                i++;
            }
        } catch (NoDefinido ex) {
            Logger.getLogger(MT.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ConfigInstantanea(q, this.cinta, cabezal);
    }

    /**
     * Devolvemos el total de movimientos de esta maquina de Turing
     * @return
     */
    public int getTotalMovimientos(String entrada, int cabezalInicial) {
        // ponemos la cadena en la cinta
        this.cinta = new Cinta();
        this.cinta.grabarCadena(entrada);
        this.setCabezal(cabezalInicial);
        int retorno = 0;

        Estado q = this.getEstadoInicial();
        char caracterCinta = this.cinta.leer(cabezal);

        try {
            Transicion f = q.getTransicion(caracterCinta);

            // mientras la MT no nos indique parar
            while (f.getOperacion() != Operacion.PARAR) {

                // obtenemos el estado siguiente
                f = q.getTransicion(caracterCinta);
                q = q.valuar(caracterCinta).get(0);
                getCinta().grabar(cabezal, f.getEntradaMemoria());
                cabezal += f.getOperacion();
                caracterCinta = this.cinta.leer(cabezal);
                retorno ++;
            }
        } catch (NoDefinido ex) {
            Logger.getLogger(MT.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public Cinta getCinta() {
        return cinta;
    }

    public int getCabezal() {
        return cabezal;
    }

    public void setCabezal(int cabezal) {
        this.cabezal = cabezal;
    }
}
