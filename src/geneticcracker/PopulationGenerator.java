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
public class PopulationGenerator {

    int transKeySize;
    int tOs;   /////////Choosen transposition or substitution cipher
    int populationSize;
    TranspositionCreature[] transPopCreatures;
    SubstitutionCreature[] substPopCreature;
    KeyGenerator kg;

    public PopulationGenerator() {
    }

    public PopulationGenerator(int n, int transORsubs, int size) {
        transKeySize = n;
        tOs = transORsubs;
        kg = new KeyGenerator(n, "PL");
        populationSize = size;

        if (transORsubs == 0) {
            initTranspositionPopulation();
        }
        else{
            initSubstitutionPopulation();
        }
    }

    public PopulationGenerator(int transORsubs, int size) {
        kg = new KeyGenerator(2, "PL");
        tOs = transORsubs;
        populationSize = size;

       if (transORsubs == 0) {
            initTranspositionPopulation();
        }
        else{
            initSubstitutionPopulation();
        }
    }

    public void initTranspositionPopulation() {
        transPopCreatures = new TranspositionCreature[populationSize];
        for (int i = 0; i < populationSize; i++) {
            transPopCreatures[i] = new TranspositionCreature(kg.getRandomFromInt(kg.AlphabetForTransposition, transKeySize));///nowy osobnik z losowym DNA
        }
    }

    public void initSubstitutionPopulation() {
        substPopCreature = new SubstitutionCreature[populationSize];
        for (int i = 0; i < populationSize; i++) {
            substPopCreature[i] = new SubstitutionCreature(kg.getRandomFromChar(kg.AlphabetForSubstitution));
        }

    }

    public void printTransPop() {
        for (TranspositionCreature t : transPopCreatures) {
            System.err.println(t);
        }
    }

    public void printSubsPop() {
        for (SubstitutionCreature t : substPopCreature) {
            System.err.println(t);
        }

    }

}
