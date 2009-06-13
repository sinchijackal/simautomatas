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
public class MainAFND {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // definimos el alf de entrada
        String alf = "01";

        // definimos los estados
        Estado I = new Estado("I");
        Estado A = new Estado("A");
        Estado B = new Estado("B");
        Estado C = new Estado("C");
        Estado F = new Estado("F");

        ArrayList<Estado> estados = new ArrayList<Estado>();
        estados.add(I);
        estados.add(A);
        estados.add(B);
        estados.add(C);
        estados.add(F);

        // Transiciones
        I.agregarTransicion(new Transicion('0', A));
        I.agregarTransicion(new Transicion('1', A));
        
        ArrayList<Estado> tA = new ArrayList<Estado>();
        tA.add(B);
        tA.add(F);
        tA.add(C);
        A.agregarTransicion(new Transicion('0', A));
        A.agregarTransicion(new Transicion('1', tA));

        B.agregarTransicion(new Transicion('0', F));
        B.agregarTransicion(new Transicion('&', F));

        F.agregarTransicion(new Transicion('0', F));
        F.agregarTransicion(new Transicion('1', F));

        // Estados Finales
        ArrayList<Estado> estadosF = new ArrayList<Estado>();
        estadosF.add(F);

        // creamos el automata
        AFND afnd = new AFND(alf, estados, I, estadosF);

        // probamos valuar una entrada
        String cadena = "101";

        System.out.println("Cadena: " + cadena);
        System.out.println("Transiciones: ");

        try {
            ArrayList<ConfigInstantanea> cfgs = afnd.ejecutar(cadena);
            System.out.println("Para el ultimo caracter tenemos: " + cfgs.size() + " configs...");

            for (int i=0; i<cfgs.size(); i++) {
                System.out.println(cfgs.get(i).toString());
            }

            //System.out.println("la aceptacion es: " + afnd.evaluarEntrada(cadena));
        } catch (NoDefinido ex) {
            Logger.getLogger(MainAFND.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
