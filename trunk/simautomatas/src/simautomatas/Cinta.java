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
public class Cinta {

    ArrayList<Caracter> cinta;

    public Cinta() {
        this.cinta = new ArrayList<Caracter>();
    }

    public Cinta(String cadenaInicial) {
        this.cinta = new ArrayList<Caracter>();

        // grabamos la cadena completa de a caracteres
        grabarCadena(cadenaInicial);
    }

    /**
     * Leemos un caracter de la posicion indicada
     * @param i
     * @return
     */
    public char leer(int i) {
        return this.cinta.get(i).getCaracter();
    }

    /**
     * Grabamos un caracter en la posicion indicada, en el caso de existir
     * lo sobreescribimos
     * @param i
     * @param c
     */
    public void grabar(int i, char c) {
        
        if (cinta.get(i).getCaracter() == 'b') {
            if (i == 0) {
                cinta.add(1, new Caracter(c));
            }
            else {
                cinta.add(i , new Caracter(c));
            }
        }
        else {
            this.cinta.set(i, new Caracter(c));
        }
    }

    public void grabarCadena(String cadenaInicial) {
        // grabamos el blanco del comienzo de la cinta
        this.cinta.add(new Caracter('b'));

        // agreamos de a uno los caracteres de la cadena de entrada
        for (int i=0; i<cadenaInicial.length(); i++) {
            this.cinta.add(new Caracter(cadenaInicial.charAt(i)));
        }

        // grabamos el blanco del final de la cinta
        this.cinta.add(new Caracter('b'));
    }

    /**
     * Borramos un caracter de la posicion indicada por parametro
     * @param i
     */
    public void borrar(int i) {
        this.cinta.remove(i);
    }

    public int getSize() {
        return this.cinta.size();
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i=0; i<cinta.size(); i++) {
            retorno += cinta.get(i).getCaracter() + " ";
        }

        return retorno;
    }

}
