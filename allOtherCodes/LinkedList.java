/* LinkedList.java
 * Programmer: Tiancheng Fu
 * CruzID: 1600058
 * Assignment: Lab 6 - Practice with Linked Lists
 * Nov 21th 2017
 * Discription: This LinkedList.java file have a linkedList and push(), pop(), insert(), find() methods. Those method allows
 * adds a Node object with value to the end of the LinkedList, removes the first Node in the linked list and returns the data in the Node,
 * insert a Node object with value to a specific postion in the LinkedList, find the data in a Node at specific postion in the LinkedList
 * by the index.
 */
import java.util.*;//import stuffs
public class LinkedList{
  
  private Node head;//Declare a Node that points to the beginning of the linked list.
  private int size;//Declare the int variable use to count the size of the LinkedList

  
   public static void main(String[] args){//main class
   

 LinkedList fibNums = new LinkedList();//Declare a new LinkedList
 
 try{//Try catch block use to throw exception on NullPointer
 
 //Push new Node data into the LinkedList  
 fibNums.push(1);
 fibNums.push(1);
 fibNums.push(2);
 fibNums.push(3);
 fibNums.push(5);
 fibNums.push(8);
 fibNums.push(13);
 fibNums.push(21);
 fibNums.push(34);
 fibNums.push(55);
 fibNums.push(89);
 fibNums.push(144);
 // fibNums.insert(3,5,head);
 //System.out.println("Size:"+size);


 //Node current=head;//Declare a new Node object and set it to the head of the LinkedList
 
 /*while(current!=null){//Print out the variables in the LinkedList
       System.out.println(current.data); 
       current=current.next;  
      }*/
 
// This statement prints 13
System.out.println(fibNums.find(7, fibNums.head));
// This statement prints 1 and removes first item in list
System.out.println(fibNums.pop());
// This statement prints 1 and removes first item in list
System.out.println(fibNums.pop());
// This statement prints 2 and removes first item in list
System.out.println(fibNums.pop()); 
 }
 
 catch(NullPointerException e){//When there's a null data and bugged the program
   
 }
 
 }
  
  public void push(int data){//This method adds a Node object with value to the end of the LinkedList
    size++;//add one to the size of the LinkedList
    Node current=head;//Declare a new Node object current to keep track the elements in the LinkedList 
    
    if(head == null){//If there are no elements in the LinkedList then add the new Node right away
      head=new Node(data,null);//put the new Node in right away
    }
    
    else{
      while(current.next!=null){//While there is a elements in the LinkedList
        current=current.next;//set the current element to the next element
        
      }
      current.next=new Node(data,null);//put the new Node at the end of the LinkedList
    }
 
  }
  
  public Integer pop(){//This method removes the first Node in the linkedlist and returns the data in the Node
 
    int data=head.data;//Get the first Node's date in the LinkedList
    size--;//subtract one to the size
   if(head == null){//if the LinkedList don't have any element at all
     return null;
    }
   
     head = head.next;//set the head to the next element in the LinkedList
     return data;//return the data in the Node been pop
  }
  
  public int insert(int n, int d, Node a){//This method insert a Node object with value to a specific postion in the LinkedList
    
    Node temp = a.next;//Declare a new Node object to track on the Node element the method currently on as the method recall itself
    if(n == 2){//if the method at the right index in the Linkedlist, ==2 is because the LinkedList do not start with 0 index
      size++;//add one the the size
      Node dNode=new Node(d, null);//create a new Node into the LinkedList
      dNode.next=a.next;//Move the original Nodes in the LinkedList to one position after the original
      a.next=dNode;//Move the original Nodes in the LinkedList to one position after original
    }
    if(n < 2){//if the index is smaller than 2
      System.out.println("Error");
      
    }
    if (n > 2){//if the method isn't at the entered index yet
      return insert(n-1,d,temp);//recall the method with one less index
    }
    
    return temp.data;//return the data in the new inserted Node
    
  }
  public int find(int n, Node a){//This method find the data in a Node at a specific postion in the LinkedList
    Node temp = a.next;//Declare a new Node object to track on the Node element the method currently on as the method recall itself
    
    if(n == 0){//if the Node data still couldn't be find after the method go through the whole LinkedList
      return -1;
    }
    
    if (n > 1){//If there still are elements in the LinkedList that this method haven't go through
      return find(n-1,temp);//recall the method again with 1 less in the position index
    }
    
    return a.data;//return the data in the specific Node
    
  }
  
}

 /*class Node{//The Node class
  
 int data;
 Node next;
 Node(int d, Node n){
 data = d;
 next = n;
 
 }
}*/