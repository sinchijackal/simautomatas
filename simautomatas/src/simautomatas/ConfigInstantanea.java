/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

import java.util.ArrayList;


/**
 * Clase de Configuración Instantánea para un Automata Generico
 * @author Joaquin
 */
public class ConfigInstantanea {

    private Estado estado;              // Para TODOS los Automatas
    private String cadenaRestante;      // Para AF, AP
    private ArrayList<Caracter> pila;   // Para AP
    private Cinta cinta;                // Para MT
    private int cabezal;                // Para MT

    /**
     * Constructor de Configuracion instantanea para los Automatas Finitos
     * de la forma (q, "cadenaRestante")
     * @param estado
     * @param cadenaRestante
     */
    public ConfigInstantanea(Estado estado, String cadenaRestante) {
        this.cadenaRestante = cadenaRestante;
        this.estado = estado;
    }

    /**
     * Constructor de Configuracion instantanea para los Automatas a Pila
     * de la forma (q, "cadenaRestante", Pila)
     * @param estado
     * @param cadenaRestante
     * @param pila
     */
    public ConfigInstantanea(Estado estado, String cadenaRestante, ArrayList<Caracter> pila) {
        this.estado = estado;
        this.cadenaRestante = cadenaRestante;
        this.pila = pila;
    }

    /**
     * Constructor de Configuracion instantanea para la Maquina de Turing
     * de la forma (q, Cinta, posicionDelCabezal)
     * @param estado
     * @param cinta
     * @param cabezal
     */
    public ConfigInstantanea(Estado estado, Cinta cinta, int cabezal) {
        this.estado = estado;
        this.cinta = cinta;
        this.cabezal = cabezal;
    }

    public String getCadenaRestante() {
        return cadenaRestante;
    }

    public void setCadenaRestante(String cadenaRestante) {
        this.cadenaRestante = cadenaRestante;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Caracter> getPila() {
        return pila;
    }

    public void setPila(ArrayList<Caracter> pila) {
        this.pila = pila;
    }

    public int getCabezal() {
        return cabezal;
    }

    public void setCabezal(int cabezal) {
        this.cabezal = cabezal;
    }

    public Cinta getCinta() {
        return cinta;
    }

    public void setCinta(Cinta cinta) {
        this.cinta = cinta;
    }

    @Override
    public String toString() {
        String retorno = "";

        // verificamos si tiene pila
        retorno += "(" + estado.getNombre() + ", '" + cadenaRestante + "')";

        return retorno;
    }

}
