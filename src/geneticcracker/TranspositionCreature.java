/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticcracker;

/**
 *
 * @author Krzysztof Sedlak
 */
public class TranspositionCreature {

    int[] chromosome;

    public TranspositionCreature(int[] ch) {
        chromosome = ch;
    }

    public String toString() {
        String r ="";
        for (int z : chromosome) {
            r =r + z + "|";
        }
        return r;
    }
}
