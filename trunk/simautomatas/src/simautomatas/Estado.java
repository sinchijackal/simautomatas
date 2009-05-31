/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

/**
 *
 * @author Joaquin
 */
public class Estado {

    private String nombre;
    private Transicion[] f;

    public Estado(String nombre, Transicion[] f) {
        this.nombre = nombre;
        this.f = f;
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public Transicion[] getF() {
        return f;
    }

    /**
     * Agregamos una transicion
     * @param f Transicion
     */
    public void setF(Transicion f) {
        this.f[this.f.length] = f;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
