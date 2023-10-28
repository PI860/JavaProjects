package ALGO.pp.aufgabenblaetter.blatt02;

import java.util.Set;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JuTest_Aufg2_2_Palindroms {

	@Test
	public void testPalindroms0() {
		char[] chrs = { '1', '2', '3' };
		Set<String> sequences = Aufg2_2_Palindroms.palindroms(0, chrs);
		assertEquals(1, sequences.size());
		assertTrue(sequences.contains(""));
	}

	@Test
	public void testPalindroms1() {
		char[] chrs = { '1', '2', '3' };
		Set<String> sequences = Aufg2_2_Palindroms.palindroms(1, chrs);
		
		assertEquals(3, sequences.size());
		assertTrue(sequences.contains("1"));
		assertTrue(sequences.contains("2"));
		assertTrue(sequences.contains("3"));
	}

	@Test
	public void testPalindroms2() {
		char[] chrs = { '1', '2', '3' };
		Set<String> sequences = Aufg2_2_Palindroms.palindroms(2, chrs);
		
		assertEquals(3, sequences.size());
		assertTrue(sequences.contains("11"));
		assertTrue(sequences.contains("22"));
		assertTrue(sequences.contains("33"));
	}

	@Test
	public void testPalindroms3() {
		char[] chrs = { 'a', 'b', 'c' };
		Set<String> sequences = Aufg2_2_Palindroms.palindroms(3, chrs);
		assertEquals(9, sequences.size());
		
		assertTrue(sequences.contains("aaa"));
		assertTrue(sequences.contains("aba"));
		assertTrue(sequences.contains("aca"));
		assertTrue(sequences.contains("bab"));
		assertTrue(sequences.contains("bbb"));
		assertTrue(sequences.contains("bcb"));
		assertTrue(sequences.contains("cac"));
		assertTrue(sequences.contains("cbc"));
		assertTrue(sequences.contains("ccc"));
	}

	@Test
	public void testPalindroms4() {
		char[] chrs = { 'a', 'b', 'c' };
		Set<String> sequences = Aufg2_2_Palindroms.palindroms(4, chrs);
		
		assertEquals(9, sequences.size());
		assertTrue(sequences.contains("aaaa"));
		assertTrue(sequences.contains("abba"));
		assertTrue(sequences.contains("acca"));
		assertTrue(sequences.contains("baab"));
		assertTrue(sequences.contains("bbbb"));
		assertTrue(sequences.contains("bccb"));
		assertTrue(sequences.contains("caac"));
		assertTrue(sequences.contains("cbbc"));
		assertTrue(sequences.contains("cccc"));
	}
	
	@Test
	public void testPalindroms5() {
		char[] chrs = {'a'};
		Set<String> sequences = Aufg2_2_Palindroms.palindroms(5, chrs);
		
		assertEquals(1, sequences.size());
		assertTrue(sequences.contains("aaaaa"));

	}

}
