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
public class Main {

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
        Estado F = new Estado("F");

        ArrayList<Estado> estados = new ArrayList<Estado>();
        estados.add(I);
        estados.add(A);
        estados.add(B);
        estados.add(F);

        // definimos las transiciones
        ArrayList<Estado> tI = new ArrayList<Estado>();
        tI.add(A);
        tI.add(F);
        I.agregarTransicion(new Transicion('0', tI));

        I.agregarTransicion(new Transicion('1', A));
        A.agregarTransicion(new Transicion('0', B));
        
        ArrayList<Estado> tA = new ArrayList<Estado>();
        tA.add(B);
        tA.add(F);
        A.agregarTransicion(new Transicion('1', tA));

        B.agregarTransicion(new Transicion('&', F));
        B.agregarTransicion(new Transicion('0', F));
        B.agregarTransicion(new Transicion('1', F));

        F.agregarTransicion(new Transicion('0', F));
        F.agregarTransicion(new Transicion('1', F));

        // Estados Finales
        ArrayList<Estado> estadosF = new ArrayList<Estado>();
        estadosF.add(F);

        // creamos el automata
        AFND afd = new AFND(alf, estados, I, estadosF);

        // probamos valuar una entrada
        String cadena = "001010";
        try {
            System.out.println("La cadena '" + cadena + "' fue: " + afd.evaluarEntrada(cadena));
        } catch (NoExisteEntrada ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
