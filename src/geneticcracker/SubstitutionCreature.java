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
public class SubstitutionCreature {
    
    char[] chromosome;
    
    
    public SubstitutionCreature(char[] code){
       chromosome=code;
    }
    
    
      public String toString() {
        String r ="";
        for (char z : chromosome) {
            r =r + z + "|";
        }
        return r;
    }
    
}
    

