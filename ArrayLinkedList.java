import java.util.*;

class ArrayLinkedList<T> {
    protected final static int NULL = -1;      
    protected ArrayList<Node<T>> array;
    protected NodePool<T> pool;
    protected int head;                // position of dummy node in array
    protected int tail;                // position of tail node in array
    protected int firstEmpty;          // head of the list of empty nodes
    protected int numberEmpty;         // number of empty nodes
    protected int size;                // number of non-empty nodes
    protected int modCount;            // number of modifications made
    protected final static int NODEPOOLSIZE = 8;
 
    // Constructor to initialize the data members, increment modCount,
    // create the dummy header Node, and add it to array
    public ArrayLinkedList(){
      this.array = new ArrayList<Node<T>>();          // Initialize the array
      this.pool = new NodePool<T>(NODEPOOLSIZE);      // Initialize the NodePool
      this.firstEmpty = NULL;                         // There are no empty nodes yet, set to NULL which is -1
      this.numberEmpty = 0;                           // No empty nodes yet, set to 0
      this.head = 0;                                  // Initialize head and tail to be index 0
      this.tail = 0;
      this.size = 0;                                  // Initialize the size to be 0
      Node<T> dummyHead = pool.allocate();            // Allocate a node for the dummy
      array.add(0,dummyHead);                         // Add it to the empty array at index of 0
      dummyHead.init();                               // Make sure the dummy is null/NULL   
      modCount ++;                                    // Increment modCount
    }
 
    // Return number of non-empty nodes
    // Target Complexity: O(1)
    public int size(){
      return this.size;                               // Return size which is the number of non-empty nodes
    }
 
    // convenience methods for debugging and testing
    // Return firstEmpty
    protected int getFirstEmpty(){
      return this.firstEmpty;                        // Returns the first empty node index
    }
    // Return head
    protected int getHead(){
      return this.head;                              // Returns the head node index 
    }
    // Return tail
    protected int getTail(){  
      return this.tail;                              // Returns the tail node index
    }
    // Return array
    protected ArrayList<Node<T>> getArray(){
      return this.array;                            // Returns the array
    }
        
    // Appends the specified element to the end of this list. 
    // Returns true.
    // If no empty Nodes are available, then get a new Node from pool.
    // Throws IllegalArgumentException if e is null.
    // Checks assertions at the start and end of its execution.
    // Target Complexity: Amortized O(1)
    public boolean add(T e) {
        assert size>=0 && head==0 && numberEmpty >=0 && (numberEmpty==0    // Provided by the professors 
         && firstEmpty==NULL) || (numberEmpty>0 && firstEmpty!=NULL)
          && (array.size() == size+numberEmpty+1);         
        
        // My code
        if(e == null){
          throw new IllegalArgumentException();                      // Throws new illegalArgumentException
        }
        
        Node<T> emptyNode;                                           // Creates a new node object
        if(this.numberEmpty > 0){                                    // If there are empty nodes within the array
          emptyNode = this.array.get(firstEmpty);                    // Gets the first empty node from the Array                                         
          if(emptyNode.next == NULL){                                // Checks if it is the only empty node in the Array
            this.numberEmpty = 0;                                    // The number empty should now be equal to zero
            this.firstEmpty = NULL;                                  // First empty is now -1 because there are no empty nodes in the array
          }
                                                                     // In cases the node is NOT the only empty node in the array
          else{
            this.firstEmpty = this.array.get(this.firstEmpty).next;  // Updates firstEmpty to be the next empty node in the array
            this.numberEmpty --;                                     // Decrements numberEmpty
           }
        }
        else{
          emptyNode = pool.allocate();                               // Gets an empty node from the pool stack
          this.array.add(emptyNode);                                 // Adds the node to the array
        }
        emptyNode.init();
        emptyNode.data = e;                                          // Sets the data of the new empty node to e
        this.array.get(this.tail).next = array.indexOf(emptyNode);
        emptyNode.previous = this.tail; 
        this.tail = array.get(this.tail).next;                       // Change pointers so that the tail is updated to its next
        this.size ++;                                                // Increment the size 
        this.modCount ++;
        // End my code
 
        // check this assertion before each return statement
        assert size>0 && head==0 && numberEmpty >=0 
          && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0   // Provided by professors 
            && firstEmpty!=NULL)
            && (array.size() == size+numberEmpty+1);
        return true;
    }
 
    // Inserts the specified element at the specified index in this list.  
    // Shifts the element currently at that index (if any) and any 
    // subsequent elements to the right (adds one to their indices).    
    // Throws IndexOutOfBoundsException if the index is out of range 
    // (index < 0 || index > size()).
    // Throws IllegalArgumentException if e is null.
    // Can call add(T e) if index equals size, i.e., add at the end
    // Checks assertions at the start and end of its execution.
    // Target Complexity: O(n)
    public void add(int index, T e) {
       assert size>=0 && head==0 && numberEmpty >=0                // Provided by professors
         && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0 
           && firstEmpty!=NULL) && (array.size() == size+numberEmpty+1);
 
       // My code
       if(e == null){                                              // If e is null it will throw an exception
          throw new IllegalArgumentException();
        }
       else if(index < 0 || index > this.array.size()){            // If the index requested is less than or equal to zero or greater than the array size throw an exception
         throw new IndexOutOfBoundsException();
       }
       else if(index == this.array.size()){                        // Add it to the end if the index is equal to the array size
         add(e);
       }
       else{
         add(e);                                                   // Will add it to the end of the array
         Node<T> tempNode = this.array.get(this.head);             // Will create an empty node to loop through nodes
         int i = 0;                                                // Counter to iterate through linked list
         while(tempNode.next != NULL){                             // As long as the next of the head is not null iterate through the linked list
           if(i == index){
             this.array.get(this.tail).next = tempNode.next;       // Get the tail from the array and make its next temps next
             this.array.get(tempNode.next).previous = this.tail;   // Get the next of the tempnode from the array and make its previous the tail
             tempNode.next = this.tail;                            // Make the tempnode point to tail
             Node<T> lastNode = array.get(tail);                   // Get the tail node 
             (this.array.get(lastNode.previous)).next = NULL;      // Make the last nodes previous point to null
             this.tail = lastNode.previous;                        // Make the tail no equal to the old tails previous 
             this.array.get(tempNode.next).previous = this.array.indexOf(tempNode);
           }
           i++;                                                    // Increments counter
           tempNode = this.array.get(tempNode.next);               // Updates the temp node to be the next node
         }
       }
       // End my code
       
       // check this assertion before each return statement
       assert size>0 && head==0 && numberEmpty >=0                 // Provided by professors
         && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0 
             && firstEmpty!=NULL) && (array.size() == 
                 size+numberEmpty+1);
       return;
    }
 
    // Equivalent to add(0,e).
    // Throws IllegalArgumentException if e is null
    // Target Complexity: O(1)
    public void addFirst(T e){
      add(0,e); // Add element e of type t to the beginning of the list
    }
 
    // Equivalent to add(e).
    // Throws IllegalArgumentException if e is null
    // Target Complexity: O(1)
    public void addLast(T e){
      add(e); // Add element e of type t to the end array 
    }
 
    // Add all of the elements (if any) in Collection c to the end 
    // of the list, one-by-one.
    // Returns true if this list changed as a result of the call.
    // Throws NullPointerException if the specified collection is null
    // Target Complexity: O(number of elements in c)
    @SuppressWarnings("")
    public boolean addAll(Collection<? extends T> c){
      if(c == null){                 
        throw new NullPointerException();        // Will throw a null pointer exception if c is null
      }                                          // You do not need to change it into an array to loop through it but I did by looking up the Java docs on collections
      Object[] newArray = c.toArray();           // Converts the collection into an array of objects
      for(int i = 0; i < newArray.length; i++){  // Loops through the array to access each element
        T newObj = (T)newArray[i];               // Casts the element in the array and adds it 
        add(newObj);
      }
      return true;
    }
 
    // Returns true if this list contains the specified element.
    // Throws IllegalArgumentException if e is null
    // May call indexOf(e)
    // Target Complexity: O(n)
    public boolean contains(T e){
      if(e == null){                               // If e is null it will throw an exception
          throw new IllegalArgumentException();
        }
      else if((indexOf(e)) == -1){                // If it is not present in the array indexOf will return -1
        return false;                             // Therefore will return 1 
      }
      return true;                                // Otherwise it exists in the array and will return true
    }
 
 
    // Returns the index of the first occurrence of the 
    // specified element in this list,
    // or NULL if this list does not contain the element.
    // Throws IllegalArgumentException if e is null
    // Target Complexity: O(n)
    public int indexOf(T e){
      if(e == null){                                 // If e is null it will throw an exception
          throw new IllegalArgumentException();
        }
     int counter = 0;                                // Counter starts at index 0
     Node<T> tempNode = this.array.get(this.head);   // Tempnode is equal to the head of the list
     while(tempNode.next != NULL){                   // While the tempnodes next is not NULL do the following
       if(this.array.get(tempNode.next).data.equals(e)){
         return counter;
       }
       counter ++;                                   // Increments counter
       tempNode = this.array.get(tempNode.next);     // Updates the tempnode to point to the next node
     }
      return NULL;                                   // Returns NULL
    }
    
   // Returns the array position of the first occurrence of 
   // the specified element in array
   // or NULL (-1) if this list does not contain the element. 
   // Note that the return value is a position in the array, 
   // not the index of an element in the list.
   // Called by remove(T e) to find the position of e in the array.
   // Throws IllegalArgumentException if e is null
   // Target Complexity: O(n)
    protected int positionOf(T e){
      if(e == null){                                      // If e is null it will throw an exception
          throw new IllegalArgumentException();
        }
      for(int i = 0; i < this.array.size(); i++){         // Loops through the array
        if(this.array.get(i).data == (e)){                // If the data at index i is equal to e return the index i
          return this.array.indexOf(this.array.get(i));   // Returns the index of element e
        }
      }
      return NULL;                                        // Returns NULL if the list does not contain the element
    }
   
 
    // Returns the element at the specified index in this list.
    // Throws IndexOutOfBoundsException if the index is out 
    // of range (index < 0 || index >= size())
    // Target Complexity: O(n)
    public T get(int index){
      if(index < 0 || index >= this.size()){
        throw new IndexOutOfBoundsException();            // Throws exception if the index is out of range
      }
      int counter = 0;                                    // Counter to keep track of nodes
      Node<T> tempNode = this.array.get(this.head);       // Makes a temp node that points to the head 
      Node<T> answerNode = tempNode; 
      while(tempNode.next != NULL){                       // As long as the next is not NULL do this
        if(counter == index){                             // If the counter is equal to the index
          answerNode = this.array.get(tempNode.next);     // Update answer to be the arrays index of tempNodes next  
        }
        counter++;                                        //  Increment counter
        tempNode = this.array.get(tempNode.next);         // Update tempNode to be the next node
      }
      return answerNode.data;                             // Return the data
    }
 
    // Returns the first element in the list.
    // Throws NoSuchElementException if the list is empty
    // Target Complexity: O(1)
    public T getFirst(){
      if(this.size == 0){
        throw new NoSuchElementException();                    // Throws exception
      }
      return get(0);                                           // Otherwise it will return the first element in the list but using the method get
    }
 
    // Returns the last element in the list
    // Throws NoSuchElementException if the list is empty
    // Target Complexity: O(1)
    public T getLast(){
      if(this.size == 0){                                     // If the size is equal to zero throw an exception
        throw new NoSuchElementException();
      }
      return get(this.size-1);                                // Return the data at this index
    }
 
    // Remove the node at position current in the array.
    // Note that current is a position in the array, not the 
    // index of an element in the list.
    // The removed node is made empty and added to the front 
    // of the list of empty Nodes.
    // Called by remove(T e) and remove(int index) to 
    // remove the target Node.
    // Target Complexity: O(1)
    protected void removeNode(int current) {
       assert current > 0 && current < array.size();       
       Node<T> current_n = this.array.get(current);             // Gets the node at that index in the array
       Node<T> next_n = null;                                   // Sets both the previous and next of the current node to null so we can access later on
       Node<T> previous_n = null;
       if(current_n.next == NULL){                              // Meaning the current is the tail
         previous_n = this.array.get(current_n.previous);       // Get the previous node 
         previous_n.next = NULL;                                // Make the previous node of current point to null
         this.tail = current_n.previous;                        // Update the tail to be the index of the previous node of current
         // OR: this.tail = this.array.indexOf(previous_n);
       }
       else{
         previous_n = this.array.get(current_n.previous);       // Get the previous node of current 
         next_n = this.array.get(current_n.next);               // Get the next node of current
         previous_n.next = current_n.next;                      // Make them point to one another, removing current from between them
         next_n.previous = current_n.previous;
       }
       this.size--;                                             // Decrement and increment accordingly for removal of a node
       this.numberEmpty ++;
       pool.reset(current_n); 
       current_n.next = this.firstEmpty;
       this.firstEmpty = this.array.indexOf(current_n);
       this.modCount ++;
    }
    
    // Removes the first occurrence of the specified element from 
    // this list, if it is present. Returns true if this
    // list contained the specified element.
    // Throws IllegalArgumentException if e is null.
    // Checks assertions at the start and end of its execution.
    // Target Complexity: O(n)
    public boolean remove(T e) {                                          // Check if correct
 
       assert size>=0 && head==0 && numberEmpty >=0
        && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0         // Code provided by professors 
          && firstEmpty!=NULL) && (array.size() == size+numberEmpty+1);
       
       // My code
       int first_occurence = positionOf(e);                               // Calls method positionOf that will throw illegalArgumentException 
       if(first_occurence == NULL){                                       // If it is not within the list return false
         return false;
       }
       removeNode(first_occurence);                                       // Otherwise remove the first occurence
       // End my code
       
       // check this assertion before each return statement
       assert size>=0 && head==0 && numberEmpty >=0                       // Code provided by professors 
         && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0 
          && firstEmpty!=NULL) && (array.size() == size+numberEmpty+1);
       return true;
    }
 
    // Removes the element at the specified index in this list.
    // Shifts any subsequent elements to the left (subtracts one from
    // their indices). Returns the element that was removed from the 
    // list. Throws IndexOutOfBoundsException if the index is 
    // out of range (index < 0 || index >= size)
    // Checks assertions at the start and end of its execution.
    // Target Complexity: O(n)
    public T remove(int index) {
      
      assert size>=0 && head==0 && numberEmpty >=0 
        && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0 
          && firstEmpty!=NULL) && (array.size() == size+numberEmpty+1);
     
      if(index < 0 || index >= size){
        throw new IndexOutOfBoundsException();                      // Throws indexOutofBoundsException
      }   
      T data = get(index);                                          // Gets the data at that index
      remove(data);                                                 // Removes it 
      /*
      // My code (Old Code that did not work)
      Node<T> temp = null;                                          // Creates a temp node 
      if(index < 0 || index >= size){
        throw new IndexOutOfBoundsException();                      // Throws indexOutofBoundsException
      }                                                             
      
      temp = this.array.get(head);                                   // Makes temp point to dummy node head
      int counter = 0;                                              // Counter to keep track of number of nodes passed
      while(temp.next != NULL){                                     // While the temps next is NOT null (Not the end of the list)
        temp = this.array.get(temp.next);                           // Update the temp to be the next node 
        counter ++;     
        if(counter == index){                                       // If the counter and index are the same
          remove(this.array.indexOf(temp));                         // Remove the node by calling the remove method and passing in the element
        }                                          
      }
      if(temp.next == NULL && counter == index){
        (this.array.get(temp.previous)).next = NULL;
        this.tail = temp.previous;
      }
       // End my code
       */
      
        // check this assertion before each return statement
       assert size>=0 && head==0 && numberEmpty >=0 && (numberEmpty==0 
        && firstEmpty==NULL) || (numberEmpty>0 && firstEmpty!=NULL) 
        && (array.size() == size+numberEmpty+1);
        return data;                                                 // Return the data
    }
 
    // Returns the first element in the list.
    // Throws NoSuchElementException if the list is empty.
    // Equivalent to remove(0), for index 0
    // Target Complexity: O(1)
    public T removeFirst(){
      if(this.array.get(this.head).next == NULL){                   // If the next node of the head is NULL
        throw new NoSuchElementException();                         // Throws exception
      }
      int first_index = this.array.get(this.head).next;             // Gets the index of the next node in the array  
      Node<T> first_Node = this.array.get(first_index);             // Gets the node at that index
      T data = first_Node.data;                                     // Gets the data from that node and removes it 
      remove(0);
      return(data);
    }
 
    // Returns the last element in the list
    // Throws NoSuchElementException if the list is empty
    // Equivalent to remove(size-1), for index size-1
    // Target Complexity: O(1)
    public T removeLast(){
      if(this.array.get(this.head).next == NULL){
        throw new NoSuchElementException();
      }
      Node<T> current = this.array.get(tail);                     // Current is the last node 
      T data_node = current.data;                                 // Saves the data in that node because I will reset it later 
      Node<T> previous_n = this.array.get(this.array.get(tail).previous);
      previous_n.next = NULL;                                        
      tail = current.previous;
      if(this.firstEmpty == NULL){                                // This will be the first empty node in the list
        this.firstEmpty = this.array.indexOf(current);            // Changes the first index to be the index of the current 
        pool.reset(current);                                      // Resets the node
      }
      else{                                                       // There is another empty node 
        pool.reset(current); 
        current.next = firstEmpty;
        this.firstEmpty = this.array.indexOf(current);
        
      }
      this.size--;                                                // Increments and decrements accordingly                       
      this.numberEmpty ++; 
      this.modCount ++;
      return data_node;
    }
      // Old Code that didn't work 
      /*
      if(this.array.get(this.head).next == NULL){                   // If the list is empty throw an exception
        throw new NoSuchElementException();
      }
      Node<T> last_Node = this.array.get(this.tail);                // Gets the last node in the list
      int counter = 0;
      remove(this.tail);                                            // Removes it from the list and returns its data
      return last_Node.data; 
    }*/
 
    // Returns true if the Node at the specified position in the 
    // array is an empty node.
    // Target Complexity: O(1)
    protected boolean positionIsEmpty(int position) {             
      assert position > 0 && position < array.size();
       return (this.array.get(position)).data == null;
    }
 
    // Returns number of empty nodes.
    // Target Complexity: O(1)
    protected int numEmpty(){
      return this.numberEmpty;
    }
 
    // Replaces the element at the specified position in this 
    // list with the specified element. Returns the element 
    // previously at the specified position.    
    // Throws IllegalArgumentException if e is null.
    // Throws IndexOutOfBoundsException if index is out of 
    // range (index < 0 || index >= size)
    // Target Complexity: O(n)
    public T set(int index, T e){
      if (index < 0 || index >= size){
        throw new IndexOutOfBoundsException();            // If the index is out of bounds throw exception
      }
      else if(e == null){
        throw new IllegalArgumentException();             // If e null throw exception
      }
      Node<T> temp_node = this.array.get(head);           // Creates a pointer to the head node
      T data = null;                                      // Makes a variable to store future data
      int counter = 0;                                    // Counter to keep track
      while(temp_node.next != NULL){
        if(counter == index){
          data = temp_node.data;
          (this.array.get(temp_node.next)).data = e;      // Changes the data to be e
        }
        counter ++;                                       // Increments the counter and updates the pointer to point to the next node
        temp_node = this.array.get(temp_node.next);  
      }
      return data;
    }
 
    // Removes all of the elements from this list. 
    // The list will be empty after this call returns.
    // The array will only contain the dummy head node.
    // Some data members are reinitialized and all Nodes
    // are released to the node pool. modCount is incremented.
    // Target Complexity: O(n)
    public void clear() {
       assert size>=0 && head==0 && numberEmpty >=0 
        && (numberEmpty==0 && firstEmpty==NULL) || (numberEmpty>0 
        && firstEmpty!=NULL) && (array.size() == size+numberEmpty+1);
       
       ArrayList<Node<T>> newArray = new ArrayList<Node<T>>();     // Creates a new array 
       for(int i = 1; i < this.array.size(); i++){                 // Loops through the old array
         pool.release(this.array.get(i));                          // Releases all nodes except for head
       }
       (this.array.get(0)).next = NULL;                            // Makes sure head points nowhere because it has no next
       newArray.add(this.array.get(0));
       this.array = newArray;
       this.head = 0;
       this.tail = 0;
       this.numberEmpty = 0;
       this.firstEmpty = NULL;
       this.size = 0;  
       this.modCount ++;
 
       // check this assertion before each return statement
       assert size==0 && head==0 && numberEmpty==0 && firstEmpty==NULL
       && (array.size() == size+numberEmpty+1);
       return;
    }
 
    // Returns an Iterator of the elements in this list, 
    // starting at the front of the list
    // Target Complexity: O(1)
    Iterator<T> iterator(){
      return new ArrayLinkedListIterator(); 
    }
 
    // Convenience debugging method to display the internal 
    // values of the list, including ArrayList array
    protected void dump() {
      System.out.println();
      System.out.println("**** dump start ****");
      System.out.println("size:" + size);
      System.out.println("number empty:" + numberEmpty);
      System.out.println("first empty:"+firstEmpty);
      System.out.println("head:" + head);
      System.out.println("tail:" + tail); 
      System.out.println("list:");
      System.out.println("array:");
      for (int i=0; i<array.size(); i++) // show all elements of array
         System.out.println(i + ": " + array.get(i));
      System.out.println("**** dump end ****");
      System.out.println();
    }
 
    // Returns a textual representation of the list, i.e., the 
    // data values of the non-empty nodes in list order.
    public String toString(){
      String string_data = "";                    // Empty string to return
      Node<T> temp = this.array.get(this.head);   // Makes a temp node point to head
      if(temp.next != NULL){
        temp = this.array.get(temp.next);
      }
      else if(temp.next == NULL){
        return "";
      }
      while(temp.next != NULL){
        string_data += temp.data;
        temp = this.array.get(temp.next);
      }
      string_data += temp.data;
      return string_data;
    }
 
    // Compress the array by releasing all of the empty nodes to the 
    // node pool.  A new array is created in which the order of the 
    // Nodes in the new array matches the order of the elements in the 
    // list. When compress completes, there are no empty nodes. Resets 
    // tail accordingly.
    // Target Complexity: O(n)
    public void compress(){
      ArrayList<Node<T>> newArray = new ArrayList<Node<T>>();
      for(int i = 1; i < this.array.size(); i++){   // Loops through the array 
        Node<T> temp = this.array.get(i);           // Grabs each individual node
        if(temp.data == null){                      // If the data in that node is null then it is an empty node
          pool.release(temp);                       // Release the node into the pool 
        }
      }
      Node<T> temp_list = this.array.get(this.head);         // Temp node that tracks nodes
      while(temp_list.next != NULL){
         newArray.add(temp_list);                            // Adds the not to the array 
         temp_list = this.array.get(temp_list.next);         // Gets the next node
      } newArray.add(temp_list);
      
      for(int i = 0; i < newArray.size(); i++){
        if(i == newArray.size()-1){                          // Checking if it's the last node
          (newArray.get(i)).next = NULL;
          (newArray.get(i).previous) = newArray.size()-2;
        }
        else if(i == 0){
          newArray.get(0).previous = NULL;
          newArray.get(0).next = i + 1;
        }
        else{
          (newArray.get(i)).next = i + 1;
          (newArray.get(i)).previous = i - 1;
        }
      }
      this.tail = newArray.size()-1;
      this.firstEmpty = NULL;
      this.numberEmpty = 0;
      this.size = newArray.size()-1;
      this.array = newArray;
      this.modCount ++;
    }
      
 
    // Iterator for ArrayLinkedList. (See the description below.)
   private class ArrayLinkedListIterator implements Iterator<T> {
     protected Node<T> current;                 // Current node, return data on call to next()
     protected int expectedModCount = modCount; // How many modifications iterator expects
     
      // Constructor
      // Target Complexity: O(1)
     public ArrayLinkedListIterator(){
       this.current = ArrayLinkedList.this.array.get(ArrayLinkedList.this.head);
     }
      
      // Returns true if the iterator can be moved to the next() element.
     public boolean hasNext(){
       if( expectedModCount != ArrayLinkedList.this.modCount ){
        throw new ConcurrentModificationException();
       }
      // Checks if current is the last node in the list
      return !(this.current.next == NULL);
    }
     
 
      // Move the iterator forward and return the passed-over element
     public T next(){
       if(expectedModCount != ArrayLinkedList.this.modCount){
        throw new ConcurrentModificationException();
       }
       if(!hasNext()){                                                       // Checks if it has a next
        throw new RuntimeException(); 
       }
      T nextObject = ArrayLinkedList.this.array.get(this.current.next).data;// Saves the data of the current node 
      this.current = ArrayLinkedList.this.array.get(this.current.next);     // Updates current to the next node
      return nextObject;
     }
 
      // The following operation is part of the Iterator interface 
      // but is not supported by the iterator. 
      // Throws an UnsupportedOperationException if invoked.
      public void remove(){
         throw new UnsupportedOperationException();
      }
   }
}