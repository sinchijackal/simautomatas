/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.ArrayList;
import simautomatas.*;

/**
 *
 * @author Joaquin
 */
public class MainMT {

    public static void main(String[] argv) {

        String alfEntrada = "BA*";
        String alfCinta = "BA*01b";

        // definimos los estados
        ArrayList<Estado> estados = new ArrayList<Estado>();
        Estado I = new Estado("I");
        estados.add(I);
        Estado q1 = new Estado("q1");
        estados.add(q1);
        Estado q2 = new Estado("q2");
        estados.add(q2);
        Estado q3 = new Estado("q3");
        estados.add(q3);
        Estado q4 = new Estado("q4");
        estados.add(q4);
        Estado q5 = new Estado("q5");
        estados.add(q5);
        Estado F = new Estado("F");
        estados.add(F);

        // definimos el conjunto de los estados finales
        ArrayList<Estado> estadosFinales = new ArrayList<Estado>();
        estadosFinales.add(F);

        // definimos las transiciones
        I.agregarTransicion(new Transicion('*', '*', Operacion.IZQUIERDA, q1));
        I.agregarTransicion(new Transicion('b', 'b', Operacion.DERECHA, q5));
        q1.agregarTransicion(new Transicion('A', '0', Operacion.DERECHA, q2));
        q1.agregarTransicion(new Transicion('B', '1', Operacion.DERECHA, q3));
        q2.agregarTransicion(new Transicion('0', '0', Operacion.DERECHA, q2));
        q2.agregarTransicion(new Transicion('1', '1', Operacion.DERECHA, q2));
        q2.agregarTransicion(new Transicion('*', '*', Operacion.DERECHA, q2));
        q2.agregarTransicion(new Transicion('b', '0', Operacion.IZQUIERDA, q4));
        q3.agregarTransicion(new Transicion('0', '0', Operacion.DERECHA, q3));
        q3.agregarTransicion(new Transicion('1', '1', Operacion.DERECHA, q3));
        q3.agregarTransicion(new Transicion('*', '*', Operacion.DERECHA, q3));
        q3.agregarTransicion(new Transicion('b', '1', Operacion.IZQUIERDA, q4));
        q4.agregarTransicion(new Transicion('0', '0', Operacion.IZQUIERDA, q4));
        q4.agregarTransicion(new Transicion('1', '1', Operacion.IZQUIERDA, q4));
        q4.agregarTransicion(new Transicion('*', '*', Operacion.IZQUIERDA, q4));
        q4.agregarTransicion(new Transicion('A', '0', Operacion.DERECHA, q2));
        q4.agregarTransicion(new Transicion('B', '1', Operacion.DERECHA, q3));
        q4.agregarTransicion(new Transicion('b', 'b', Operacion.DERECHA, q5));
        q5.agregarTransicion(new Transicion('0', 'A', Operacion.DERECHA, q5));
        q5.agregarTransicion(new Transicion('1', 'B', Operacion.DERECHA, q5));
        q5.agregarTransicion(new Transicion('*', '*', Operacion.DERECHA, q5));
        q5.agregarTransicion(new Transicion('b', 'b', Operacion.PARAR, F));

        // creamos la MT
        MT mt = new MT("Maquina de Turing 1", alfEntrada, alfCinta, estados, I, estadosFinales);
        ConfigInstantanea cfg = mt.ejecutar("BBAA*", 5);

        System.out.println("\n- La MT termino con: (" + cfg.getEstado() + ", " + cfg.getCinta() + ", " + cfg.getCabezal() + ").");
        System.out.println("Total de Movimientos: " + mt.getTotalMovimientos("BBAA*", 5));

    }

}
