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
public class Estado {

    private String nombre;
    private ArrayList<Transicion> f;

    public Estado(String nombre, Transicion[] f) {
        this.nombre = nombre;
        this.f = new ArrayList<Transicion>();
    }

    public Estado(String nombre) {
        this.nombre = nombre;
        this.f = new ArrayList<Transicion>();
    }

    /**
     * Agregamos una transicion
     * @param f Transicion
     */
    public void setF(Transicion f) {
        this.f.add(f);
    }

    public Estado valuar(char entrada) throws NoExisteEntrada {
        // comprobamos todas las transiciones
        for (int i=0; i<f.size(); i++) {
            // si la entrada ingresada corresponde a entrada, retornamos el estado siguiente
            if (f.get(i).getEntrada() == entrada) {
                return f.get(i).getEstadoSiguiente();
            }
        }

        // si llegamos hasta aca algo anda mal!
        throw new NoExisteEntrada();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
