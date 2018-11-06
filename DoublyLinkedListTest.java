import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Ciara Gilsenan
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3); 

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );
        testDLL.insertBefore(testDLL.listSize() - 1, 67);
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
        
     }

    // add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    /*
     * Checks if the listSize() functions returns correct result.
     */
    @Test
    public void testSize()
    {
    	DoublyLinkedList<Integer> newList = new DoublyLinkedList<Integer>();
    	newList.insertBefore(0, 2);
    	newList.insertBefore(1, 4);
    	newList.insertBefore(2, 6);
    	newList.insertBefore(3, 7);
    	int size = newList.listSize();
    	assertEquals(4, size);
    	
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	assertEquals(0, test.listSize());
    }
    
    /*
     * Checks if isEmpty outputs correct boolean value
     */
    @Test
    public void testIsEmpty() 
    {
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	test.insertBefore(0, 3);
    	boolean testEmpty = test.isEmpty();
    	assertFalse(testEmpty);
    	
    }
    
    /* 
     * Checks if get() returns the correct data and that outputs the right message/boolean value if there is a false input
     */
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	test.insertBefore(0, 1);
    	test.insertBefore(1, 4);
    	test.insertBefore(2, 6);
    	test.insertBefore(3, 7);
    	test.insertBefore(4, 8);
    	
    	//get tail
    	int tailData = test.get(test.listSize() - 1);
    	assertEquals(8, tailData);
    	
    	//test.get(-1);
    	assertEquals(null, test.get(-1));
  
    	//Empty list
    	DoublyLinkedList<Integer> testEmpty = new DoublyLinkedList<Integer>();
    	assertEquals(null, testEmpty.get(-1));
    	
    	int data = test.get(2);
    	assertEquals(6, data);
    	
    	DoublyLinkedList<String> list = new DoublyLinkedList<String>();
    	list.insertBefore(0, "Hello");
    	list.insertBefore(1, "Node");
    	list.insertBefore(2, "trinity");
    	
    	String data1 = list.get(1);
    	assertEquals("Node", data1);
    	
    	//test null return
    	String data2 = list.get(7);
    	assertEquals(null, data2);
    	
    	DoublyLinkedList<Integer> test1 = new DoublyLinkedList<Integer>();
    	test1.insertBefore(0, 1);
    	test1.insertBefore(1, 4);
    	
    	int data3 = test1.get(0);
    	assertEquals(1, data3);
    	
    	
    	
    	
    }
    
    /*
     * Checks if delete works. 
     */
    @Test
    public void testDelete()
    {
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	test.insertBefore(0, 1);
    	test.insertBefore(1, 4);
    	test.insertBefore(2, 6);
    	test.insertBefore(3, 7);
    	test.insertBefore(4, 8);
    	
    	assertEquals(true, test.deleteAt(1));
    	
    	//Removing head
    	assertEquals(true, test.deleteAt(0));
    	
    	//False input
    	assertEquals(false, test.deleteAt(5));
    	
    	
    	//Removing tail
    	assertEquals(true, test.deleteAt(test.listSize() - 1));
    	
    	//Empty list
    	DoublyLinkedList<Integer> testEmpty = new DoublyLinkedList<Integer>();
    	assertEquals(false, testEmpty.deleteAt(-1));
    	

    }
    
    /*
     * Checks reverse function
     */
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	test.insertBefore(0, 1);
    	test.insertBefore(1, 4);
    	test.insertBefore(2, 6);
    	test.insertBefore(3, 7);
    	test.insertBefore(4, 8);
    	test.reverse();
    	assertEquals("8,7,6,4,1", test.toString());	
    }
    
    /*
     * Checks makeUnique();
     */
    @Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	test.insertBefore(0, 2);
    	test.insertBefore(1, 4);
    	test.insertBefore(2, 6);
    	test.insertBefore(3, 7);
    	test.insertBefore(4, 4);
    	test.insertBefore(5, 8);
   
    	test.makeUnique(); 
    	assertEquals("2,4,6,7,8", test.toString());
    	
    	//tests that the negative number won't mistaken as a match
    	DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
    	list.insertBefore(0, 1);
    	list.insertBefore(1, 4);
    	list.insertBefore(2, 6);
    	list.insertBefore(3, 7);
    	list.insertBefore(4, -6);
    	list.insertBefore(5, 8);
    	
    	list.makeUnique();
    	assertEquals("1,4,6,7,-6,8", list.toString());
    	
    	//tests that the match that is the tail will be removed
    	DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
    	list1.insertBefore(0, 2);
    	list1.insertBefore(1, 4);
    	list1.insertBefore(2, 6);
    	list1.insertBefore(3, 7);
    	list1.insertBefore(4, 8);
    	list1.insertBefore(5, 7);
    	
    	list1.makeUnique();
    	assertEquals("2,4,6,7,8", list1.toString());
    	
    	//tests for more than just one duplicate
    	DoublyLinkedList<Integer> n = new DoublyLinkedList<Integer>();
    	n.insertBefore(0, 1);
    	n.insertBefore(1, 2);
    	n.insertBefore(2, 3);
    	n.insertBefore(3, 2);
    	n.insertBefore(5, 5);
    	n.insertBefore(6, 2);
    	n.insertBefore(7, 1);
    	n.insertBefore(8, 4);
    	n.insertBefore(9, 10);
    	n.insertBefore(10, 2);
    	n.insertBefore(11, 3);
    	
    	n.makeUnique();
    	assertEquals("1,2,3,5,4,10", n.toString());
    }
    
    /*
     * Checks push()
     */
    @Test
    public void testPush()
    {    
    	DoublyLinkedList<Integer> newList = new DoublyLinkedList<Integer>();
    	newList.insertBefore(0, 6);
    	newList.insertBefore(1, 8);
    	newList.insertBefore(2, 10);
    	newList.insertBefore(3, 3);
    	
    	newList.push(14);
    	assertEquals("14,6,8,10,3", newList.toString());
    	
    	DoublyLinkedList<Integer> n = new DoublyLinkedList<Integer>();
    	n.push(2);
    	
    	assertEquals("2", n.toString());

    }
    
    /*
     * Checks pop()
     */
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> newList = new DoublyLinkedList<Integer>();
    	newList.insertBefore(0, 6);
    	newList.insertBefore(1, 8);
    	newList.insertBefore(2, 10);
    	newList.insertBefore(3, 3);
    	
    	int data = newList.pop();
    	assertEquals(6, data);
    	
    	DoublyLinkedList<Integer> n = new DoublyLinkedList<Integer>();
    	n.insertBefore(0, 2);
    	n.insertBefore(1, 1);
    	
    	n.pop();
    	assertEquals("1", n.toString());
    	
    	n.pop();
    	assertEquals("", n.toString());
    	
    	DoublyLinkedList<Integer> a = new DoublyLinkedList<Integer>();

    	assertEquals(null, a.pop());
    	
    	
    }
    
    /*
     * Checks enqueue
     */
    @Test
    public void testEnqueue()
    {
    	DoublyLinkedList<Integer> newList = new DoublyLinkedList<Integer>();
    	newList.insertBefore(0, 6);
    	newList.insertBefore(1, 8);
    	newList.insertBefore(2, 10);
    	newList.insertBefore(3, 3);
    	
    	newList.enqueue(9);
    	assertEquals("6,8,10,3,9", newList.toString());
    	
    	DoublyLinkedList<Integer> n = new DoublyLinkedList<Integer>();
    	n.enqueue(5);
    	
    	assertEquals("5", n.toString()); 
    	

    }    
    /*
     * Checks dequeue
     */
    @Test
    public void testDequeue()
    {
    	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
    	test.insertBefore(0, 2);
    	test.insertBefore(1, 4);
    	test.insertBefore(2, 6);
    	test.insertBefore(3, 7);
    	test.insertBefore(4, 10);
    	
    	int data = test.dequeue();
    	assertEquals(2, data);
    	
    	DoublyLinkedList<Integer> n = new DoublyLinkedList<Integer>();
    	assertEquals(null, n.dequeue()); 
    	
    	n.insertBefore(0, 2);
    	assertEquals("2", n.toString());
    	
    	n.dequeue();
    	assertEquals("", n.toString());
    	assertEquals(0, n.listSize());

    }
}
