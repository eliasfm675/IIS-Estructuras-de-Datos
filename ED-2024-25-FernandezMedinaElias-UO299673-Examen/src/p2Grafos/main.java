package p2Grafos;

public class main {
	public static void main(String[] args) {
		Graph g = new Graph(6);
//		g.addNode("a");
//		g.addNode("b");
//		g.addNode("c");
//		g.addNode("d");
//		g.addNode("e");
//		g.addNode("f");
//		g.addEdge("a", "b", 5);
//		g.removeEdge("a", "b");
//		g.addEdge("a", "e", 5);
//		g.addEdge("c", "d", 56);
//		g.removeNode("e");
//		g.addNode(8);
//		g.addNode(7);
//		g.addNode(3);
//		g.addNode(4);
//		g.addNode(5);
//		g.addNode(6);
//		g.addEdge(8, 8, 7);
//		g.addEdge(8, 4, 1);
//		g.addEdge(4, 7, 2);
//		g.addEdge(3, 8, 2);
//		g.addEdge(8, 7, 9);
//		g.addEdge(7, 3, 5);
//		g.addEdge(7, 7, 3);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 6, 1);
//		g.addEdge(3, 5, 76);
//		g.addEdge(4, 6, 1);
//		g.dijkstra(8);
//		System.out.println(g.dijkstra(8));
//		g.addNode("A");
//		g.addNode("B");
//		g.addNode("C");
//		g.addNode("D");
//		g.addNode("E");
//		g.addNode("F");
//		g.addNode("x");
//		g.addEdge("A", "B", 1);
//		g.addEdge("A", "D", 3);
//		g.addEdge("A", "E", 10);
//		g.addEdge("B", "C", 5);
//		g.addEdge("C", "E", 1);
//		g.addEdge("D", "C", 2);
//		g.addEdge("D", "E", 6);
//		System.out.println(g.toString());
//		System.out.println(g.minCostPath("D", "E"));
//		System.out.println(g.path("A","E"));
//		System.out.println(g.recorridoProfundidad("E"));
//		g.addEdge("A", "B", 2);
//		g.addEdge("A", "C", 8);
//		g.addEdge("B", "C", 3);
//		g.addEdge("B", "D", 6);
//		g.addEdge("C", "D", 1);
//		g.addEdge("D", "B", 2);
//		System.out.println(g.toString());
//		System.out.println(g.minCostPath("A", "B"));
//		System.out.println(g.path("D", "B"));
//		System.out.println(g.isAislatedNode("A"));
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.addNode(5);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(2, 5, 1);
		g.addEdge(5, 4, 1);
		g.addEdge(3, 4, 1);
		System.out.println(g.maxDijkstra(1));
		System.out.println(g.toString());
//		g.maxFloyd();
//		System.out.println(g.toString());
		System.out.println(g.path(1, 2));
		
	}
	
}
