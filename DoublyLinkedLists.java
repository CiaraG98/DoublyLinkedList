import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Ciara Gilsenan
 *  @version 01/10/18 17:35:49
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }
    /**
     * Computes the size of the DLL list
     * @return size 
     * 
     * Worst - Case asymptotic running time cost: Theta(n)
     * 
     * Justification: This function uses a while loop to run through the list and compute the size. 
     * 				  Because we know that the loop will reach the end of the list each time depending on the size n,
     * 				  it takes Theta(n) as a run time. 
     */
    public int listSize()
    {
    	int size = 0; 
    	if(head != null)
    	{
    		DLLNode current = head;
        	while(current != null) 
        	{
        		size++;
        		current = current.next;
        	}
        	return size;
    	}
    	else
    		return 0;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification: The function uses basic operations to check if the list is empty, therefore the run time is Theta(1). 
     * 				  Theta is used as we know it will just run once each time as there are no loops used.
     *  
     */
    public boolean isEmpty()
    {
      if(head == null) 
    	  return true;
      
      else 
    	  return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification: The function mainly uses basic operations that take Theta(1), however a for loop is used and since 
     * 				  it depends on an input n, the for loop takes O(n). Therefore the function has a run time of O(n).
     *  
     */
    public void insertBefore( int pos, T data ) 
    {
    	DLLNode newNode; 
    	if(isEmpty())
    	{
    		newNode = new DLLNode(data, null, null);
    		head = newNode;
    		tail = newNode;
    	}
    	else if(pos <= 0)
    	{
    		newNode = new DLLNode(data, null, head);
    		head.prev = newNode;
    		newNode.next = head;
    		head = newNode;
    	}
    	
    	else if(pos >= listSize())
    	{
    		newNode = new DLLNode(data, tail, null);
    		tail.next = newNode;
    		tail = newNode;
    	}
    	
    	else if(pos == listSize() - 1)
    	{
    		newNode = new DLLNode(data, tail.prev, tail);
    		tail.prev.next = newNode;
    	}
    	else if(pos > 0 && pos < listSize())
    	{
			DLLNode tmp = head;
    		for(int i = 0; i < listSize(); i++) 
    		{
    			if(i == pos)
    			{
    				newNode = new DLLNode(data, tmp.prev, tmp);
    				tmp.prev.next = newNode;    
    				tmp.prev = newNode;
    			}
    			else 
    				tmp = tmp.next;
    		}
    	}
    	
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification: The function uses a for loop that depends on an input n. The rest of the code has a run time of 
     * 				  Theta(1) or Theta(n) for the listSize() call.
     * 				  The for loop has a run time of O(n) so the function takes a worst case running time of O(n).
     */
    public T get(int pos) 
    {
    	DLLNode currentNode = head;
    	if(pos < 0 && isEmpty() || pos == 0 && isEmpty())
    		return null;
    			
    	if(pos == 0)
    		return head.data;
    	 
    	if(pos == listSize() - 1)
    		return tail.data;
    	
    	if(pos > 0 && pos < listSize())
    	{
    		for(int i = 0; i < listSize(); i++)
    		{
    			if(pos == i)
    			{
    				return currentNode.data;
    			}
    			else
    			{
    				currentNode = currentNode.next;
    			}
    		}
    	}
    	return null;
    	
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: O(n)
     *
     * Justification: The function contains basic commands that take Theta(1), it also contains calls of listSize() that take Theta(n).
     * 				  The for loop depends on an input n, therefore it takes the run time of O(n).
     * 				  For the worst case running time of the function, we use O(n).
     *  
     */
    public boolean deleteAt(int pos) 
    {
    	DLLNode currentNode = head;
    	int tailPos = listSize() - 1;  
    	if(pos < 0 && isEmpty() || pos == 0 && isEmpty())
    		return false;
    	
        if(pos == 0)
        {
      	  head = head.next;
      	  return true;
        }
        if(pos == tailPos)
        {
        	tail = tail.prev;
        	tail.next = null;
        	return true;
        }
        
        else 
        {
      	  for(int i = 0; i < listSize(); i++)
      	  {
      		  if(pos == i)
      		  {
      			  if(currentNode.next != null)
       				 currentNode.next.prev = currentNode.prev;

      			  if(currentNode.prev != null)
      				  currentNode.prev.next = currentNode.next;
      			  
      			  return true;
      		  }
      		  else
      			  currentNode = currentNode.next;
      			  
      	  }
        }
        return false;
    
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification: Other than the commands that take Theta(1). The function contains a while loop that we know goes to the end of the 
     * 				  list as needed to complete the function. This while loops takes Theta(n), therefore the the worst case running time 
     * 				  of the function is Theta(n).
     *  
     */
    public void reverse()
    {
    	if(head != null && tail != null)
    	{
    		DLLNode current = head;
        	DLLNode tmp = null;
        	while(current != null)
        	{
        		tmp = current.prev;
        		current.prev = current.next;
        		current.next = tmp;
        		current = current.prev;
        	}
        	if(tmp != null)
        		head = tmp.prev; 
    	}
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(n^2)
     *
     * Justification: The function contains a nested while loop that each take Theta(n) because we know that the loop goes to the end 
     * 				  of the list to check and make the list unique. Therefore the worst case running time would be Theta(n^2).
     *  
     */
     public void makeUnique()
    {
    	 if(isEmpty()) {}
    	 
    	 else
    	 {
 		 	DLLNode current = head;
 		 	DLLNode tmp = current.next;
 		 	boolean exitList = false;
	    	 boolean unique = false;
	    	 while(!unique)
	    	 {
	    		 while(tmp != null && !exitList)
	        	 {
	        		if(current.data == tmp.data)
	        		{
	        			if(tmp.next == null)
	        			{
	        				tail = tmp.prev;
	        				tail.next = null;
	        				exitList = true;
	        			}
	        			else
	        			{
	        				tmp.next.prev = tmp.prev;
	            			tmp.prev.next = tmp.next;
	            			tmp = tmp.next;
	        			}
	             		
	        		}
	        		else 
	        		{
	        			tmp = tmp.next;
	        			if(tmp == null)
	        				exitList = true;      			
	        		}
	        	 }
	    		 if(current.next != null)
	    		 {
	        		 current = current.next;
	        		 tmp = current.next;
	        		 exitList = false;
	    		 }
	    		 else
	    			 unique = true;
	    		 
	    	 }
	 
    	 }
    	
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification: The function contains basic commands, no loops are used therefore the worst case running time
     * 				  is Theta(1).
     *  
     */
    public void push(T item) 
    {
      DLLNode newNode = new DLLNode(item, null, head);
      head = newNode;
      if(tail == null)
      {
    	  tail = newNode; 
    	  tail.next = null;
      }
       
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification: The function contains basic commands and no loops therefore the worst case
     * 				  running time is Theta(1).
     *  
     */
    public T pop() 
    {
    	if(isEmpty())
    		return null;
    	else
    	{
    		T data = head.data;
        	head = head.next;
        	return data;
    	}
    }

    /*----------------------- QUEUE API 
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification: The function used basic commands to enqueue the list. Therefore the worst case running time is
     * 				  Theta(1).
     *  
     */
    public void enqueue(T item) 
    {
    	DLLNode n = new DLLNode(item, null, null);
    	if(isEmpty())
    	{
    		head = n;
    		tail = n;
    	}
    	else
    	{
    		tail.next = n;
    		n.prev = tail;
    		tail = n;
    	}
    	
    	
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an enqueue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification: The function contains basic commands that contain Theta(1). However the function also calls 
     * 				  listSize() which takes the worst case running time of Theta(n). Therefore the worst case running
     * 				  time of the function is Theta(n).
     *  
     */
    public T dequeue() 
    {
    	if(isEmpty() || listSize() == 0)
    		return null;
    	else
    	{ 
        	DLLNode n = head;
        	head = head.next;
        	return n.data;
    	}
    	
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; ;

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }
    
}


