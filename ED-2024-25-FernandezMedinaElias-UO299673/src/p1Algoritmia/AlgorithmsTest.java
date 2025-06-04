package p1Algoritmia;

import static org.junit.jupiter.api.Assertions.*;
import java.math.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlgorithmsTest {
	private Algorithms al;
	@BeforeEach
	void setUp() {
		al = new Algorithms();
	}
	/**
	 * Tests del método factorial
	 */
	public void factorialTest() {
		assertEquals(3628800, al.factorial(10));
		assertEquals(24, al.factorial(4));
	}
	/**
	 * Tests del método fibonacci
	 */
	@Test
	public void fibonacciTest() {
		assertEquals(34, al.fibonacci(9));
		assertEquals(2, al.fibonacci(3));
		assertEquals(3, al.fibonacci(4));
		assertEquals(5, al.fibonacci(5));
		assertEquals(8, al.fibonacci(6));
	}
	/**
	 * Tests de la potencia de 2 con iteratividad
	 */
	@Test
	public void pow2Iter() {
		assertEquals(65536, al.pow2Iter(16));
		assertEquals(1, al.pow2Iter(0));
		assertEquals(2, al.pow2Iter(1));
		assertEquals(128, al.pow2Iter(7));
	}
	/**
	 * Test de la potencia de 2 con recursividad
	 */
	@Test
	public void pow2Rec1() {
		assertEquals(32, al.pow2Rec1(5));
		assertEquals(1, al.pow2Rec1(0));
		assertEquals(2, al.pow2Rec1(1));
		assertEquals(128, al.pow2Rec1(7));
	}
	/**
	 * Test de la potencia base a elevada a b
	 */
	@Test
	public void potenciaRecTest() {
		assertEquals(27, al.potenciaRec(3, 3));
		assertEquals(1, al.potenciaRec(3, 0));
		assertEquals(10000, al.potenciaRec(10, 4));
		assertEquals(1, al.potenciaRec(1, 20));
	}
	/**
	 * Test del resto de la division
	 */
	@Test
	public void restoDivRecTest() {
		assertEquals(1, al.restoDivRec(15, 2));
		assertEquals(0, al.restoDivRec(14, 2));
		assertEquals(4, al.restoDivRec(32, 7));
		assertEquals(0, al.restoDivRec(1, 1));
	}
	/**
	 * Test del cociente de la division
	 */
	@Test
	public void divEntRec() {
		assertEquals(2, al.divEntRec(18, 9));
		assertEquals(9, al.divEntRec(81, 9));
		assertEquals(2, al.divEntRec(13, 6));
		assertEquals(1, al.divEntRec(1, 1));
	}
	/**
	 * Test de invertir un número
	 */
	@Test
	public void invertirEnteroRec() {
		assertEquals(123, al.invertirEnteroRec(321));
		assertEquals(1, al.invertirEnteroRec(1));
		assertEquals(0, al.invertirEnteroRec(0));
		assertEquals(4567854, al.invertirEnteroRec(4587654));
		assertEquals(9, al.invertirEnteroRec(900));
	}
	/**
	 * Test de invertir un string
	 */
	@Test
	public void invertirStringRec() {
		assertEquals("Jose", al.invertirStringRec("esoJ"));
		assertEquals("", al.invertirStringRec(""));
		assertEquals("Jose y maria fueron al parque juntos", al.invertirStringRec("sotnuj euqrap la noreuf airam y esoJ"));
	}
	/**
	 * Test de pow2Rec2
	 */
	@Test
	public void pow2Rec2() {
		assertEquals(32, al.pow2Rec2(5));
		assertEquals(1, al.pow2Rec2(0));
		assertEquals(2, al.pow2Rec2(1));
		assertEquals(128, al.pow2Rec2(7));
	}
	/**
	 * Test de pow2Rec3
	 */
	@Test
	public void pow2Rec3() {
		assertEquals(32, al.pow2Rec3(5));
		assertEquals(1, al.pow2Rec3(0));
		assertEquals(2, al.pow2Rec3(1));
		assertEquals(128, al.pow2Rec3(7));
	}
	/**
	 * Test de pow2Rec4
	 */
	@Test
	public void pow2Rec4() {
		assertEquals(32, al.pow2Rec4(5));
		assertEquals(1, al.pow2Rec4(0));
		assertEquals(2, al.pow2Rec4(1));
		assertEquals(128, al.pow2Rec4(7));
	}
	


}
