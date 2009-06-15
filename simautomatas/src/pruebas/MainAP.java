/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import simautomatas.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin
 */
public class MainAP {

    public static void main(String[] args) {

        // cadenas relacionadas
        String alfEntrada = "()";
        String alfPila = "#C";

        // conjunto de estados
        ArrayList<Estado> estados = new ArrayList<Estado>();
        Estado I = new Estado("I");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");
        Estado q4 = new Estado("q4");
        Estado E = new Estado("E");
        Estado F = new Estado("F");
        estados.add(q4);
        estados.add(q3);
        estados.add(q2);
        estados.add(q1);
        estados.add(I);
        estados.add(F);
        estados.add(E);

        // estados finales
        ArrayList<Estado> estadosFinales = new ArrayList<Estado>();
        estadosFinales.add(F);

        // transiciones
        I.agregarTransicion(new Transicion('0', '#', Operacion.GRABAR, '0', q1));
        I.agregarTransicion(new Transicion('1', '#', Operacion.GRABAR, '1', q1));
        q1.agregarTransicion(new Transicion('0', '0', Operacion.GRABAR, '0', q2));
        q1.agregarTransicion(new Transicion('0', '1', Operacion.GRABAR, '0', q2));
        q1.agregarTransicion(new Transicion('1', '0', Operacion.GRABAR, '1', q2));
        q1.agregarTransicion(new Transicion('1', '1', Operacion.GRABAR, '1', q2));
        q2.agregarTransicion(new Transicion('0', '0', Operacion.GRABAR, '0', q3));
        q2.agregarTransicion(new Transicion('0', '1', Operacion.GRABAR, '0', q3));
        q2.agregarTransicion(new Transicion('1', '0', Operacion.GRABAR, '1', q3));
        q2.agregarTransicion(new Transicion('1', '1', Operacion.GRABAR, '1', q3));
        q3.agregarTransicion(new Transicion('0', '0', Operacion.GRABAR, '0', q4));
        q3.agregarTransicion(new Transicion('0', '1', Operacion.GRABAR, '0', q4));
        q3.agregarTransicion(new Transicion('1', '0', Operacion.GRABAR, '1', q4));
        q3.agregarTransicion(new Transicion('1', '1', Operacion.GRABAR, '1', q4));
        q4.agregarTransicion(new Transicion('1', '0', Operacion.LEER, E));
        q4.agregarTransicion(new Transicion('0', '1', Operacion.LEER, E));
        q4.agregarTransicion(new Transicion('1', '1', Operacion.BORRAR, q4));
        q4.agregarTransicion(new Transicion('0', '0', Operacion.BORRAR, q4));
        q4.agregarTransicion(new Transicion('&', '#', Operacion.BORRAR, F));

        // creamos el AP
        AP ap = new AP("Proyecto 1 - AP", alfEntrada, alfPila, estados, '#', I, estadosFinales);

        // probamos la ejecucion
        ArrayList<ConfigInstantanea> cfg;
        try {
            cfg = ap.ejecutar("00011001");
            System.out.println("Estado Final: " + cfg.get(0).getEstado().getNombre());
        } catch (NoDefinido ex) {
            Logger.getLogger(MainAP.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }

}
