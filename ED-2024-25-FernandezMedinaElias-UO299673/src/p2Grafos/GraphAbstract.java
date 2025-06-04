package p2Grafos;
/**
 * @author Nestor
 * @version 2024-25 Sesion 5
 */

import java.text.DecimalFormat;

public abstract class GraphAbstract<T> {
	protected T[] nodes; // Vector de nodos
	/**
	 * Matriz de aristas
	 */
	protected boolean[][] edges; // matriz de aristas
	/**
	 * Matriz de pesos
	 */
	protected double[][] weights; // matriz de pesos

	/**
	 * Numero de elementos en un momento dado
	 */
	protected int numNodes; // numero de elementos en un momento dado

	/**
	 * Matriz A de Floyd
	 */
	protected double aFloyd[][]; // Matriz A de Floyd
	/**
	 * Matriz P de Floyd
	 */
	protected int pFloyd[][]; // matriz P de Floyd
	/**
	 * matriz con arbol libre abarcador minimo de Prim
	 */

	/**
	 * 
	 * @param tam
	 *            Numero maximo de nodos del grafo
	 */
	@SuppressWarnings("unchecked")
	public GraphAbstract(int tam) {
		nodes = (T[]) new Object[tam];
		numNodes = 0;
		
	}

	public GraphAbstract(int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights){
		// Llama al constructor original
		this(tam); 
		// Crea tambien las matrices de aristas y pesos...
		edges = new boolean[tam][tam];
		weights = new double[tam][tam];
		this.aFloyd = new double[tam][tam];
		this.pFloyd = new int[tam][tam];

		// Pero modifica los atributos con los parametros para hacer pruebas...
		numNodes = initialNodes.length;
		
		for (int i=0;i<numNodes;i++) {
			nodes[i]=initialNodes[i];
			for (int j=0;j<numNodes;j++){
				edges[i][j]=initialEdges[i][j];
				weights[i][j]=initialWeights[i][j];
			}
		}
	
	}

	public GraphAbstract (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) {
		// Llama al constructor anterior de inicializacion
		this(tam, initialNodes, initialEdges, initialWeights); 
		// Pero modifica los atributos que almacenan las matrices de Floyd con los parametros para hacer pruebas...
		aFloyd = new double[tam][tam];
		pFloyd = new int[tam][tam];
		if (initialAfloyd!=null){
			this.aFloyd=initialAfloyd;
			this.pFloyd=initialPfloyd;
		}
		for(int i=0; i<numNodes; i++) {
			for(int j=0; j<numNodes; j++) {
				if(edges[i][j]) {
					this.aFloyd[i][j]=weights[i][j];
					this.pFloyd[i][j]=i;
				}else {
					this.aFloyd[i][j]=Double.POSITIVE_INFINITY;
					this.pFloyd[i][j]=-1;
				}
			}
			this.aFloyd[i][i]=0;
		}
	}

	/**
	 * Devuelve la matriz A de Floyd, con infinito si no hay camino
	 * Si no se ha invocado a Floyd debe devolver null (ojo que no lo invoca)
	 * 
	 * @return la matriz A de Floyd
	 */
	protected double[][] getAFloyd() {
		return aFloyd;
	}

	/**
	 * Devuelve la matriz P de Floyd, con -1 en las posiciones en las que no hay nodo intermedio
	 * Si no se ha invocado a Floyd debe devolver null (ojo que no lo invoca)
	 * 
	 * @return la matriz P de Floyd 
	 */
	protected int[][] getPFloyd() {
		return pFloyd;
	}

	/**
	 * @return Devuelve un String con la informacion del grafo (incluyendo matrices de Floyd)
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "NODES\n";
		for (int i = 0; i < numNodes; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nEDGES\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (edges[i][j])
					cadena += "T\t";
				else
					cadena += "F\t";
			}
			cadena += "\n";
		}
		cadena += "\nWEIGHTS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {

				cadena += (edges[i][j]?df.format(weights[i][j]):"-") + "\t";
			}
			cadena += "\n";
		}

		double[][] aFloyd = getAFloyd();
		if (aFloyd != null) {
			cadena += "\nAFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += df.format(aFloyd[i][j]) + "\t";
				}
				cadena += "\n";
			}
		}

		int[][] pFloyd = getPFloyd();
		if (pFloyd != null) {
				cadena += "\nPFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += (pFloyd[i][j]>=0?df.format(pFloyd[i][j]):"-") + "\t";
				}
				cadena += "\n";
			}
		}

		return cadena;
	}

}
