/**
 * 
 */
package p2Grafos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author uo299673
 *
 */
class GraphTest {
	Graph g; //es un grafo de enteros
	int size;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		size=10;
		g = new Graph(size);
	}
	/**
	 * Clase de pruebas del método addNode()
	 */
	@Test
	void addNodeOkay() {
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addNode(6));
		assertTrue(g.addNode(7));
		
	}
	@Test
	void addNodeRepeated() {
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addNode(6));
		assertTrue(g.addNode(7));
		assertFalse(g.addNode(7));
		assertFalse(g.addNode(6));
		assertFalse(g.addNode(5));
		assertFalse(g.addNode(4));
		assertFalse(g.addNode(3));
		assertFalse(g.addNode(2));
	}
	/**
	 * Clase de pruebas del método addNode()
	 */
	@Test
	void addNodeNull() {
		try {
		g.addNode(null);
		}catch(NullPointerException e) {
			assertEquals("Element to insert is null.", e.getMessage());
		}
	}
	@Test
	void addNodeFull() {
		for(int i=0; i<size; i++) {
			assertTrue(g.addNode(i));
		}
		try {
			g.addNode(size);
		}catch(FullStructureException e) {
			assertEquals("Graph is full", e.getMessage());
		}
	}
	/**
	 * Clase de pruebas del método getNode()
	 */
	@Test
	void getNode() {
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertEquals(1, g.getNode(2));
		assertEquals(0, g.getNode(1));
		assertEquals(2, g.getNode(3));
		assertEquals(-1, g.getNode(86));
		
}
	/**
	 * Clase de pruebas del método existNode()
	 */
	@Test
	void existsNode() {
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.existsNode(1));
		assertTrue(g.existsNode(2));
		assertTrue(g.existsNode(3));
		assertFalse(g.existsNode(87878));
	}
	/**
	 * Clase de pruebas del método addEdge()
	 */
	@Test
	void addEdgeOkay() {
		assertTrue(g.addNode(0));
		assertTrue(g.addEdge(0, 0, 1));
	}
	@Test
	void addEdgeRepeated() {
		assertTrue(g.addNode(0));
		assertTrue(g.addEdge(0, 0, 25));
		assertFalse(g.addEdge(0, 0, 1));
	}
	
	@Test
	void addEdgeNotExistsSource() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			assertTrue(g.addEdge(0, 1, 5));
			g.addEdge(3, 2, 23);
		}catch(ElementNotPresentException e) {
			assertEquals("Edge could not be loaded: source element " + 3 + " is not part of the graph.", e.getMessage());
		}
	}
	@Test
	void addEdgeNotExistsTarget() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			assertTrue(g.addEdge(0, 1, 5));
			g.addEdge(1, 2, 23);
		}catch(ElementNotPresentException e) {
			assertEquals("Edge could not be loaded: source element " + 2 + " is not part of the graph.", e.getMessage());
		}
	}
	@Test
	void addEdgeWeightEqualsZero() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			g.addEdge(0, 1, 0);
		}catch(IllegalArgumentException e) {
			assertEquals("Weight edge could not be less or equals to 0", e.getMessage());
		}
	}
	@Test
	void addEdgeWeightLessThanZero() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			g.addEdge(0, 1, -7676);
		}catch(IllegalArgumentException e) {
			assertEquals("Weight edge could not be less or equals to 0", e.getMessage());
		}
	}
	/**
	 * Clase de pruebas del método getEdge()
	 */
	@Test
	void getEdge() {
		assertTrue(g.addNode(0));
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addEdge(0, 1, 25));
		assertTrue(g.addEdge(2, 2, 2));
		assertEquals(-1, g.getEdge(1, 2));
		assertEquals(25, g.getEdge(0, 1));
		assertEquals(-1, g.getEdge(0, 2));
		assertEquals(2, g.getEdge(2, 2));
		
	}
	@Test
	void getEdgeSourceException() {
		try {
			assertTrue(g.addNode(1));
			assertTrue(g.addNode(2));
			assertTrue(g.addNode(3));
			assertTrue(g.addEdge(1, 2, 3));
			g.getEdge(0,3);
		}catch(ElementNotPresentException e) {
			assertEquals("Edge weight could not be obtained: " + 0 + " is not present in the current graph.", e.getMessage());
		}
		
	}
	@Test
	void getEdgeTargetException() {
		try {
			assertTrue(g.addNode(1));
			assertTrue(g.addNode(2));
			assertTrue(g.addNode(3));
			assertTrue(g.addEdge(1, 2, 3));
			g.getEdge(1,4);
		}catch(ElementNotPresentException e) {
			assertEquals("Edge weight could not be obtained: " + 4 + " is not present in the current graph.", e.getMessage());
		}
		
	}
	/**
	 * Clase de pruebas del método existsEdge()
	 */
	@Test
	void existsEdge() {
		assertTrue(g.addNode(0));
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addEdge(0, 1, 25));
		assertTrue(g.addEdge(2, 2, 2));
		assertTrue(g.existsEdge(0, 1));
		assertTrue(g.existsEdge(2, 2));
		assertFalse(g.existsEdge(0, 3));
		
	}
	/**
	 * Clase de pruebas del método removeEdge()
	 */
	@Test
	void removeEdge() {
		assertTrue(g.addNode(0));
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addEdge(0, 1, 25));
		assertTrue(g.addEdge(2, 2, 2));
		assertTrue(g.removeEdge(0, 1));
		assertFalse(g.removeEdge(0, 3));
	}
	@Test
	void removeEdgeSourceException() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			assertTrue(g.addNode(2));
			assertTrue(g.addNode(3));
			assertTrue(g.addEdge(0, 1, 25));
			assertTrue(g.addEdge(2, 2, 2));
			g.removeEdge(4, 0);
		}catch(ElementNotPresentException e) {
			assertEquals("Edge could not be removed: " + 4 + " is not present in the current graph.", e.getMessage());
		}
	
	}
	@Test
	void removeEdgeTargetException() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			assertTrue(g.addNode(2));
			assertTrue(g.addNode(3));
			assertTrue(g.addEdge(0, 1, 25));
			assertTrue(g.addEdge(2, 2, 2));
			g.removeEdge(0, 5);
		}catch(ElementNotPresentException e) {
			assertEquals("Edge could not be removed: " + 5 + " is not present in the current graph.", e.getMessage());
		}
	
	}
	/**
	 * Clase de pruebas del método removeNode
	 */
	@Test
	void removeNodeOkay() {
		assertTrue(g.addNode(0));
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.removeNode(0));
		assertTrue(g.removeNode(1));
		assertTrue(g.removeNode(2));
		assertTrue(g.removeNode(3));
		assertFalse(g.removeNode(4));
		assertFalse(g.removeNode(67));
		
		
	}
	@Test
	void removeNodeNull() {
		try {
			assertTrue(g.addNode(0));
			assertTrue(g.addNode(1));
			assertTrue(g.addNode(2));
			assertTrue(g.addNode(3));
			g.removeNode(null);
		}catch(NullPointerException e) {
			assertEquals("Element to remove is null.",e.getMessage());
		}
	}
//	@Test
//	void removeNodeNestor() {
//		g.addNode(8);
//		g.addNode(7);
//		g.addNode(3);
//		g.addEdge(8, 8, 7);
//		g.addEdge(3, 8, 2);
//		g.addEdge(8, 7, 9);
//		g.addEdge(7, 3, 5);
//		g.addEdge(7, 7, 3);
//		g.removeNode(7);
//		assertEquals( 
//
//				"NODES\n8\t3\t\n\n" 
//
//				+"EDGES\nT\tF\t\nT\tF\t\n\n" 
//
//				+"WEIGHTS\n7\t-\t\n2\t-\t\n" 
//
//				,g.toString()); 
//	}
//	@Test
//	void floyd() {
//		
//		g.addNode(1);
//		g.addNode(2);
//		g.addNode(3);
//		g.addNode(4);
//		g.addNode(5);
//		g.addEdge(1, 2, 1);
//		g.addEdge(1, 4, 3);
//		g.addEdge(1, 5, 10);
//		g.addEdge(2, 3, 5);
//		g.addEdge(3, 5, 1);
//		g.addEdge(4, 3, 2);
//		g.addEdge(4, 5, 6);
//		assertEquals("NODES\r\n"
//			+ "1	2	3	4	5	\r\n"
//			+ "\r\n"
//				+ "EDGES\r\n"
//				+ "F	T	F	T	T	\r\n"
//				+ "F	F	T	F	F	\r\n"
//				+ "F	F	F	F	T	\r\n"
//				+ "F	F	T	F	T	\r\n"
//				+ "F	F	F	F	F	\r\n"
//				+ "\r\n"
//				+ "WEIGHTS\r\n"
//				+ "-	1	-	3	10	\r\n"
//				+ "-	-	5	-	-	\r\n"
//				+ "-	-	-	-	1	\r\n"
//				+ "-	-	2	-	6	\r\n"
//				+ "-	-	-	-	-	\r\n"
//			+ "\r\n"
//				+ "AFloyd\r\n"
//				+ "0	1	5	3	6	\r\n"
//			+ "∞	0	5	∞	6	\r\n"
//				+ "∞	?	0	∞	1	\r\n"
//				+ "∞	∞	2	0	3	\r\n"
//			+ "∞	∞	∞	∞	0	\r\n"
//				+ "\r\n"
//			+ "PFloyd\r\n"
//				+ "-	-	3	-	3	\r\n"
//				+ "-	-	-	-	2	\r\n"
//			+ "-	-	-	-	-	\r\n"
//				+ "-	-	-	-	2	\r\n"
//				+ "-	-	-	-	- ", g.toString());
//		
//	}
	@Test
	void pathFull() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addEdge(1, 2, 1));
		assertTrue(g.addEdge(1, 4, 3));
		assertTrue(g.addEdge(1, 5, 10));
		assertTrue(g.addEdge(2, 3, 5));
		assertTrue(g.addEdge(3, 5, 1));
		assertTrue(g.addEdge(4, 3, 2));
		assertTrue(g.addEdge(4, 5, 6));
		assertEquals("1	(3.0)		4	(2.0)		3	(1.0)		5", g.path(1, 5));
	}
	@Test
	void pathSameNode() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addEdge(1, 2, 1));
		assertTrue(g.addEdge(1, 4, 3));
		assertTrue(g.addEdge(1, 5, 10));
		assertTrue(g.addEdge(2, 3, 5));
		assertTrue(g.addEdge(3, 5, 1));
		assertTrue(g.addEdge(4, 3, 2));
		assertTrue(g.addEdge(4, 5, 6));
		assertEquals("1	", g.path(1, 1));
	}
	@Test
	void pathInfinite() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addEdge(1, 2, 1));
		assertTrue(g.addEdge(1, 4, 3));
		assertTrue(g.addEdge(1, 5, 10));
		assertTrue(g.addEdge(2, 3, 5));
		assertTrue(g.addEdge(3, 5, 1));
		assertTrue(g.addEdge(4, 3, 2));
		assertTrue(g.addEdge(4, 5, 6));
		assertEquals("5\t(Infinity)\t2\t", g.path(5, 2));
	}
	@Test
	void pathNodesDontExist() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addEdge(1, 2, 1));
		assertTrue(g.addEdge(1, 4, 3));
		assertTrue(g.addEdge(1, 5, 10));
		assertTrue(g.addEdge(2, 3, 5));
		assertTrue(g.addEdge(3, 5, 1));
		assertTrue(g.addEdge(4, 3, 2));
		assertTrue(g.addEdge(4, 5, 6));
		assertEquals("", g.path(8, 8));
	}
	@Test
	void recorridoProfundidad6() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addNode(6));
		assertTrue(g.addEdge(1, 3, 4));
		assertTrue(g.addEdge(1, 2, 3));
		assertTrue(g.addEdge(1, 5, 8));
		assertTrue(g.addEdge(2, 5, 5));
		assertTrue(g.addEdge(3, 5, 3));
		assertTrue(g.addEdge(5, 6, 3));
		assertTrue(g.addEdge(5, 4, 7));
		assertTrue(g.addEdge(6, 4, 2));
		assertEquals("6\t4\t", g.recorridoProfundidad(6));
		
	}
	@Test
	void recorridoProfundidadReves6() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(6));
		assertTrue(g.addNode(5));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(1));
		assertTrue(g.addEdge(1, 3, 4));
		assertTrue(g.addEdge(1, 2, 3));
		assertTrue(g.addEdge(1, 5, 8));
		assertTrue(g.addEdge(2, 5, 5));
		assertTrue(g.addEdge(3, 5, 3));
		assertTrue(g.addEdge(5, 6, 3));
		assertTrue(g.addEdge(5, 4, 7));
		assertTrue(g.addEdge(6, 4, 2));
		assertEquals("6\t4\t", g.recorridoProfundidad(6));
		
	}
	@Test
	void recorridoProfundidad() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(1));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(5));
		assertTrue(g.addNode(6));
		assertTrue(g.addEdge(1, 3, 4));
		assertTrue(g.addEdge(1, 2, 3));
		assertTrue(g.addEdge(1, 5, 8));
		assertTrue(g.addEdge(2, 5, 5));
		assertTrue(g.addEdge(3, 5, 3));
		assertTrue(g.addEdge(5, 6, 3));
		assertTrue(g.addEdge(5, 4, 7));
		assertTrue(g.addEdge(6, 4, 2));
		assertEquals("1\t2\t5\t4\t6\t3\t", g.recorridoProfundidad(1));
		
	}
	@Test
	void recorridoProfundidadReves() {
		Graph g = new Graph(10);
		assertTrue(g.addNode(6));
		assertTrue(g.addNode(5));
		assertTrue(g.addNode(4));
		assertTrue(g.addNode(3));
		assertTrue(g.addNode(2));
		assertTrue(g.addNode(1));
		assertTrue(g.addEdge(1, 3, 4));
		assertTrue(g.addEdge(1, 2, 3));
		assertTrue(g.addEdge(1, 5, 8));
		assertTrue(g.addEdge(2, 5, 5));
		assertTrue(g.addEdge(3, 5, 3));
		assertTrue(g.addEdge(5, 6, 3));
		assertTrue(g.addEdge(5, 4, 7));
		assertTrue(g.addEdge(6, 4, 2));
		assertEquals("1\t5\t6\t4\t3\t2\t", g.recorridoProfundidad(1));
		
	}


}
