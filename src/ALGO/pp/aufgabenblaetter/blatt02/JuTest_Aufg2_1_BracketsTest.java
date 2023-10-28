package ALGO.pp.aufgabenblaetter.blatt02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class JuTest_Aufg2_1_BracketsTest {

	@Test
	void testNestedBrackets_1() {
		Set<String> res1 = Aufg2_1_Brackets.nestedBrackets(1);
		assertEquals(1, res1.size());
		assertTrue(res1.contains("()"));
	}

	@Test
	void testNestedBrackets_2() {
		Set<String> res2 = Aufg2_1_Brackets.nestedBrackets(2);
		assertEquals(2, res2.size());
		assertTrue(res2.contains("(())"));
		assertTrue(res2.contains("()()"));
	}

	@Test
	void testNestedBrackets_3() {
		Set<String> res3 = Aufg2_1_Brackets.nestedBrackets(3);
		assertEquals(5, res3.size());
		assertTrue(res3.contains("((()))"));
		assertTrue(res3.contains("(()())"));
		assertTrue(res3.contains("(())()"));
		assertTrue(res3.contains("()(())"));
		assertTrue(res3.contains("()()()"));
	}

	@Test
	void testNestedBrackets_4() {
		Set<String> res4 = Aufg2_1_Brackets.nestedBrackets(4);
		assertEquals(14, res4.size());
		assertTrue(res4.contains("(((())))"));
		assertTrue(res4.contains("()((()))"));
		assertTrue(res4.contains("(())()()"));
	}
	
	@Test
	void testNestedBrackets_5() {
		Set<String> res5 = Aufg2_1_Brackets.nestedBrackets(5);
		assertEquals(42, res5.size());
		assertTrue(res5.contains("()(((())))"));
		assertTrue(res5.contains("(())((()))"));
		assertTrue(res5.contains("(())()(())"));
	}
	
	
}
