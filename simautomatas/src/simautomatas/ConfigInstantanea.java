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

    private Estado estado;
    private String cadenaRestante;
    private ArrayList<Caracter> pila;

    public ConfigInstantanea(Estado estado, String cadenaRestante) {
        this.cadenaRestante = cadenaRestante;
        this.estado = estado;
    }

    public ConfigInstantanea(Estado estado, String cadenaRestante, ArrayList<Caracter> pila) {
        this.estado = estado;
        this.cadenaRestante = cadenaRestante;
        this.pila = pila;
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

    @Override
    public String toString() {
        String retorno = "";

        // verificamos si tiene pila
        retorno += "(" + estado.getNombre() + ", '" + cadenaRestante + "')";

        return retorno;
    }

}
