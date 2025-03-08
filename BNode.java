/**
 * @author Chamunorwa Mboma
 * Date : 3/3/2025
 * @version 1.0
 * Definition of a node in a binary tree
 * this will act as the back bone of thee binary search treee
 * Making use of the GenericStatement class that I defined as the type of the contents of the tree  
 */
public class BNode{
    GenericStatement statement;//This is the statement from the knowlegde bass that is going to be stored in the node
    BNode left;//This the left child of the node, it is a reference to the left child of the node
    BNode right;//This is the right child of the node, it is a reference to the right child of the node
/**
 * Method to construct an object of BNode type 
 * @param statement This is the input object of GenericStatement type 
 */ 
    public BNode(GenericStatement statement){
    this.statement = statement;//This the initial stattement to be stored it acts a the root of the tree
    this.left = null;//This is null due to the fact at the moment the tree is empty,our tree is made of roots pointing at each other
    this.right = null;//This is null due to the fact at the moment the tree is empty,our tree is made of roots pointing at each other
    }
}