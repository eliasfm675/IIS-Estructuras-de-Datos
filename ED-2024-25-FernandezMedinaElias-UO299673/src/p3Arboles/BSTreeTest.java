/**
 * 
 */
package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author uo299673
 *
 */
class BSTreeTest {
	
	/**
	 * Pruebas método addNode
	 */
	@Test
	public void addNodeTest() {
		BSTree t = new BSTree<Integer>();
		assertTrue(t.addNode(1));
		assertTrue(t.addNode(2));
		assertTrue(t.addNode(3));
		assertTrue(t.addNode(4));
		assertTrue(t.addNode(5));
		assertTrue(t.addNode(6));
		
	}
	@Test
	public void addNodeNull() {
		try {
		BSTree t = new BSTree<Integer>();
		assertTrue(t.addNode(1));
		assertTrue(t.addNode(2));
		assertTrue(t.addNode(3));
		assertTrue(t.addNode(4));
		assertTrue(t.addNode(5));
		assertTrue(t.addNode(6));
		t.addNode(null);
		}catch(NullPointerException e) {
			assertEquals("El nodo a añadir es null", e.getMessage());
		}
		
	}
}
