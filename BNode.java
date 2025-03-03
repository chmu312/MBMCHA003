public class BNode{
    GenericStatemnt statement;
    BNode left;
    BNode right;
    
    public BNode(GenericStatement statement){
    this.statement = statement;
    this.left = null;
    this.right = null;
    }
}