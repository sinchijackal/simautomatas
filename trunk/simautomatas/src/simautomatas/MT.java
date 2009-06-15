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
public class MT extends Automata {

    private Cinta cinta;
    private int cabezal;

    public MT(String alfEntrada, ArrayList<Estado> estados, Estado estadoInicial, ArrayList<Estado> estadosFinales) {
        super(alfEntrada, estados, estadoInicial, estadosFinales);
        this.cinta = new Cinta();
    }

    @Override
    public Boolean evaluarEntrada(String entrada) throws NoDefinido {
        // grabamos la cadena de entrada en la cinta
        this.cinta.grabarCadena(entrada);

        throw new UnsupportedOperationException("Not supported yet.");
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
