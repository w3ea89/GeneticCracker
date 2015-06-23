/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticcracker;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.swing.JTextArea;

/**
 *
 * @author Krzysztof Sedlak
 */
public class nGramer {

    int nGramValue;
    HashMap<String, Integer> frequencyMap;
    Map<String, Integer> sortedMap;
    
    ArrayList list;

    public nGramer(int n) {
        nGramValue = n;
        frequencyMap = new HashMap<String, Integer>();
        list = new ArrayList<String>();
    }

    public void readText(String s) {
        String temp = "";
        int index = 0;
        int end = s.length() / nGramValue;
        for (int i = 0; i < end * nGramValue; i++) {
            temp = "";
            for (int j = 0; j < nGramValue; j++) {
                index = i + j;
                if (index < s.length()) {
                    temp = temp + s.charAt(index);
                }
            }
            list.add(temp);

        }

    }

    public void count() {
        for (Object obj : list) {
            String s = (String) obj;
            if (frequencyMap.containsKey(s)) {
                frequencyMap.put(s, frequencyMap.get(s) + 1);
            } else {
                frequencyMap.put(s, 1);
            }
        }
    }

    public void printHash(){
       for(String s: frequencyMap.keySet()){
           System.err.println(s+"   wystąpień: "+frequencyMap.get(s));
           
       }
    }
        public void printHash(JTextArea x){
            x.setText("");
            
        sortedMap = 
     frequencyMap.entrySet().stream()
    .sorted(Entry.comparingByValue())
    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                              (e1, e2) -> e1, LinkedHashMap::new));
       for(String s: sortedMap.keySet()){
           x.append(s+"   wystąpień: "+frequencyMap.get(s)+"\n");
           
       }
    }

            
}
