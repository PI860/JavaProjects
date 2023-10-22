//package ALGO.gs.junit5CalcDemo.junit5;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class CalculatorTest {
//	private Calculator calc;
//
//	@BeforeEach public void setUp() {
//		calc = new Calculator();
//	}
//
//	@Test public void testAdd() {
//		calc.add(3);
//		calc.add(10);
//		assertEquals(13, calc.getValue());
//	}
//
//	@Test public void testMult() {
//		calc.add(3);
//		calc.mult(10);
//		assertEquals(30, calc.getValue());
//	}
//
//	@Test public void testDiv() {
//		calc.add(12);
//		calc.div(3);
//		assertEquals(4, calc.getValue());
//	}
//
//
//	@Test public void testDivZero() {
//		Exception exception = assertThrows(ArithmeticException.class, () -> {
//			calc.add(12);
//			calc.div(0);
//		 });
//
//
//	}
//
//
//	@Test
//	public void testReset() {
//		calc.add(3);
//		calc.reset();
//		assertEquals(0, calc.getValue());
//	}
//}
