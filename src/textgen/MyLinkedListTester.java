/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		//test if index of element is out of size of link list
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		try {
			list1.remove(3);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		assertEquals("Add: check C is added correctly ", "C", shortList.get(2));
		assertEquals("Add: check size is correct ", 3, shortList.size());
		
		emptyList.add(32);
		assertEquals("Add: check 32 is added correctly", (Integer)32, emptyList.get(0));
		
		for (int i = 10; i < 30; i++)
		{
			longerList.add(i);
		}
		
		assertEquals("Add: check element is added correctly", (Integer)25, longerList.get(25));
		assertEquals("Add: check size is correct", 30, longerList.size());	
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		assertEquals("Size: check if size of empty is correct ", 0, emptyList.size());
		assertEquals("Size: check if size of shorlist is correct ", 2, shortList.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// test if element is empty
		try {
			shortList.add(1, null);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		//test if index is upper of size of link list
		try {
			shortList.add(3, "s");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		//test if index is not between size of link list
		try {
			longerList.add(-1, 23);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		longerList.add(4, 18);
		assertEquals("Add: check element is added correctly", (Integer)18, longerList.get(4));
		assertEquals("Add: check if next element is displaced correctly", (Integer)4, longerList.get(5));
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		// test if element is empty
		try {
			shortList.set(1, null);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		//test if index is upper of size of link list
		try {			
			shortList.set(4, "s");
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		//test if index is not between size of link list
		try {
			longerList.set(-1, 16);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}		
		
		try {
			longerList.set(10, 16);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		try {
			emptyList.set(0, 12);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}		
		
		longerList.set(3,15);
		assertEquals("Add: check element is setted correctly", (Integer)15, longerList.get(3));
		assertEquals("Add: check if next element is correctly", (Integer)4, longerList.get(4));			
		
		int removed = list1.set(0, 50);
		assertSame("check set method",65, removed);
		assertSame("check set method",50,list1.get(0));
		
		try{
			longerList.set(1,null);
			fail("Check null");
		} catch (NullPointerException e) {
			
		}
		
		try{
			longerList.set(666,5);
			fail("Check index");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
