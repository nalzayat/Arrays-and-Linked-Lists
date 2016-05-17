// CHANGELOG: 

/* To run them on the command line, make sure that the junit-310.jar
   is in the project directory.
 
   demo$ javac -cp .:junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .:junit-cs310.jar HW1Tests   # run tests
 
   On Windows replace : with ; (colon with semicolon)
   demo$ javac -cp .;junit-cs310.jar *.java     # compile everything
   demo$ java  -cp .;junit-cs310.jar HW1Tests   # run tests
*/

import org.junit.*;
import org.junit.Test; // fixes some compile problems with annotations
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class HW1Tests {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("HW1Tests");
  }
  
  // @Test(timeout=1000,expected=SomeException.class)

  public static void failFmt(String fmt, Object... args){
    fail(String.format(fmt,args));
  }

  static String printArray(Object[] array) {
  StringBuilder B = new StringBuilder();
  B.append("[ ");
  for(Object o: array)
   B.append(o + " ");
  B.append("]");
  return B.toString();
  }

// PoolTests

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void Node_construct1(){
  // Check construct Node
     Node<String> n1 = new Node<String>();
  
     if(! (n1.previous==-1 && n1.next == -1 && n1.data == null)){
       failFmt("Node constructor:\n"+
          "Expect: +n1.previous==-1+ n1.next==-1 n1.data== null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void Node_init1(){
  // Check init Node
     Node<String> n1 = new Node<String>();
     n1.next= 1; n1.previous=1; n1.data= new String("non-null");
     n1.init();
  
     if(! (n1.previous==-1 && n1.next == -1 && n1.data == null)){
       failFmt("init:\n"+
          "Expect: +n1.previous==-1+ n1.next==-1 n1.data== null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void Node_toString1(){
  // Check Node toString
     Node<String> n1 = new Node<String>();
     n1.next= 1; n1.previous=1; n1.data= new String("non-null");
     String actualString = n1.toString().replaceAll("\\s+","");
     String expectedString =  new String("[1,1,non-null]"); 
  
     if(! actualString.equals(expectedString)){
       failFmt("Node toString:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void NodePool_reset1(){
  // Check NodePool reset
     NodePool<String> pool = new NodePool<String>(8);
     Node<String> n1 = new Node<String>();
     n1.next= 1; n1.previous=1; n1.data= new String("non-null");
     n1 = pool.reset(n1);
  
     if(! (n1.previous==-1 && n1.next == -1 && n1.data == null)){
       failFmt("NodePool reset:\n"+
          "Expect: +n1.previous==-1+ n1.next==-1 n1.data== null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void NodePool_create1(){
  // Check NodePoll create
     NodePool<String> pool = new NodePool<String>(8);
     Node<String> n = pool.create();
  
     if(! (n.previous==-1 && n.next == -1 && n.data == null)){
       failFmt("NodePool create:\n"+
          "Expect: +n.previous==-1+ n.next==-1 n.data== null \n"+
          "Actual: "+"n.previous=="+n.previous+" n.next=="+n.next+" n.data=="+n.data+"\n"+"");
     }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ObjectPool_Exception1(){
  // Check maxSize < 1
     boolean failed = false;
     try {
       NodePool<String> pool = new NodePool<String>(0); // maxSize is < 1
     } catch (IllegalArgumentException  e) {
         failed = true;
     }
     if(!failed){
       failFmt("ObjectPool constructor:\n"+
          "Expect: IllegalArgumentException" + "\n" +
          "Actual: no IllegalArgumentException "+"\n" + "");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ObjectPool_allocate1(){
  // Check allocate Node from empty pool
     NodePool<String> pool = new NodePool<String>(8);
     int actualSize = pool.size();
     if(actualSize != 0){
       failFmt("allocate:\n"+
          "Expect: "+ 0 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
     Node<String> n = pool.allocate();
  
     if(! (n.previous==-1 && n.next == -1 && n.data == null)){
       failFmt("allocate:\n"+
          "Expect: +n.previous==-1+ n.next==-1 n.data== null \n"+
          "Actual: "+"n.previous=="+n.previous+" n.next=="+n.next+" n.data=="+n.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ObjectPool_release1(){
  // Check release Node
     NodePool<String> p = new NodePool<String>(8);
     int actualSize = p.size();
     if(actualSize != 0){
       failFmt("Pool release:\n"+
          "Expect: "+ 0 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
     Node<String> n1 = p.allocate();
  
     if(! (n1.previous==-1 && n1.next == -1 && n1.data == null)){
       failFmt("Pool release:\n"+
          "Expect: +n1.previous==-1+ n1.next==-1 n1.data== null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }

     n1.next= 1; n1.previous=1; n1.data= new String("non-null");
     p.release(n1);

     actualSize = p.size();
     if(actualSize != 1){
       failFmt("release:\n"+
          "Expect: "+ 1 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
 
     Stack<Node<String>> s = p.pool;
     actualSize = s.size();
     if(actualSize != 1){
       failFmt("Pool release:\n"+
          "Expect: "+ 1 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
     Node<String> n2 = s.pop();
     if(! (n2.previous==-1 && n2.next == -1 && n2.data == null)){
       failFmt("Pool release:\n"+
          "Expect: +n2.previous==-1+ n2.next==-1 n2.data== null \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ObjectPool_allocate2(){
  // Check allocate Node
     NodePool<String> p = new NodePool<String>(8);
     int actualSize = p.size();
     if(actualSize != 0){
       failFmt("allocate:\n"+
          "Expect: "+ 0 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
     Node<String> n1 = p.allocate();
  
     if(! (n1.previous==-1 && n1.next == -1 && n1.data == null)){
       failFmt("allocate:\n"+
          "Expect: +n1.previous==-1+ n1.next==-1 n1.data== null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }

     n1.next= 1; n1.previous=1; n1.data= new String("non-null");
     p.release(n1);

     actualSize = p.size();
     if(actualSize != 1){
       failFmt("allocate:\n"+
          "Expect: "+ 1 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
 
     Stack<Node<String>> s = p.pool;
     actualSize = s.size();
     if(actualSize != 1){
       failFmt("allocate:\n"+
          "Expect: "+ 1 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
     Node<String> n2 = s.pop();
     if(! (n2.previous==-1 && n2.next == -1 && n2.data == null)){
       failFmt("allocate:\n"+
          "Expect: +n2.previous==-1+ n2.next==-1 n2.data== null \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }

     Node<String> n3 = p.allocate();

     actualSize = p.size();
     if(actualSize != 0){
       failFmt("allocate:\n"+
          "Expect: "+ 0 + "\n" +
          "Actual: "+ actualSize +"\n" + "");
     }
  
     if(! (n3.previous==-1 && n3.next == -1 && n3.data == null)){
       failFmt("allocate:\n"+
          "Expect: +n3.previous==-1+ n3.next==-1 n3.data== null \n"+
          "Actual: "+"n3.previous=="+n3.previous+" n3.next=="+n3.next+" n3.data=="+n3.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ObjectPool_toString1(){
  // Check Pool toString
     NodePool<String> p = new NodePool<String>(8);
     Node<String> n1 = p.allocate();
     Node<String> n2 = p.allocate();
     p.release(n1);
     p.release(n2);
     String actualString = p.toString().replaceAll("\\s+","");
     String expectedString = "[-1,-1,null], [-1,-1,null]".replaceAll("\\s+","");
     if(! actualString.equals(expectedString)){
       failFmt("ObjectPool toString:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
     }
  }

// add(e)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_e_1(){
    // test add(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>();  
    if(L.firstEmpty != -1 || L.numberEmpty != 0 || L.head != 0
            || L.tail != 0 || L.size != 0){
       failFmt("ArrayLinkedList add:\n"+
          "Expect: firstEmpty=-1, numberEmpty=head=tail=size=0 \n"+
          "Actual: "+"firstEmpty="+L.firstEmpty+" numberEmpty="+L.numberEmpty+" head="+L.head
           + " tail=" + L.tail + " size=" + L.size +"\n"+"");
     }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_e_2(){
   // test ArrayLinkedList add(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList add(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList add(e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList add(e):\n"+
          "Expect: head.previous==-1, head.next==1, head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList add(e):\n"+
          "Expect: n1.previous==0+ n1.next==-1 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_e_3(){
   // test ArrayLinkedList add(e1);add(e2);
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList add(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList add(e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList add(e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 2 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList add(e):\n"+
          "Expect: n1.previous==0+ n1.next==2 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=1 || n2.next != -1 || !(n2.data.equals("two"))){
       failFmt("ArrayLinkedList add(e);add(e):\n"+
          "Expect: n2.previous==1+ n2.next==-1 n2.data == two \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_e_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.add(null);
     } catch (IllegalArgumentException   e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList add(null):\n"+
          "Expect: IllegalArgumentException" + "\n" +
          "Actual: no IllegalArgumentException "+"\n" + "");
     }
  }

// add(i,e)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_1(){
    // test add(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>();  
    if(L.firstEmpty != -1 || L.numberEmpty != 0 || L.head != 0
            || L.tail != 0 || L.size != 0){
       failFmt("ArrayLinkedList add:\n"+
          "Expect: firstEmpty=-1, numberEmpty=head=tail=size=0 \n"+
          "Actual: "+"firstEmpty="+L.firstEmpty+" numberEmpty="+L.numberEmpty+" head="+L.head
           + " tail=" + L.tail + " size=" + L.size +"\n"+"");
     }

  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_2(){
   // test ArrayLinkedList add(0,e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add(0,"one"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: n1.previous==0 n1.next==-1 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_3(){
   // test ArrayLinkedList add(0,e1);add(1,e2);
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add(0,"one"); 
    L.add(1,"two"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 2 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: n1.previous==0 n1.next==2 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=1 || n2.next != -1 || !(n2.data.equals("two"))){
       failFmt("ArrayLinkedList add(i,e);add(e):\n"+
          "Expect: n2.previous==1 n2.next==-1 n2.data == two \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_4(){
   // test ArrayLinkedList add(0,e1);add(1,e2);add(1,e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add(0,"one"); 
    L.add(1,"three"); 
    L.add(1,"two"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=4)
      failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: array.size() = 4 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 3 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: n1.previous==0 n1.next==3 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=3 || n2.next != -1 || !(n2.data.equals("three"))){
       failFmt("ArrayLinkedList add(i,e);add(i,e):\n"+
          "Expect: n2.previous==3 n2.next==-1 n2.data == three \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
     Node<String> n3 = array.get(3);
     if(n3.previous!=1 || n3.next !=2 || !(n3.data.equals("two"))){
       failFmt("ArrayLinkedList add(i,e);add(i,e)add(i,e):\n"+
          "Expect: n3.previous==1 n3.next==2 n3.data == two \n"+
          "Actual: "+"n3.previous=="+n3.previous+" n3.next=="+n3.next+" n3.data=="+n3.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_Exception1(){
  // Check add(i,null)
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.add(0,null);
     } catch (IllegalArgumentException   e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: IllegalArgumentException" + "\n" +
          "Actual: no IllegalArgumentException "+"\n" + "");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_Exception2(){
  // Check i out of range
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.add(-1,"one");
     } catch (IndexOutOfBoundsException   e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList add(-1,e):\n"+
          "Expect: IndexOutOfBoundsException " + "\n" +
          "Actual: no IndexOutOfBoundsException  "+"\n" + "");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_add_i_e_Exception3(){
  // Check i out of range
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.add(10,"one");
     } catch (IndexOutOfBoundsException   e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList add(i,e):\n"+
          "Expect: IndexOutOfBoundsException " + "\n" +
          "Actual: no IndexOutOfBoundsException  "+"\n" + "");
     }
  }

// addFirst

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Add_First1(){
   // test ArrayLinkedList addFirst(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.addFirst("one"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: n1.previous==0 n1.next==-1 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Add_First2(){
   // test ArrayLinkedList addFirst
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.addFirst("one"); 
    L.addFirst("two"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 2 || head.data != null)){
       failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: head.previous==-1 head.next==2 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=2 || n1.next != -1 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: n1.previous==2 n1.next==-1 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=0 || n2.next != 1 || !(n2.data.equals("two"))){
       failFmt("ArrayLinkedList addFirst(e):\n"+
          "Expect: n2.previous==0 n2.next==1 n2.data == two \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_AddFirst_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.addFirst(null);
     } catch (IllegalArgumentException    e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList addFirst(null):\n"+
          "Expect: IllegalArgumentException  " + "\n" +
          "Actual: no IllegalArgumentException   "+"\n" + "");
     }
  }

// addLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Add_Last1(){
   // test ArrayLinkedList addLast(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.addLast("one"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: n1.previous==0 n1.next==-1 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Add_Last2(){
   // test ArrayLinkedList addLast(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.addLast("one"); 
    L.addLast("two"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 2 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: n1.previous==0 n1.next==2 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=1 || n2.next != -1 || !(n2.data.equals("two"))){
       failFmt("ArrayLinkedList addLast(e):\n"+
          "Expect: n2.previous==1 n2.next==-1 n2.data == two \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_AddLast_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.addFirst(null);
     } catch (IllegalArgumentException    e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList addLast(null):\n"+
          "Expect: IllegalArgumentException  " + "\n" +
          "Actual: no IllegalArgumentException   "+"\n" + "");
     }
  }

// addAll

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_AddAll_1(){
   // test ArrayLinkedList addAll
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    ArrayList<String> A = new ArrayList<String>();
    A.add("one"); 
    A.add("two");
    L.addAll(A); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: head.previous==-1 head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 2 || !(n1.data.equals("one"))){
       failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: n1.previous==0 n1.next==2 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=1 || n2.next != -1 || !(n2.data.equals("two"))){
       failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: n2.previous==1 n2.next==-1 n2.data == two \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_AddAll_2(){
   // test ArrayLinkedList addAll
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    ArrayList<String> A = new ArrayList<String>();
    L.addAll(A); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=1)
      failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: array.size() = 1 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != -1 || head.data != null)){
       failFmt("ArrayLinkedList addAll(e):\n"+
          "Expect: head.previous==-1 head.next==-1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
  }

// indexOf

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_indexOf_Tests1(){
   // test ArrayLinkedList indexOf(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int index = L.indexOf("one");
    if (index!=0)
      failFmt("ArrayLinkedList indexOf:\n"+
          "Expect: indexOf one = 0 \n"+
          "Actual: " + "indexOf one = " + index + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_indexOf_Tests2(){
   // test ArrayLinkedList indexOf(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    int index = L.indexOf("two");
    if (index!=1)
      failFmt("ArrayLinkedList indexOf:\n"+
          "Expect: indexOf two = 1 \n"+
          "Actual: " + "indexOf two = " + index + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_indexOf_Tests3(){
   // test ArrayLinkedList indexOf(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int index = L.indexOf("two");
    if (index!=-1)
      failFmt("ArrayLinkedList indexOf:\n"+
          "Expect: indexOf two = -1 \n"+
          "Actual: " + "indexOf two  = " + index + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_IndexOF_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.indexOf(null);
     } catch (IllegalArgumentException e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList indexOf(null):\n"+
          "Expect: IllegalArgumentException  " + "\n" +
          "Actual: no IllegalArgumentException   "+"\n" + "");
     }
  }

// contains

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_contains_Tests1(){
   // test ArrayLinkedList contains(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean r = L.contains("one");
    if (!r==true)
      failFmt("ArrayLinkedList contains:\n"+
          "Expect: contains one = true \n"+
          "Actual: " + "contains one = " + r + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_contains_Tests2(){
   // test ArrayLinkedList contains(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    boolean r = L.contains("one");
    if (!r)
      failFmt("ArrayLinkedList contains:\n"+
          "Expect: contains two = true \n"+
          "Actual: " + "contains two = " + r + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_contains_Tests3(){
   // test ArrayLinkedList contains(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean r = L.contains("two");
    if (r)
      failFmt("ArrayLinkedList contains:\n"+
          "Expect: contains two = false \n"+
          "Actual: " + "contains two  = " + r + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_contains_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.contains(null);
     } catch (IllegalArgumentException e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList contains(null):\n"+
          "Expect: IllegalArgumentException  " + "\n" +
          "Actual: no IllegalArgumentException   "+"\n" + "");
     }
  }

//get

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_Tests1(){
   // test ArrayLinkedList get(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.get(0);
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList get:\n"+
          "Expect: get(0) = one \n"+
          "Actual: " + "get(0) = " + r + "\n");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_Tests2(){
   // test ArrayLinkedList get(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    String r = L.get(1);
    if (!r.equals("two"))
      failFmt("ArrayLinkedList get:\n"+
          "Expect: get(1) = two \n"+
          "Actual: " + "get(1) = " + r + "\n");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_Tests3(){
   // test ArrayLinkedList get(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean thrown = false;
    try {
      String r = L.get(1);
    }
    catch (IndexOutOfBoundsException e) {
      thrown = true;
    }
    if (!thrown)
      failFmt("ArrayLinkedList get:\n"+
          "Expect: IndexOutOfBoundsException.  \n"+
          "Actual: exception IndexOutOfBoundsException not thrown. \n");
  }

// getFirst

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_first_Tests1(){
   // test ArrayLinkedList getFirst()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.getFirst();
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList getFirst:\n"+
          "Expect: getFirst = one \n"+
          "Actual: " + "getFirst = " + r + "\n");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_first_Tests2(){
   // test ArrayLinkedList getFirst()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    boolean thrown = false;
    try {
      String r = L.getFirst();
    }
    catch (NoSuchElementException e) {
      thrown = true;
    }
    if (!thrown)
      failFmt("ArrayLinkedList getFirst:\n"+
          "Expect: NoSuchElementException.  \n"+
          "Actual: exception NoSuchElementException not thrown. \n");
  }

// getLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_last_Tests1(){
   // test ArrayLinkedList getLast()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    String r = L.getLast();
    if (!r.equals("two"))
      failFmt("ArrayLinkedList getLast:\n"+
          "Expect: getLast = two \n"+
          "Actual: " + "getLast = " + r + "\n");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_get_last_Tests2(){
   // test ArrayLinkedList getLast()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    boolean thrown = false;
    try {
      String r = L.getLast();
    }
    catch (NoSuchElementException e) {
      thrown = true;
    }
    if (!thrown)
      failFmt("ArrayLinkedList getLast:\n"+
          "Expect: NoSuchElementException.  \n"+
          "Actual: exception NoSuchElementException not thrown. \n");
  }

//positionOf

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_PositionOf_Tests1(){
   // test ArrayLinkedList PositionOf(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int index = L.positionOf("one");
    if (index!=1)
      failFmt("ArrayLinkedList positionOf:\n"+
          "Expect: positionOf one = 1 \n"+
          "Actual: " + "positionOf one = " + index + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_PositionOf_Tests2(){
   // test ArrayLinkedList PositionOf(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    int index = L.positionOf("two");
    if (index!=2)
      failFmt("ArrayLinkedList positionOf:\n"+
          "Expect: positionOf two = 2 \n"+
          "Actual: " + "positionOf two = " + index + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_PositionOf_Tests3(){
   // test ArrayLinkedList PositionOf(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int index = L.positionOf("two");
    if (index!=-1)
      failFmt("ArrayLinkedList positionOf:\n"+
          "Expect: positionOf two = -1 \n"+
          "Actual: " + "positionOf two  = " + index + "\n"+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_PositionOf_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.positionOf(null);
     } catch (IllegalArgumentException e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList positionOf(null):\n"+
          "Expect: IllegalArgumentException  " + "\n" +
          "Actual: no IllegalArgumentException   "+"\n" + "");
     }
  }

//remove(e)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_e_Tests1(){
   // test ArrayLinkedList Remove_e(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean r = L.remove("one");
    if (!r)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != -1 || head.data != null)){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: head.previous==-1+ head.next==-1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: n1.previous=-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=0 || L.numberEmpty != 1 || L.firstEmpty != 1 || L.head!=0 || L.tail != 0){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: L.size=0, L.numberEmpty = 1, L.firstEmpty = 1, L.head=0, L.tail = 0 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_e_Tests2(){
   // test ArrayLinkedList Remove_e(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean r = L.remove("one");
    L.add("two");
    if (!r)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || (!(n1.data.equals("two")))){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: n1.previous==0+ n1.next==-1 n1.data == two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=1 || L.numberEmpty != 0 || L.firstEmpty != -1 || L.head!=0 || L.tail != 1){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: L.size=1, L.numberEmpty = 0, L.firstEmpty = -1, L.head=0, L.tail = 1 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_e_Tests3(){
   // test ArrayLinkedList Remove_e(e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    L.remove("one");
    boolean r = L.remove("two");
    L.add("one");

    if (!r)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 2 || head.data != null)){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: head.previous==-1+ head.next==2 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: n1.previous==-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=0 || n2.next != -1 || !(n2.data.equals("one"))){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: n2.previous==0+ n1.next==-1 n2.data = one \n"+
          "Actual: "+"n2.previous=="+n1.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
     if(L.size!=1 || L.numberEmpty != 1 || L.firstEmpty != 1 || L.head!=0 || L.tail != 2){
       failFmt("ArrayLinkedList remove(e):\n"+
          "Expect: L.size=1, L.numberEmpty = 1, L.firstEmpty = 1, L.head=0, L.tail = 2 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_e_Exception1(){
  // Check e is null
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.remove(null);
     } catch (IllegalArgumentException e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList remove(null):\n"+
          "Expect: IllegalArgumentException  " + "\n" +
          "Actual: no IllegalArgumentException   "+"\n" + "");
     }
  }

// remove(i)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_i_Tests1(){
   // test ArrayLinkedList Remove(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.remove(0);
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: Remove one returns one \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList rmove(i):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != -1 || head.data != null)){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: head.previous==-1+ head.next==-1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: n1.previous==-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=0 || L.numberEmpty != 1 || L.firstEmpty != 1 || L.head!=0 || L.tail != 0){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: L.size=0, L.numberEmpty = 1, L.firstEmpty = 1, L.head=0, L.tail = 0 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_i_Tests2(){
   // test ArrayLinkedList Remove(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.remove(0);
    L.add("two");
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList remove(i,e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || (!(n1.data.equals("two")))){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: n1.previous==0+ n1.next==-1 n1.data == two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=1 || L.numberEmpty != 0 || L.firstEmpty != -1 || L.head!=0 || L.tail != 1){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: L.size=1, L.numberEmpty = 0, L.firstEmpty = -1, L.head=0, L.tail = 1 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Remove_i_Tests3(){
   // test ArrayLinkedList Remove(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    L.remove(0);
    String r = L.remove(0);
    L.add("one");

    if (!(r.equals("two")))
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 2 || head.data != null)){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: head.previous==-1+ head.next==2 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: n1.previous==-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=0 || n2.next != -1 || !(n2.data.equals("one"))){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: n2.previous==0+ n1.next==-1 n2.data = one \n"+
          "Actual: "+"n2.previous=="+n1.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
     if(L.size!=1 || L.numberEmpty != 1 || L.firstEmpty != 1 || L.head!=0 || L.tail != 2){
       failFmt("ArrayLinkedList remove(i):\n"+
          "Expect: L.size=1, L.numberEmpty = 1, L.firstEmpty = 1, L.head=0, L.tail = 2 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_remove_i_Exception1(){
   // test ArrayLinkedList remove(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean thrown = false;
    try {
      String r = L.remove(1);
    }
    catch (IndexOutOfBoundsException e) {
      thrown = true;
    }
    if (!thrown)
      failFmt("ArrayLinkedList remove:\n"+
          "Expect: IndexOutOfBoundsException.  \n"+
          "Actual: exception IndexOutOfBoundsException not thrown. \n");
  }

// removeFirst

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_RemoveFirst_Tests1(){
   // test ArrayLinkedList removeFirst()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.removeFirst();
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: Remove one returns one \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != -1 || head.data != null)){
       failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: head.previous==-1+ head.next==-1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: n1.previous=-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=0 || L.numberEmpty != 1 || L.firstEmpty != 1 || L.head!=0 || L.tail != 0){
       failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: L.size=0, L.numberEmpty = 1, L.firstEmpty = 1, L.head=0, L.tail = 0 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_RemoveFirst_Tests2(){
   // test ArrayLinkedList removeFirst()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.removeFirst();
    L.add("two");
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList remove(i,e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || (!(n1.data.equals("two")))){
       failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: n1.previous==0+ n1.next==-1 n1.data == two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=1 || L.numberEmpty != 0 || L.firstEmpty != -1 || L.head!=0 || L.tail != 1){
       failFmt("ArrayLinkedList removeFirst():\n"+
          "Expect: L.size=1, L.numberEmpty = 0, L.firstEmpty = -1, L.head=0, L.tail = 1 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_RemoveFirst_Exception1(){
  // Check empty list
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.removeFirst();
     } catch (NoSuchElementException    e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList removeFirst(e):\n"+
          "Expect: NoSuchElementException  " + "\n" +
          "Actual: no NoSuchElementException   "+"\n" + "");
     }
  }

// removeLast

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_RemoveLast_Tests_Tests1(){
   // test ArrayLinkedList removeLast()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.removeLast();
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: Remove one returns one \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeLast:\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != -1 || head.data != null)){
       failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: head.previous==-1+ head.next==-1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: n1.previous=-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=0 || L.numberEmpty != 1 || L.firstEmpty != 1 || L.head!=0 || L.tail != 0){
       failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: L.size=0, L.numberEmpty = 1, L.firstEmpty = 1, L.head=0, L.tail = 0 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_RemoveLast_Tests2(){
   // test ArrayLinkedList removeLast()
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    String r = L.removeLast();
    L.add("two");
    if (!(r.equals("one")))
      failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: Remove one returns true \n"+
          "Actual: " + "Remove one returns " + r + "\n"+"");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList remove(i,e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || (!(n1.data.equals("two")))){
       failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: n1.previous==0+ n1.next==-1 n1.data == two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.size!=1 || L.numberEmpty != 0 || L.firstEmpty != -1 || L.head!=0 || L.tail != 1){
       failFmt("ArrayLinkedList removeLast():\n"+
          "Expect: L.size=1, L.numberEmpty = 0, L.firstEmpty = -1, L.head=0, L.tail = 1 \n"+
          "Actual: "+"L.size="+L.size+" L.numberEmpty="+L.numberEmpty+" L.firstEmpty="+L.firstEmpty
             +"L.head="+L.head+" L.tail="+L.tail+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_RemoveLast_Exception1(){
  // Check empty list
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.removeLast();
     } catch (NoSuchElementException    e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList removeLast(e):\n"+
          "Expect: NoSuchElementException  " + "\n" +
          "Actual: no NoSuchElementException   "+"\n" + "");
     }
  }

// set(i,e)

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Set_i_e_Tests1(){
   // test ArrayLinkedList set(i,e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.set(0,"two");
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || !(n1.data.equals("two"))){
       failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: n1.previous==0+ n1.next==-1 n1.data == two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_set_i_e_Tests2(){
   // test ArrayLinkedList set(i,e)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.set(0,"two"); 
    L.set(1,"one"); 
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=3)
      failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: array.size() = 3 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: head.previous==-1+ head.next==1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 2 || !(n1.data.equals("two"))){
       failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: n1.previous==0 n1.next==2 n1.data == two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=1 || n2.next != -1 || !(n2.data.equals("one"))){
       failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: n2.previous==1 n2.next==-1 n2.data == one \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_set_i_e_Exception1(){
  // Check set(i,null)
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     L.add("one");
     boolean failed = false;
     try {
       L.set(0,null);
     } catch (IllegalArgumentException   e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList set(i,e):\n"+
          "Expect: IllegalArgumentException" + "\n" +
          "Actual: no IllegalArgumentException "+"\n" + "");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_set_i_e_Exception2(){
  // Check i out of range
     ArrayLinkedList<String> L = new ArrayLinkedList<String>();
     boolean failed = false;
     try {
       L.set(-1,"one");
     } catch (IndexOutOfBoundsException   e) {
         failed = true;
     }
     if(!failed){
       failFmt("ArrayLinkedList set(-1,e):\n"+
          "Expect: IndexOutOfBoundsException " + "\n" +
          "Actual: no IndexOutOfBoundsException  "+"\n" + "");
     }
  }

// simple methods

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_numEmpty_Tests1(){
   // test ArrayLinkedList numberEmpty
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int numberEmpty = L.numEmpty();
    if (numberEmpty != 0)
      failFmt("ArrayLinkedList numEmpty:\n"+
          "Expect: 0 \n"+
          "Actual: " +  numberEmpty +"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_numEmpty_Tests2(){
   // test ArrayLinkedList numEmpty
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.remove("one");
    int numberEmpty = L.numEmpty();
    if (numberEmpty != 1)
      failFmt("ArrayLinkedList numEmpty:\n"+
          "Expect: 1 \n"+
          "Actual: " +  numberEmpty +"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_getFirstEmpty_Tests1(){
   // test ArrayLinkedList getFirstEmpty
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int firstEmpty = L.getFirstEmpty();
    if (firstEmpty != -1)
      failFmt("ArrayLinkedList getFirstEmpty:\n"+
          "Expect: -1 \n"+
          "Actual: " +  firstEmpty +"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_getFirstEmpty_Tests2(){
   // test ArrayLinkedList getFirstEmpty
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.remove("one");
    int firstEmpty = L.getFirstEmpty();
    if (firstEmpty != 1)
      failFmt("ArrayLinkedList getFirstEmpty:\n"+
          "Expect: 1 \n"+
          "Actual: " +  firstEmpty +"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_getHead_Tests1(){
   // test ArrayLinkedList getHead
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int head = L.getHead();
    if (head != 0)
      failFmt("ArrayLinkedList getHead:\n"+
          "Expect: 0 \n"+
          "Actual: " +  head +"");
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_getTail_Tests1(){
   // test ArrayLinkedList getTail
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    int tail = L.getTail();
    if (tail != 0)
      failFmt("ArrayLinkedList getTail:\n"+
          "Expect: 0 \n"+
          "Actual: " +  tail +"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_getTail_Tests2(){
   // test ArrayLinkedList getTail
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    int tail = L.getTail();
    if (tail != 1)
      failFmt("ArrayLinkedList getTail:\n"+
          "Expect: 1 \n"+
          "Actual: " +  tail +"");
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_positionIsEmpty_Tests1(){
   // test ArrayLinkedList positionIsEmpty
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    boolean positionIsEmpty = L.positionIsEmpty(1);
    if (positionIsEmpty)
      failFmt("ArrayLinkedList positionIsEmpty:\n"+
          "Expect: false \n"+
          "Actual: " +  positionIsEmpty +"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_positionIsEmpty_Tests2(){
   // test ArrayLinkedList positionIsEmpty
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.remove("one");
    boolean positionIsEmpty = L.positionIsEmpty(1);
    if (!positionIsEmpty)
      failFmt("ArrayLinkedList positionIsEmpty:\n"+
          "Expect: true \n"+
          "Actual: " +  positionIsEmpty +"");
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_removeNode_Tests1(){
   // test ArrayLinkedList removeNode(i)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.removeNode(1);
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=2)
      failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: array.size() = 2 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != -1 || head.data != null)){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: head.previous==-1+ head.next==-1 head.data == null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=-1 || n1.next != -1 || n1.data != null){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n1.previous=-1+ n1.next==-1 n1.data == null \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     if(L.firstEmpty != 1){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: L.firstEmpty = 1 \n"+
          "Actual: "+"L.firstEmpty="+L.firstEmpty+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_removeNode_Tests2(){
   // test ArrayLinkedList removeNode(1)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    L.add("three");
    L.removeNode(2);
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=4)
      failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: array.size() = 4 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: head.previous=-1+ head.next=1 head.data=null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != 3 || n1.data != "one"){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n1.previous=0+ n1.next=3 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=-1 || n2.next != -1 || n2.data != null){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n2.previous=-1+ n2.next=-1 n2.data=null\n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
     Node<String> n3 = array.get(3);
     if(n3.previous!=1 || n3.next != -1 || n3.data != "three"){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n3.previous=1+ n3.next=-1 n3.data=three\n"+
          "Actual: "+"n2.previous=="+n3.previous+" n3.next=="+n3.next+" n3.data=="+n3.data+"\n"+"");
     }
     if(L.firstEmpty != 2){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: L.firstEmpty = 2 \n"+
          "Actual: "+"L.firstEmpty="+L.firstEmpty+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_removeNode_Tests3(){
   // test ArrayLinkedList removeNode(1)
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    L.add("three");
    L.removeNode(2);
    L.removeNode(3);
    ArrayList<Node<String>> array = L.array;
    if (array == null)
      failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: non-null array \n"+
          "Actual: " + "null array \n"+"");
    if (array.size()!=4)
      failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: array.size() = 4 \n"+
          "Actual: " + "array.size() = " + array.size() + "\n"+"");
     Node<String> head = array.get(0);
     if((head.previous !=-1 || head.next != 1 || head.data != null)){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: head.previous=-1+ head.next=1 head.data=null \n"+
          "Actual: "+"head.previous=="+head.previous+" head.next=="+head.next+" head.data=="+head.data+"\n"+"");
     }
     Node<String> n1 = array.get(1);
     if(n1.previous!=0 || n1.next != -1 || n1.data != "one"){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n1.previous=0+ n1.next=-1 n1.data == one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
     Node<String> n2 = array.get(2);
     if(n2.previous!=-1 || n2.next != -1 || n2.data != null){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n2.previous=-1+ n2.next=-1 n2.data=null\n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
     Node<String> n3 = array.get(3);
     if(n3.previous!=-1 || n3.next != 2 || n3.data != null){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: n3.previous=-1+ n3.next=2 n3.data=null\n"+
          "Actual: "+"n2.previous=="+n3.previous+" n3.next=="+n3.next+" n3.data=="+n3.data+"\n"+"");
     }
     if(L.firstEmpty != 3){
       failFmt("ArrayLinkedList removeNode(i):\n"+
          "Expect: L.firstEmpty = 3 \n"+
          "Actual: "+"L.firstEmpty="+L.firstEmpty+"\n"+"");
     }
  }

//toString

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_ToString_Tests1(){
   // test ArrayLinkedList ToString
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");  // expect one space between items
    String actualString = L.toString().replaceAll("\\s+",""); // "one two" becomes "onetwo"
    String expectedString =  new String("onetwo");
    if(! actualString.equals(expectedString)){
       failFmt("ArrayLinkedList toString:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_ToString_Tests2(){
   // test ArrayLinkedList ToString
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    String actualString = L.toString().replaceAll("\\s+",""); 
    String expectedString =  new String("");
    if(! actualString.equals(expectedString)){
       failFmt("ArrayLinkedList toString:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
    }
  }

// clear

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_clear_Tests1(){
   // test ArrayLinkedList clear
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.clear();
    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 0 || size != 0 || head_next != -1)
      failFmt("ArrayLinkedList clear:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 0, size = 0, head_next = -1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");

    int poolSize = L.pool.size();
    if (poolSize != 2)
      failFmt("ArrayLinkedList clear:\n"+
          "Expect: poolSize=2 \n" +
          "Actual: poolSize = " + poolSize+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_clear_Tests2(){
   // test ArrayLinkedList clear
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.remove("two");
    L.clear();
    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 0 || size != 0 || head_next != -1)
      failFmt("ArrayLinkedList clear:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 0, size = 0, head_next = -1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");
    int poolSize = L.pool.size();
    if (poolSize != 2)
      failFmt("ArrayLinkedList clear:\n"+
          "Expect: poolSize=2 \n" +
          "Actual: poolSize = " + poolSize+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_clear_Tests3(){
   // test ArrayLinkedList clear
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.add("three");
    L.remove("three");
    L.remove("two");
    L.clear();
    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 0 || size != 0 || head_next != -1)
      failFmt("ArrayLinkedList clear:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 0, size = 0, head_next = -1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");
    int poolSize = L.pool.size();
    if (poolSize != 3)
      failFmt("ArrayLinkedList clear:\n"+
          "Expect: poolSize=3 \n" +
          "Actual: poolSize = " + poolSize+"");
  }

// compress

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Compress_Tests1(){
   // test ArrayLinkedList compress
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.remove("one");
    L.remove("two");
    L.compress();

    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 0 || size != 0 || head_next != -1)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 0, size = 0, head_next = -1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");

    int poolSize = L.pool.size();
    if (poolSize != 2)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: poolSize=2 \n" +
          "Actual: poolSize = " + poolSize+"");
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Compress_Tests2(){
   // test ArrayLinkedList compress
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.remove("one");
    L.compress();

    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 1 || size != 1 || head_next != 1)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 1, size = 1, head_next = 1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");

    int poolSize = L.pool.size();
    if (poolSize != 1)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: poolSize=1 \n" +
          "Actual: poolSize = " + poolSize+"");

     Node<String> headNode = L.array.get(0);
     if((headNode.previous !=-1 || headNode.next != 1 || headNode.data != null)){
       failFmt("ArrayLinkedList compress():\n"+
          "Expect: headNode.previous=-1+ headNode.next=1 headNode.data == null \n"+
          "Actual: "+"headNode.previous=="+headNode.previous+" headNode.next=="+headNode.next+" headNode.data=="+headNode.data+"\n"+"");
     }
     Node<String> n1 = L.array.get(1);
     if(n1.previous!=0 || n1.next != -1 || n1.data != "two"){
       failFmt("ArrayLinkedList compress():\n"+
          "Expect: n1.previous=0+ n1.next=-1 n1.data = two \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Compress_Tests3(){
   // test ArrayLinkedList compress
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two"); 
    L.add("three");
    L.add("four");
    L.remove("four");
    L.remove("two");
    L.compress();

    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 2 || size != 2 || head_next != 1)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 2, size = 2, head_next = 1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");

    int poolSize = L.pool.size();
    if (poolSize != 2)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: poolSize=2 \n" +
          "Actual: poolSize = " + poolSize+"");

     Node<String> headNode = L.array.get(0);
     if((headNode.previous !=-1 || headNode.next != 1 || headNode.data != null)){
       failFmt("ArrayLinkedList compress():\n"+
          "Expect: headNode.previous=-1+ headNode.next=1 headNode.data == null \n"+
          "Actual: "+"headNode.previous=="+headNode.previous+" headNode.next=="+headNode.next+" headNode.data=="+headNode.data+"\n"+"");
     }
     Node<String> n1 = L.array.get(1);
     if(n1.previous!=0 || n1.next != 2 || n1.data != "one"){
       failFmt("ArrayLinkedList compress():\n"+
          "Expect: n1.previous=0+ n1.next=2 n1.data = one \n"+
          "Actual: "+"n1.previous=="+n1.previous+" n1.next=="+n1.next+" n1.data=="+n1.data+"\n"+"");
     }

     Node<String> n2 = L.array.get(2);
     if(n2.previous!=1 || n2.next != -1 || n2.data != "three"){
       failFmt("ArrayLinkedList compress():\n"+
          "Expect: n2.previous=1+ n2.next=-1 n2.data = three \n"+
          "Actual: "+"n2.previous=="+n2.previous+" n2.next=="+n2.next+" n2.data=="+n2.data+"\n"+"");
     }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_Compress_Tests4(){
   // test ArrayLinkedList compress
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    L.compress();

    int numberEmpty = L.numEmpty();
    int firstEmpty = L.getFirstEmpty();
    int head = L.getHead();
    int tail = L.getTail();
    int size = L.size();
    int head_next = L.array.get(0).next;
    if (numberEmpty != 0 || firstEmpty != -1 || head != 0 || tail != 2 || size != 2 || head_next != 1)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: numberEmpty = 0, firstEmpty = -1, head = 0, tail = 2, size = 2, head_next = 1 \n" +
          "Actual: numberEmpty = " + numberEmpty +", firstEmpty = " + firstEmpty + ", head = " + head 
              + ", tail = " + tail + ", size = " + size + ", head_next = " + head_next +"");

    int poolSize = L.pool.size();
    if (poolSize != 0)
      failFmt("ArrayLinkedList compress:\n"+
          "Expect: poolSize=0 \n" +
          "Actual: poolSize = " + poolSize+"");

  }

//iterator

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_IteratorTests1(){
   // test ArrayLinkedList iterator
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    Iterator i = L.iterator();
    if (i == null)
      failFmt("ArrayLinkedList iterator:\n"+
          "Expect: non-null i \n"+
          "Actual: " + "null i \n"+"");
  
    StringBuilder b = new StringBuilder();
    while (i.hasNext()) {
       b.append(i.next());
       b.append(" ");
    }
    String actualString = b.toString().replaceAll("\\s+",""); //"one " ==> "one"
    String expectedString = "one";

    if(! actualString.equals(expectedString)){
       failFmt("ArrayLinkedList iterator:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
    }
  }


  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_IteratorTests2(){
   // test ArrayLinkedList iterator
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    L.add("one"); 
    L.add("two");
    Iterator i = L.iterator();
    if (i == null)
      failFmt("ArrayLinkedList iterator:\n"+
          "Expect: non-null i \n"+
          "Actual: " + "null i \n"+"");
  
    StringBuilder b = new StringBuilder();
    while (i.hasNext()) {
       b.append(i.next());
       b.append(" ");
    }
    String actualString = b.toString().replaceAll("\\s+",""); //"one two" ==> "onetwo"
    String expectedString = "onetwo";

    if(! actualString.equals(expectedString)){
       failFmt("ArrayLinkedList iterator:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
    }
  }

  @SuppressWarnings("unchecked")
  @Test(timeout=1000) public void ArrayLinkedList_IteratorTests3(){
   // test ArrayLinkedList iterator
    ArrayLinkedList<String> L = new ArrayLinkedList<String>(); 
    Iterator i = L.iterator();
    if (i == null)
      failFmt("ArrayLinkedList iterator:\n"+
          "Expect: non-null i \n"+
          "Actual: " + "null i \n"+"");
  
    StringBuilder b = new StringBuilder();
    while (i.hasNext()) {
       b.append(i.next());
       b.append(" ");
    }
    String actualString = b.toString().replaceAll("\\s+",""); // "" ==> ""
    String expectedString = "";

    if(! actualString.equals(expectedString)){
       failFmt("ArrayLinkedList iterator:\n"+
          "Expect: "+expectedString + "\n"+
          "Actual: "+actualString+"\n"+"");
    }
  }


}
