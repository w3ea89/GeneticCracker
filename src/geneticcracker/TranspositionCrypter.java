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
public class TranspositionCrypter {

    int[] keyTable;
    char[][] matrix;
    char[][] crypted;
    
    public TranspositionCrypter(int[] key){
        keyTable=key;
    }
    
    
    public void initMatrix(String text){
       int tLength = text.length();
       int mod= tLength%keyTable.length;
       int textIndex=0;
       int full=tLength/keyTable.length;
       if(mod!=0){
           full=full+1;}
       matrix= new char[full][keyTable.length];
        for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                  textIndex=i*keyTable.length+j;
                  if(tLength>textIndex){
                    matrix[i][j]=text.charAt(textIndex);//wypełnia macierz znakami w tekście
                }
                  else{
                      matrix[i][j]=' ';
                  }
                }
        }
        //printTextMatrix(matrix);
    }
    
    public void printTextMatrix(char[][] mat){
                    System.err.println("Tekst w macierzy");
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    System.err.print(mat[i][j]+"|");
    }
                System.err.println("");

            }
    }
        public void printTextMatrixWithCode(char[][] mat){
                    System.err.println("Macierz szyfrująca");
                    for(int x:keyTable){
                        System.err.print(x+"|");
                    }
                      System.err.println("");
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    System.err.print(mat[i][j]+"|");
    }
                System.err.println("");

            }
    }
    
        
        public void cryptMatrix(char[][] matrix, int[] key){
            char [][] matrixCrypted=new char[matrix.length][matrix[0].length];
            for(int i =0;i<matrix.length;i++){//przechodze po kazdym wierszu biorąc kolejne numerki
                for(int j=0; j<matrix[0].length;j++){
                    
                    matrixCrypted[i][key[j]-1]=matrix[i][j];
                    
                }
            }
            crypted = matrixCrypted;
        }
        
           public void decryptMatrix(char[][] matrix, int[] key){
            char [][] matrixCrypted=new char[matrix.length][matrix[0].length];
            for(int i =0;i<matrix.length;i++){//przechodze po kazdym wierszu biorąc kolejne numerki
                for(int j=0; j<matrix[0].length;j++){
                    
                    matrixCrypted[i][j]=matrix[i][key[j]-1];
                    
                }
            }
            crypted = matrixCrypted;
        }
           //
        
        public String matrixToString(char[][] matrix){
            String result="";
                      for(int i =0;i<matrix.length;i++){
                for(int j=0; j<matrix[i].length;j++){
                    result=result+matrix[i][j];
                }                       
        }   
                      //   System.err.println(result);
        return result;
        }
            
            
            
        
}
