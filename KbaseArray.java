import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Class thats responsible of collecting the Generic Statement from the text file
 * to create a knowledge base in a array structure
 * searching and updating of the statements in the knowledge base
 * another essential feature is going to be able to output text for specific operations
 * 
 * @author Chamunorwa Mboma
 * @version 1.0
 *  Date 3/4/2025
 */

public class KbaseArray {
  private GenericStatement [] kBase;
    private int index ;
/** 
 *initialising the array and index 
 *no paramaters
 *
 */
    public KbaseArray(){
        kBase = new GenericStatement[100000];//Our Knowledge Base has 100000 statements 
        index = 0;//index is going to keep track of where we are in terms of pupulating the array

    }
     
     public void kbExtractor(String filename){
        try(BuffererReader freader = new BufferedReader(new FileReader(filename))){
         String statement;//container for line being read from the file
         while((statement = freader.readline()) != null){
            String[] subContents = statement.split("\t");//splitting the line into its components
            String fact = subContents[1];
            double confidenceScore = Double.parseDouble(subContents[2]);//converting the confidence score to a double
            String key = subContents[0];
            kBase[index] = updateOrAddStatement(key, fact, confidenceScore);//for each entry we need to check if we are updating or adding a new statement to the knowledge base
            index++;//incrementing the index to keep track of where we are in the array
         }
        }
        catch(IOException e){
            System.out.println("The file you entered doesnt not exist");
        }
     }
     /**
      * This method is responsible for searching the knowledge base for a statement with a specific key
      * Parameters : key The key of the statement that is being searched for
      * @param key The key of the statement that is being searched for
      @return The statement that has the key that is being searched for
      */

        public void searchByKey(String key){
            for(int i = 0; i < index; i++){
                if(kBase[i].getKey().equals(key)){
                    System.out.println("Got it !! We have found the fact to do with your key: ",kBase[i].getFact(),"(Confidence score:",kBase[i].getConfidenceScore(),")");
                    return;
                }
            }
            System.out.println("The key was not found in the knowledge base");
        }
    /*
    * This method is responsible for searching the knowledge base for a statement with a specific key and fact
    * Parameters : key The key of the statement that is being searched for  
    * fact The fact of the statement that is being searched for
    * @param key The key of the statement that is being searched for
    * @param fact The fact of the statement that is being searched for
    * @return The statement that has the key and fact that is being searched for
     */
        public void searchByKeyFact(String key, String fact){
            for(int i = 0; i < index; i++){
                if(kBase[i].getKey().equals(key) && kBase[i].getFact().equals(fact)){
                    System.out.println("Go it :) !! The statement has a confidence score of: ",kBase[i].getConfidenceScore());
                    return;
                }
            }
            System.out.println("The key and fact were not found in the knowledge base");
        }

        /**
         * This method is responsible for updating the knowledge base with a new statement or updating an existing statement
         * Parameters : key The key of the statement that is being updated or added
         * fact The fact of the statement that is being updated or added
         * confidenceScore The confidence score of the statement that is being updated or added
         * @param key The key of the statement that is being updated or added
         * @param fact The fact of the statement that is being updated or added
         * @param confidenceScore The confidence score of the statement that is being updated or added
         */
        public void updateOrAddStatement(String key, String fact, double confidenceScore){
            for(int i = 0; i < index; i++){
                if(kBase[i].getKey().equals(key)){
                    kBase[i].updateGenericStatement(fact, confidenceScore);//if the key is found we update the statement
                    return;
                }
            }
            kBase[index] = new GenericStatement(key, fact, confidenceScore);//if the key is not found we add a new statement`1
            
        }

    /**
     * This method is responsible for outputting the knowledge base in a specific format
     * Parameters : none
     * @return The knowledge base in a specific format
     */
        public void guessCsKb(string key,double guessConfidenceScore){
            for (int i = 0;i <index;i++){
                if(kBase[i].getKey().equals(key)){
                    if(kBase[i].getConfidenceScore() == guessConfidenceScore){
                        System.out.println("You guess correctly the confidence for the key:",key,"is:",guessConfidenceScore);// if the confidence score is correct we output the message
                        return;
                    }
                    else{
                        System.out.println("Booooo!:( :(",guessConfidenceScore,"is incorrect");//if the confidence score is incorrect we output the message
                        return;
                    }
                }
            }
        }
     
}