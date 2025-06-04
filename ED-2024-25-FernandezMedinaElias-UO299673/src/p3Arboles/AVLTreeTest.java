package p3Arboles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;

//import org.junit.Test;

public class AVLTreeTest {
	
	
	/**
	 * Pruebas del método doubleLeftRotation
	 */
	@Test
	void doubleLeftRotation() {
		AVLTree<Integer> t = new  AVLTree<Integer>();
		assertTrue(t.addNode(30));
		assertTrue(t.addNode(20));
		assertTrue(t.addNode(25));
		assertTrue(t.addNode(28));
		assertTrue(t.addNode(29));
		assertTrue(t.addNode(72));
		System.out.println(t);
		
	}
	/**
	 * Pruebas del método doubleRightRotation
	 */
	@Test
	void doubleRightRotation() {
		AVLTree<Integer> t = new  AVLTree<Integer>();
		assertTrue(t.addNode(30));
		assertTrue(t.addNode(20));
		assertTrue(t.addNode(25));
		assertTrue(t.addNode(18));
		assertTrue(t.addNode(17));
		assertTrue(t.addNode(12));
		System.out.println(t);
		
	}
	/**
	 * Pruebas del método doubleRightRotation
	 */
	@Test
	void doubleRightRotation2() {
		AVLTree<Integer> t = new  AVLTree<Integer>();
		assertTrue(t.addNode(50));
		assertTrue(t.addNode(25));
		assertTrue(t.addNode(10));
		assertTrue(t.addNode(30));
		assertTrue(t.addNode(75));
		assertTrue(t.addNode(90));
		assertTrue(t.addNode(95));
		System.out.println(t);
		
	}
	@Test
	void doubleLeftRotation2() {
		AVLTree<Integer> t = new  AVLTree<Integer>();
		assertTrue(t.addNode(50));
		assertTrue(t.addNode(60));
		assertTrue(t.addNode(25));
		assertTrue(t.addNode(65));
		assertTrue(t.addNode(75));
		System.out.println(t);
		
	}
	@Test
	void removeNode() {
		AVLTree<Integer> t = new  AVLTree<Integer>();
		assertTrue(t.addNode(10));
		
		assertTrue(t.addNode(5));
		
		assertTrue(t.addNode(2));
		
		assertTrue(t.addNode(20));
		
		assertTrue(t.addNode(15));
		
		assertTrue(t.addNode(25));
		
		assertTrue(t.addNode(17));
		
		assertTrue(t.removeNode(25));
		assertTrue(t.removeNode(20));
		assertTrue(t.removeNode(2));
		assertTrue(t.removeNode(5));
		assertTrue(t.removeNode(17));
		assertTrue(t.removeNode(15));
		assertFalse(t.removeNode(98));
		assertFalse(t.removeNode(100));
		assertFalse(t.removeNode(123123));
		assertFalse(t.removeNode(1111));
		assertFalse(t.removeNode(11));
		try {
			t.removeNode(10);
		}catch(NullPointerException e) {
		}
		System.out.println(t);
		
	}
	@Test
	void removeNode2() {
		AVLTree<Integer> t = new  AVLTree<Integer>();
		assertTrue(t.addNode(50));
		
		assertTrue(t.addNode(25));
		
		assertTrue(t.addNode(75));
		
		assertTrue(t.addNode(60));
		
		assertTrue(t.addNode(65));
		
		assertFalse(t.removeNode(98));
		assertFalse(t.removeNode(100));
		assertFalse(t.removeNode(123123));
		assertFalse(t.removeNode(1111));
		assertFalse(t.removeNode(11));
		System.out.println(t);
		
	}
}
