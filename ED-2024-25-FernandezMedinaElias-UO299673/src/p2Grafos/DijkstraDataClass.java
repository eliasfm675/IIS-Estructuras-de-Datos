package p2Grafos;

import java.text.DecimalFormat;

/**
 * @author Nestor
 * @version 2024-25
 */
public class DijkstraDataClass {
	
	int nodeIndex;	// Nodo origen de Dijkstra
	double dDijkstra[];// Vector D de Dijkstra
	int pDijkstra[]; // Vector P de Dijkstra

	public DijkstraDataClass(int nNodes) {
		nodeIndex = -1;  // Nodo origen de Dijkstra
		dDijkstra = new double[nNodes]; // Vector D de Dijkstra
		pDijkstra = new int[nNodes]; // Vector P de Dijkstra
	}

	public DijkstraDataClass(int nNodes, int index) {
		nodeIndex = index;	// Nodo origen de Dijkstra
		dDijkstra = new double[nNodes]; // Vector D de Dijkstra
		pDijkstra = new int[nNodes]; // Vector P de Dijkstra
	}

	public DijkstraDataClass(int nNodes, int index, double[] d, int[] p) {
		this(nNodes, index);
		setdDijkstra(d);
		setpDijkstra(p);
	}

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public double[] getdDijkstra() {
		return dDijkstra;
	}

	public void setdDijkstra(double[] dDijkstra) {
		this.dDijkstra = dDijkstra;
	}

	public int[] getpDijkstra() {
		return pDijkstra;
	}

	public void setpDijkstra(int[] pDijkstra) {
		this.pDijkstra = pDijkstra;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		StringBuilder cadena = new StringBuilder();
		
		cadena.append("Starting node index:\t"+ nodeIndex);
		cadena.append("\nD-Vector:\t");
		for (int i = 0; i < dDijkstra.length; i++) {
			cadena.append(dDijkstra[i]==Double.POSITIVE_INFINITY ? "Inf\t": df.format(dDijkstra[i]) + "\t");
		}
		cadena.append("\nP-Vector:\t");
		for (int i = 0; i < pDijkstra.length; i++) {
			cadena.append(pDijkstra[i] + "\t");
		}
		cadena.append("\n");
	
		return cadena.toString();
	}
	
	public boolean equals (Object other) {
		if (other==null) return false;
		if (other instanceof DijkstraDataClass) {
			DijkstraDataClass otra = (DijkstraDataClass) other;
			for (int i=0; i<this.dDijkstra.length; i++) {
				if (dDijkstra[i]!=otra.getdDijkstra()[i] || pDijkstra[i]!=otra.getpDijkstra()[i]) 
					return false;
			}
			return nodeIndex==otra.getNodeIndex();
		}
		return false;
	}
}
