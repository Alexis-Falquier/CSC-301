package hw2;
import static org.junit.Assert.*;

import org.junit.Test;

public class HW2Test {
	
        
	/**
	 * A toy test function.  Tests that size behaves correctly on the empty
	 * tree and on a tree with only one node.  Use this only as a template
	 * for your more thorough tests.
	 */
	@Test
	public void testToyTest() {
		MyIntSET set = new MyIntSET();
		assertEquals(0,  set.size());
		set.put(42);
		assertEquals(1, set.size());
		assertEquals(0, set.height());
		set.put(10);
		set.put(82);
		set.put(18);
		set.put(43);
		assertEquals(2, set.height());
		assertEquals(1, set.sizeOdd());
		MyIntSET setCopy = new MyIntSET();
		setCopy.put(42);
		setCopy.put(10);
		setCopy.put(82);
		setCopy.put(18);
		setCopy.put(43);
		assertEquals(true, set.treeEquals(setCopy));
		assertEquals(2, set.sizeAtDepth(2));
		assertEquals(2, set.sizeAtDepth(1));
		assertEquals(1, set.sizeAtDepth(0));
		set.put(100);
		assertEquals(2, set.height());
		assertEquals(false, set.treeEquals(setCopy));
		assertEquals(3, set.sizeAtDepth(2));
		assertEquals(0, set.sizeAtDepth(3));
		assertEquals(0, set.sizeAtDepth(4));
		assertEquals(3, set.sizeAboveDepth(2));
		assertEquals(3, setCopy.sizeAboveDepth(2));
		assertEquals(6, set.sizeAboveDepth(3));
		assertEquals(5, setCopy.sizeAboveDepth(3));
		assertEquals(0, set.sizeAboveDepth(0));
		assertEquals(1, set.sizeAboveDepth(1));
		assertEquals(false, set.isPerfectlyBalancedS());
		assertEquals(false, setCopy.isPerfectlyBalancedS());
		set.put(5);
		assertEquals(true, set.isPerfectlyBalancedS());
		assertEquals(2, set.sizeOdd());
		set.put(1);
		assertEquals(3, set.height());
		assertEquals(3, set.sizeOdd());
		assertEquals(false, set.isPerfectlyBalancedS());
		assertEquals(false, set.treeEquals(setCopy));
		MyIntSET newSet = new MyIntSET();
		assertEquals(true, newSet.isPerfectlyBalancedS());
		assertEquals(-1, newSet.height());
		assertEquals(0, newSet.sizeOdd());
		newSet.put(1);
		assertEquals(true, newSet.isPerfectlyBalancedS());
		newSet.put(2);
		assertEquals(false, newSet.isPerfectlyBalancedS());
		assertEquals(1, newSet.sizeOdd());
		newSet.removeOddSubtrees();
		assertEquals(0, newSet.sizeOdd());
		assertEquals(0, newSet.size());
		assertEquals(-1, newSet.height());
		assertEquals(8, set.size());
		set.removeOddSubtrees();
		assertEquals(5, set.size());
		assertEquals(0, set.sizeOdd());
		assertEquals(5, setCopy.size());
		setCopy.put(100);
		assertEquals(false, set.treeEquals(setCopy));
		setCopy.removeOddSubtrees();
		assertEquals(true, set.treeEquals(setCopy));
		assertEquals(5, setCopy.size());
		assertEquals(0, setCopy.sizeOdd());
		newSet.put(4);
		newSet.put(7);
		newSet.put(6);
		newSet.put(8);
		assertEquals(4, newSet.size());
		assertEquals(1, newSet.sizeOdd());
		newSet.removeOddSubtrees();
		assertEquals(0, newSet.sizeOdd());
		assertEquals(1, newSet.size());
		assertEquals(0, newSet.height());
	}
	
	
	// Write some more test functions below.
	// Make sure to test all of the functions your wrote on various
	// trees of different shapes and sizes.

}
