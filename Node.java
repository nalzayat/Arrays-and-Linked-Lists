public class Node<T> {
  protected static final int NULL = -1;
  protected int previous;
  protected int next;
  protected T data;
 
  // Constructor initializes data members. See method init().
  protected Node(){
    init();
  }
 
  // Create a pretty representation of the pool
  // Format: [previous,next,data]
  // Target Complexity: O(n)
  public String toString(){
    // Will return the node in a string format of, [previous,next,data]
    return("[" + this.previous + "," + this.next + "," + this.data + "]");
  }
 
  // Initializes the data members. 
  // Called by the constructor and also by method reset() 
  // in class NodePool.
  // Target Complexity: O(1)
  protected void init(){
    this.previous = NULL;              // Previous is now equal to NULL which is -1
    this.next = NULL;                  // Next is now equal to NULL which is -1
    this.data = null;                  // Data is now equal to null 
  }
} 