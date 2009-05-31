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

    public Estado valuar(char entrada) throws NoExisteEntrada {
        // comprobamos todas las transiciones
        for (int i=0; i<f.length; i++) {
            // si la entrada ingresada corresponde a entrada, retornamos el estado siguiente
            if (f[i].getEntrada() == entrada) {
                return f[i].getEstadoSiguiente();
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
