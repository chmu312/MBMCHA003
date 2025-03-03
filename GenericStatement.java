/**
 * The GenericStatement classs represnts the linen statement from the textfile
 * It has access methods and modifier methods 
 * The class will have method to update the fact of the key if the confidence score of the input is greater than the already existing fact 
 * with the same key
 * This class practises encapsulation by the use of access modifiers
 * @author Chamunorwa Mboma
 * @version 1.0
 */

public class GenericStatement{
   private String key;
    private String fact;
   private double confidenceScore;
   /** 
    * A constructor for a new GenericStatement object
    * @param  key The unique identifier of the statement 
    * @param fact The actual contents of the generic statment
    * @param confidenceScore The score that validates the statement
    */
    
    public GenericStatement(String key, String fact, double confidenceScore){
    this.key = key;
    this.fact = fact;
    this.confidenceScore = confidenceScore; 
    }
    /**
     * Access method to retreive attributes that have accesss modifiers
     * @return The key of the fact
     */
    public String getKey(){return key;}
    /**
     * Access method to retreive attributes that have accesss modifiers
     * @return The fact of the statement
     */
    public String getFact(){return fact; }
    /**
     * Access method to retreive attributes that have accesss modifiers
     * @return The confidence score of the statement
     */
    public double getConfidenceScore(){return confidenceScore;}
    /**
     * This method serves the purpose of updating the statement object if the confidence score of the new presented fact 
     * is higher than already existing or store one
     * @param newFact This is the statement that is associated confidence score
     * @param newCs This is the confidence score thats going to be used 
     * for comparison with the objects confidence score
     */
 public void updateGenericStatement(String newFact, double newCS){
 if (newScore > this.confidenceScore){
    this.fact= newFact;
    this.confidenceScore = newCS;
 }
 }

}
