package hw1;
import static org.junit.Assert.*;

import org.junit.Test;

public class HW1Test {
	
        
	/**
	 * A toy test function.  Tests that symbol table behaves as
	 * expected when a single key/value pair is inserted.
	 */
	@Test
//	public void testSinglePutGet() {
//		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
//		assertEquals(0,  st.size());
//		assertNull(st.get("apple"));
//		st.put("apple", 42);
//		assertEquals(1, st.size());
//		assertEquals(new Integer(42), st.get("apple"));
//		assertNull(st.get("a"));
//		assertNull(st.get("b"));
//		st.put("bee", 60);
//		st.put("door", 5);
//		st.put("car", 7);
//		assertEquals(new Integer(7), st.get("car"));
//		assertEquals(new Integer(5), st.get("door"));
//		assertEquals(new Integer(42), st.get("apple"));
//
//	}
	
	
	public void testComplete() {
		SequentialSearchST<Integer, String> st = new SequentialSearchST<Integer, String>();
		assertEquals(0,  st.size());
		assertNull(st.get(1));
		st.put(1,"a");
		st.put(1,"a");
		assertEquals(1, st.size());
		st.put(2,"b");
		st.put(4,"d");
		st.put(3,"c");
		st.put(5,"e");
		assertEquals(5, st.size());
		assertEquals(new String("c"), st.get(3));
		assertNull(st.get(6));
		st.delete(3);
		assertEquals(4, st.size());
		assertNull(st.get(3));
		st.delete(1);
		assertEquals(3, st.size());
		st.delete(5);
		assertEquals(2, st.size());
		st.delete(4);
		assertEquals(1, st.size());
		st.delete(2);
		assertEquals(0, st.size());
		st.put(10,"a");
		st.put(100,"b");
		st.put(45,"d");
		st.put(3,"c");
		st.put(6,"e");
		assertEquals(5, st.size());
		assertEquals(new String("a"), st.get(10));
		st.put(10,"b");
		st.put(100,"c");
		st.put(45,"rock");
		st.put(3,"flan");
		st.put(6,"flower");
		assertEquals(5, st.size());
		assertEquals(new String("b"), st.get(10));
		st.put(10,null);
		st.put(100,null);
		st.put(45,null);
		st.put(3,null);
		st.put(6,null);
		assertEquals(0, st.size());
		st.delete(1);
		assertEquals(0, st.size());
		st.put(10,"b");
		st.put(100,"c");
		st.put(45,"rock");
		st.put(3,"flan");
		st.put(6000,"flower");
		assertEquals(new String("flan"), st.get(3));
		assertEquals(new String("flower"), st.get(6000));
		assertEquals(new String("c"), st.get(100));
		assertNull(st.get(1));
		assertNull(st.get(7000));
		assertNull(st.get(101));
		st.delete(100);
		st.delete(3);
		st.delete(6000);
		assertEquals(2, st.size());
		st.delete(1);
		st.delete(505);
		assertEquals(2, st.size());
		assertEquals ("[10, 45]", st.keys().toString());
		st.put(10,"b");
		st.put(100,"c");
		st.put(45,"rock");
		st.put(3,"flan");
		st.put(6000,"flower");
		assertEquals(5, st.size());
		assertEquals ("[3, 10, 45, 100, 6000]", st.keys().toString());
	}
	
	//Write some more test functions below.  Make sure to test:
	// 1.  Putting at the beginning, end, and middle of the list.
	// 2.  Putting something that is already in the list
	// 3.  Size works correctly
	// 4.  Get works correctly for keys in beginning, middle and end.
	// 5.  Get works correctly for keys that are not in the list but
	//		would be located at beginning, middle, end of list.
	// 6.  Delete works correctly for keys in beginning, middle, and end.
	// 7.  Delete works correctly for keys that are not in the symbol table.
	// 8.  The iterator returns by keys() provides the keys in increasing order.

}
