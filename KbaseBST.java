import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Class thats responsible of collecting the Generic Statement from the text file
 * to create a knowledge base in a array structure
 * searching and updating of the statements in the knowledge base
 * another essential feature is going to be able to output text for specific operations
 * THIS IMPLEMENTATION HAS BEEN BEING RETRIEVED FROM MULTIPLE SOURCES
 * @author Chamunorwa Mboma
 * @version 1.0
 *  Date : 3/5/2025
 */

public class KbaseBST {
    private BNode root;
    
/**
 * This is constructor for the KbaseBST class
 * It initialises the root of the tree to null
 * and the height of the tree to 0
 * Parameters : None

 */
    public KbaseBST(){
        root = null; //This is the root of the tree is set to null to indicate that the tree is empty
    
    }
    /**
     * This method is responsible for extracting the statements from the text file
     * and inserting them into the binary search tree
     * Parameters : filename The name of the file that contains the statements
     */
    public BNode insert(BNode root, GenericStatement statement){
        if (root == null){
            root = new BNode(statement);
        }
        else if (statement.getKey().compareTo(root.statement.getKey()) < 0){
            root.left = insert(root.left, statement);
        }
        else if (statement.getKey().compareTo(root.statement.getKey()) > 0){
            root.right = insert(root.right, statement);
        }
        return root;
    }
    /**
     * This method is responsible for extracting the statements from the text file
     * and inserting them into the binary search tree
     * Parameters : filename The name of the file that contains the statements
     */
    
    public void kbExtractor(String filename){
        try(BufferedReader freader = new BufferedReader(new FileReader(filename))){
            String statement;
            while((statement = freader.readLine()) != null){
                String[] subContents = statement.split("\t");
                String key = subContents[0];
                String fact = subContents[1];
                double confidenceScore = Double.parseDouble(subContents[2]);
                GenericStatement newStatement = new GenericStatement(key, fact, confidenceScore);
                root = insert(root, newStatement);
            }
        }
        catch(IOException e){
            System.out.println("This file was not found");
        }
    }
    /**
     * This method is responsible for searching for a statement in the binary search tree
     * Parameters : key The key of the statement that is being searched for
     */
    
     
    public void searchByKey(String key){
        BNode current = root;
        while(current != null){
            if (key.compareTo(current.statement.getKey()) < 0){
                current = current.left;
            }
            else if (key.compareTo(current.statement.getKey()) > 0){
                current = current.right;
            }
            else{
                System.out.println("Got it !! We have found the fact to do with your key: "+current.statement.getFact() 
                +"(Confidence score:"+current.statement.getConfidenceScore()+")");
                return;
            }
        }
        System.out.println("The statement was not found");

}
/**
 * This method is responsible for searching for a statement in the binary search tree
 * Parameters : key The key of the statement that is being searched for
 * fact The fact of the statement that is being searched for
 */
public void searchByKeyFact(String key, String fact){
    BNode current = root;
    while(current != null){
        if (key.compareTo(current.statement.getKey()) < 0){
            current = current.left;
        }
        else if (key.compareTo(current.statement.getKey()) > 0){
            current = current.right;
        }
        else{
            if (fact.equals(current.statement.getFact())){
                System.out.println("Go it :) !! The statement has a confidence score of: "+
                    current.statement.getConfidenceScore());
                return;
            }
            else{
                System.out.println("The statement was not found :<");
                return;
            }
        }
    }
    System.out.println("The statement was not found :<");
}
/**
 * This method is responsible for updating a statement in the binary search tree
 * Parameters : fact The fact of the statement that is being updated
 * confidenceScore The confidence score of the statement that is being updated
 * @param key The key of the statement that is being updated
 * @param fact The fact of the statement that is being updated
 * @param confidenceScore The confidence score of the statement that is being updated
 */
public void updateOrAddStatement(String key, String fact, double confidenceScore){
    BNode current = root;
    while(current != null){
        if (key.compareTo(current.statement.getKey()) < 0){
            current = current.left;
        }
        else if (key.compareTo(current.statement.getKey()) > 0){
            current = current.right;
        }
        else{
            current.statement.updateGenericStatement(fact, confidenceScore);
            return;
        }
    }
    GenericStatement newStatement = new GenericStatement(key, fact, confidenceScore);
    root = insert(root, newStatement);

}
/**
 * Method to calculate the height of the binary search tree
 * Parameters : root The root of the binary search tree
 * @param root The root of the binary search tree
 * @return The height of the binary search tree
 */
public int height(BNode root){
    if (root == null){
        return 0;
    }
    else{
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight > rightHeight){
            return (leftHeight + 1);
        }
        else{
            return (rightHeight + 1);
        }
    }
}
/**
 * Method to print the binary search tree in a order
 * Parameters : root The root of the binary search tree
 * @param root The root of the binary search tree
 *  @return The binary search tree in a order
 */
public void printInOrder(BNode root){
    if (root != null){
        printInOrder(root.left);
        System.out.println(root.statement.getKey() + "\t" + root.statement.getFact() + "\t" + root.statement.getConfidenceScore());
        printInOrder(root.right);
    }}

    /*
     * This method is responsible for outputting the knowledge base in a postorder format
     * Parameters : root
     * @param root The root of the binary search tree
     * @return The knowledge base in a postorder format
     */
    public void printPostOrder(BNode root){
        if (root != null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.println(root.statement.getKey() + "\t" + root.statement.getFact() + "\t" + root.statement.getConfidenceScore());
        }}
    /*
     * This method is responsible for outputting the knowledge base in a preorder format
     * Parameters : root
     * @param root The root of the binary search tree
     * @return The knowledge base in a preorder format
     */
    public void printPreOrder(BNode root){
        if (root != null){
            System.out.println(root.statement.getKey() + "\t" + root.statement.getFact() + "\t" + root.statement.getConfidenceScore());
            printPreOrder(root.left);
            printPreOrder(root.right);
        }}

}