/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticcracker;

import java.util.Random;

/**
 *
 * @author Krzysztof Sedlak
 */
public class KeyGenerator {

    char[] AlphabetForSubstitution;
    int[] AlphabetForTransposition;
char[] codeSubs;
int[] codeTrans;
    public KeyGenerator(int lenghtTranspAlph, String Localize) {

        initTransAlph(lenghtTranspAlph);
        initSubsAlph(Localize);
    }

    public void initTransAlph(int length) {

        AlphabetForTransposition = new int[length];

        for (int i = 0; i < length; i++) {
            AlphabetForTransposition[i] = i + 1;
        }

    }

    public void initSubsAlph(String loc) {
        if (loc.equals("PL")) {
            AlphabetForSubstitution = new char[]{
                'A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'Ł', 'M', 'N', 'Ń', 'O', 'Ó', 'P', 'R', 'S', 'Ś', 'T', 'U', 'W', 'Y', 'Z', 'Ź', 'Ż'
            };
        } else {
            AlphabetForSubstitution = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
            };
        }

    }

    public void printAlphabets() {
        System.err.println("Alfabet Podstawieniowy");
        for (char z : AlphabetForSubstitution) {
            System.err.print(z + " | ");
        }
        System.err.println("");
        System.err.println("Alfabet Przesunięcia");
        for (int z : AlphabetForTransposition) {
            System.err.print(z + " | ");
        }
        System.err.println("");
    }

    public char[] getRandomFromChar(char[] table) {
        Random r = new Random();
        Boolean[] copy = new Boolean[table.length];
        char[] resultTable = new char[table.length];
        initBooleanCopy(copy);
        int temp;
        for (int i = 0; i < table.length; i++) {

            boolean add = false;
            do {
                temp = r.nextInt(copy.length);
                if (copy[temp] == false) {
                    copy[temp] = true;
                    resultTable[i] = table[temp];
                    add = true;
                }
            } while (!add);

        }
     //   printCharTable(resultTable);
     codeSubs=resultTable;
        return resultTable;
    }

    public int[] getRandomFromInt(int[] table, int KeySize) {
        Random r = new Random();
        Boolean[] copy = new Boolean[KeySize];
        int[] resultTable = new int[KeySize];
        initBooleanCopy(copy);
        int temp;
        for (int i = 0; i < KeySize; i++) {

            boolean add = false;
            do {
                temp = r.nextInt(copy.length);
                if (copy[temp] == false) {
                    copy[temp] = true;
                    resultTable[i] = table[temp];
                    add = true;
                }
            } while (!add);

        }
      //  printTranspositionTable(resultTable);
        
        codeTrans=resultTable;
        return resultTable;
    }

    public void initBooleanCopy(Boolean[] table) {
        for (int i = 0; i < table.length; i++) {
            table[i] = false;
        }
    }

    public void printCharTable(char[] tab) {
        System.err.println("Alfabet Podstawieniowy");
        for (char z : tab) {
            System.err.print(z + " | ");
        }
        System.err.println("");

    }

    public void printTranspositionTable(int[] tab) {

        System.err.println("Alfabet Przesunięcia");
        for (int z : tab) {
            System.err.print(z + " | ");
        }
        System.err.println("");
    }
}
