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

public class KbaseArray implements DataStructureOperations{
  private GenericStatement [] kBase;
    private int index ;
/** 
 *initialising the array and index 
 *no paramaters
 *
 */
    public KbaseArray(){
        kBase = new GenericStatement[100000];
        index = 0;

    }
    @Override 
     public void kbExtractor(String filename){
        try(BuffererReader freader = new BufferedReader(new FileReader(filename))){
         String statement;
         while((statement = freader.readline()) != null){
            String[] subContents = statement.split("\t");
            String fact = subContents[1];
            String confidenceString;
            kBase[i] = updateOrAddStatement(statement, index);
         }
        }

     }



}