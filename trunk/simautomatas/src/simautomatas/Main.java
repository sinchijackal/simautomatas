/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simautomatas;

/**
 *
 * @author Joaquin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // definimos el alf de entrada
        String alf = "01";

        // definimos los estados
        Estado I = new Estado("I");
        Estado A = new Estado("A");
        Estado F = new Estado("F");
        Estado estados[] = {I, A, F};

        // definimos las transiciones
        I.setF(new Transicion('0', A));
        I.setF(new Transicion('1', I));
        A.setF(new Transicion('0', A));
        A.setF(new Transicion('1', F));
        F.setF(new Transicion('0', F));
        F.setF(new Transicion('1', F));

        // creamos el automata
        Automata afd = new Automata(alf, estados, I, new Estado[] {F});

        // probamos valuar una entrada
        afd.evaluarEntrada("0001");
    }

}
