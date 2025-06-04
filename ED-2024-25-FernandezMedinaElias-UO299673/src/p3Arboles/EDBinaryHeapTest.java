package p3Arboles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EDBinaryHeapTest {
	/**
	 * Pruebas del método add
	 */
	@Test
	public void addTest() {
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<>(10);
		assertTrue(bh.add(1));
		assertTrue(bh.add(2));
		assertTrue(bh.add(3));
		assertTrue(bh.add(4));
		assertTrue(bh.add(5));
		assertTrue(bh.add(6));
		assertTrue(bh.add(7));
		assertTrue(bh.add(8));
		assertTrue(bh.add(9));
		assertTrue(bh.add(10));
		assertFalse(bh.add(11));
		assertFalse(bh.add(12));
		assertFalse(bh.add(13));
		assertFalse(bh.add(14));
		assertFalse(bh.add(null));
		System.out.println(bh);
	}
	/**
	 * Pruebas del método poll
	 */
	@Test
	public void pollTest() {
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<>(10);
		int t;
		assertTrue(bh.add(2));
		assertTrue(bh.add(3));
		assertTrue(bh.add(7));
		assertTrue(bh.add(4));
		assertTrue(bh.add(5));
		assertTrue(bh.add(9));
		assertTrue(bh.add(8));
		t = bh.poll();
		assertEquals(2, t);
		t = bh.poll();
		assertEquals(3, t);
		t = bh.poll();
		assertEquals(4, t);
		t = bh.poll();
		assertEquals(5, t);
		t = bh.poll();
		assertEquals(7, t);
		t = bh.poll();
		assertEquals(8, t);
		t = bh.poll();
		assertEquals(9, t);
		System.out.println(bh);
		
	}
	/**
	 * Pruebas del método poll
	 */
	@Test
	public void removeTest() {
		EDBinaryHeap<Integer> bh = new EDBinaryHeap<>(10);
		int t;
		assertTrue(bh.add(2));
		assertTrue(bh.add(3));
		assertTrue(bh.add(7));
		assertTrue(bh.add(4));
		assertTrue(bh.add(5));
		assertTrue(bh.add(9));
		assertTrue(bh.add(8));
		assertTrue(bh.remove(2));
		assertTrue(bh.remove(3));
		assertTrue(bh.remove(7));
		assertTrue(bh.remove(4));
		assertTrue(bh.remove(5));
		assertTrue(bh.remove(9));
		assertTrue(bh.remove(8));
		System.out.println(bh);
		
	}
}
