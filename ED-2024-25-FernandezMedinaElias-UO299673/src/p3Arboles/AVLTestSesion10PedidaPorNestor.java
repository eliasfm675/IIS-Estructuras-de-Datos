package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVLTestSesion10PedidaPorNestor {
	
	@Test
	void testCasoMenosDosCero() {
		AVLTree<Integer> t = new AVLTree<>();
		assertTrue(t.addNode(20));
		assertTrue(t.addNode(10));
		assertTrue(t.addNode(5));
		assertTrue(t.addNode(15));
		assertTrue(t.addNode(17));
		assertTrue(t.addNode(2));
		assertTrue(t.addNode(25));
		assertTrue(t.addNode(26));
		assertTrue(t.removeNode(26));
		System.out.println(t);
	}
	@Test
	void testCasoMenosDosCero1() {
		AVLTree<Integer> t = new AVLTree<>();
		assertTrue(t.addNode(20));
		assertTrue(t.addNode(10));
		assertTrue(t.addNode(5));
		assertTrue(t.addNode(15));
		assertTrue(t.addNode(17));
		assertTrue(t.addNode(2));
		assertTrue(t.addNode(25));
		assertTrue(t.addNode(26));
		assertTrue(t.removeNode(26));
		System.out.println(t);
	}

}
