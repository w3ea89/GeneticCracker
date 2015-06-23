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
public class SubstitutionCrypter {
    
    char[][] cryptMatrix;
    
    
    public SubstitutionCrypter(char[] alpha,char[] k){
        cryptMatrix = new char[2][alpha.length];
        cryptMatrix[0]=alpha;
        cryptMatrix[1]=k;
        
    }
    
  
    
    
    public String cryptString(String s){
     String crypted="";
     boolean kropka=true; 
     char temp;
     for(int i=0;i<s.length(); i++){
      temp=s.charAt(i);
      kropka=true;
      for(int j=0;j<cryptMatrix[1].length;j++){
          if(temp==cryptMatrix[0][j]){
          crypted=crypted+cryptMatrix[1][j];          
              kropka=false;
                  break;
                    }
         
                }
      
       if(kropka){//przepisze znaki białe i interpunkcyjne
              
               crypted=crypted+temp;
          }
     }   
     printCryptRules();
     return crypted;   
    }
    public String deCryptString(String s){
     String decrypted="";
     boolean kropka=true; 
     char temp;
     for(int i=0;i<s.length(); i++){
      temp=s.charAt(i);
      kropka=true;
      for(int j=0;j<cryptMatrix[1].length;j++){
          if(temp==cryptMatrix[0][j]){
          decrypted=decrypted+cryptMatrix[1][j];          
              kropka=false;
                  break;
                    }
         
                }
      
       if(kropka){//przepisze znaki białe i interpunkcyjne
              
               decrypted=decrypted+temp;
          }
     }   
     printCryptRules();
     return decrypted;   
    }

public void printCryptRules(){
    System.err.println("Tablica szyfrująca");
    for(char x: cryptMatrix[0]){
        System.err.print(x+"|");
    }
    System.err.println("");
   for(char x: cryptMatrix[1]){
        System.err.print(x+"|");
    }
       System.err.println("");
}
}