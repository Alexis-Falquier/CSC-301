package hw1;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW1Test2 {
	String[] words = {
			"ant", "bee", "cat", "dog", "emu", "fox", "gem", "hat", "ice", "jar"
	};
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(1);
	
	// 5 points
	@Test (expected = IllegalArgumentException.class)
	public void test05GetNull() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("a",  1);
		st.get(null);
	}
	
	// 5 points
	@Test (expected = IllegalArgumentException.class)
	public void test05PutNull() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("a",  1);
		st.put(null, 5);
	}
	
	// 5 points
	@Test (expected = IllegalArgumentException.class)
	public void test05DeleteNull() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("a",  1);
		st.delete(null);
	}
	
	// 15 points
	@Test
	public void test15EmptySize() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		assertEquals(0, st.size());
	}
	
	// 10 points
	@Test
	public void test10Size() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i = 1; i < 9; i++) {
			st.put(words[i], i);
			assertEquals(i, st.size());
		}
		st.delete(words[5]);
		assertEquals(7, st.size());
		st.delete(words[1]);
		assertEquals(6, st.size());
		st.delete(words[8]);
		assertEquals(5, st.size());
		st.delete(words[5]);
		assertEquals(5, st.size());
	}
	
	// 10 points
	@Test
	public void test10PutGetNoDuplicates() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i = 1; i < 9; i++) {
			st.put(words[i], i);
			for (int j = 1; j <= i; j++)
				assertEquals(new Integer(j), st.get(words[j]));
		}
	}
	
	// 10 points
	@Test
	public void test10PutDuplicates() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 1; i < 5; i++) {
			st.put(words[i], i);
			assertEquals(i, st.size());
		}
		for(int i = 1; i < 5; i++)
			assertEquals(new Integer(i), st.get(words[i]));

		for(int i = 1; i < 5; i++) {
			st.put(words[i], i*10);
			assertEquals(4, st.size());
		}
		for(int i = 1; i < 5; i++)
			assertEquals(new Integer(i*10), st.get(words[i]));

		for(int i = 4; i >= 1; i--) {
			st.put(words[i], i*100);
			assertEquals(4, st.size());
		}
		
		for(int i = 4; i >= 1; i--)
			assertEquals(new Integer(i*100), st.get(words[i]));
	}
	
	// 10 points
	@Test
	public void test10MissingDeletes() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i < words.length; i++)
			st.put(words[i],  i);
		assertEquals(words.length, st.size());
		st.delete("a");
		assertEquals(words.length, st.size());
		st.delete("b");
		assertEquals(words.length, st.size());
		st.delete("e");
		assertEquals(words.length, st.size());
		st.delete("x");
		assertEquals(words.length, st.size());
		st.delete("z");
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
	}

	// 5 points
	@Test
	public void test05PutIncDelInc() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i < words.length; i++)
			st.put(words[i],  i);
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
		for(int i = words.length-1; i >= 0; i--)
			assertEquals(new Integer(i), st.get(words[i]));
		int counter = 0;
		for(String s : st.keys()) {
			assertEquals(words[counter], s);
			counter++;
		}
		assertEquals(words.length, st.size());
		for(int i = 0; i < words.length; i++) {
			st.delete(words[i]);
			counter = i+1;
			assertEquals(words.length-counter, st.size());
			for(String s : st.keys()) {
				assertEquals(words[counter], s);
				counter++;
			}
		}
	}

	// 5 points
	@Test
	public void test05PutIncDelDec() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i < words.length; i++)
			st.put(words[i],  i);
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
		for(int i = words.length-1; i >= 0; i--)
			assertEquals(new Integer(i), st.get(words[i]));
		int counter = 0;
		for(String s : st.keys()) {
			assertEquals(words[counter], s);
			counter++;
		}
		assertEquals(words.length, st.size());
		for(int i = words.length-1; i >= 0; i--) {
			st.delete(words[i]);
			counter = 0;
			assertEquals(i, st.size());
			for(String s : st.keys()) {
				assertEquals(words[counter], s);
				counter++;
			}
		}
	}
	
	// 5 points
	@Test
	public void test05PutDecDelInc() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = words.length-1; i >= 0; i--)
			st.put(words[i],  i);
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
		for(int i = words.length-1; i >= 0; i--)
			assertEquals(new Integer(i), st.get(words[i]));
		int counter = 0;
		for(String s : st.keys()) {
			assertEquals(words[counter], s);
			counter++;
		}
		assertEquals(words.length, st.size());
		for(int i = 0; i < words.length; i++) {
			st.delete(words[i]);
			counter = i+1;
			assertEquals(words.length - counter, st.size());
			for(String s : st.keys()) {
				assertEquals(words[counter], s);
				counter++;
			}
		}
	}

	// 5 points
	@Test
	public void test05PutDecDelDec() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = words.length-1; i >= 0; i--)
			st.put(words[i],  i);
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
		for(int i = words.length-1; i >= 0; i--)
			assertEquals(new Integer(i), st.get(words[i]));
		int counter = 0;
		for(String s : st.keys()) {
			assertEquals(words[counter], s);
			counter++;
		}
		assertEquals(words.length, st.size());
		for(int i = words.length-1; i >= 0; i--) {
			st.delete(words[i]);
			counter = 0;
			assertEquals(i, st.size());
			for(String s : st.keys()) {
				assertEquals(words[counter], s);
				counter++;
			}
		}
	}
	
	// 5 points
	@Test
	public void test05UpEvensDownOdds() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i < words.length; i+=2)
			st.put(words[i], i);
		for(int i = words.length % 2 == 0 ? words.length-1 : words.length-2; i >= 0; i-=2)
			st.put(words[i], i);
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
		for(int i = words.length-1; i >= 0; i--)
			assertEquals(new Integer(i), st.get(words[i]));
		int counter = 0;
		for(String s : st.keys()) {
			assertEquals(words[counter], s);
			counter++;
		}
		for(int i = words.length-1; i >= 0; i--) {
			st.delete(words[i]);
			counter = 0;
			for(String s : st.keys()) {
				assertEquals(words[counter], s);
				counter++;
			}
		}
	}
	
	// 5 points
	@Test
	public void test05DownEvensUpOdds() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = words.length % 2 == 1 ? words.length-1 : words.length-2; i >= 0; i-=2)
			st.put(words[i], i);
		for(int i = 1; i < words.length; i+=2)
			st.put(words[i], i);
		for(int i = 0; i < words.length; i++)
			assertEquals(new Integer(i), st.get(words[i]));
		for(int i = words.length-1; i >= 0; i--)
			assertEquals(new Integer(i), st.get(words[i]));
		int counter = 0;
		for(String s : st.keys()) {
			assertEquals(words[counter], s);
			counter++;
		}
		for(int i = words.length-1; i >= 0; i--) {
			st.delete(words[i]);
			counter = 0;
			for(String s : st.keys()) {
				assertEquals(words[counter], s);
				counter++;
			}
		}
	}

}
