
import java.util.*;
import java.io.*;

public class NodePool<T> extends ObjectPool<Node<T>> { // The data element of a Node has type T
  // Constructor invokes the constructor of the parent class.
  // Throws IllegalArgumentException if maxSize < 1
  NodePool(int maxSize){
    super(maxSize); // Invokes parent class constructor (Parent will throw exception if needed)
  }
 
  // Returns a newly constructed Node with data type T. 
  // Called when an object is requested from an empty pool.
  // Target Complexity: O(1)
  protected Node<T> create(){
    Node<T> newNode = new Node<T>(); // Creates a new instance of a generic type node
    return newNode;                  // Returns the new node
  }
 
  // Resets values of x to their initial values. 
  // Called when an empty Node is released back to the pool.
  // Empty nodes are released to the NodePool by methods clear() 
  // and compress() in class ArrayLinkedList, as described below.
  // Target Complexity: O(1)
  protected Node<T> reset(Node<T> x){
    x.init(); // Calls the method init to initialize data members
    return x; // Returns x 
  }
}