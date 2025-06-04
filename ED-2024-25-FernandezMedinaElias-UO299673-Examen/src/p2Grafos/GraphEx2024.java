package p2Grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nestor
 * @version 2024-25 distribuible
 */
public class GraphEx2024<T> extends GraphAbstract<T> {

	/**
	 * 
	 * Se le pasa el numero maximo de nodos del grafo
	 */
	public GraphEx2024(int tam) {
		super(tam);
		edges = new boolean[tam][tam];
		weights = new double[tam][tam];
		aFloyd = new double[tam][tam];
		pFloyd = new int[tam][tam];
	}
	public GraphEx2024 (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights) {
		super(tam,initialNodes,initialEdges,initialWeights);
	}
	public GraphEx2024 (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) {
		// Llama al constructor anterior de inicializacion
		super(tam, initialNodes, initialEdges, initialWeights, initialAfloyd, initialPfloyd); 
	
		// Pero modifica los atributos que almacenan las matrices de Floyd con los parametros para hacer pruebas...
		if (initialAfloyd!=null){
			aFloyd=initialAfloyd;
			pFloyd=initialPfloyd;
		}
	}

	/**
	 * Obtiene el indice de un nodo en el vector de nodos
	 * Se le pasa el nodo y devuelve la posicion en el vector de nodos o -1 si no existe
	 */
	protected int getNode(T node) {
		// Completad el metodo...
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i]==node) {
				return i;
			}
			if(nodes[i]==null) {
				break;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * Inserta un nuevo nodo que se le pasa como parametro.
	 * Si ya existe, no lo inserta y devuelve false (implementado mas tarde). 
	 * Si recibe un nodo nulo, no lo inserta y lanza una NullPointerException
	 * Si no cabe, no lo inserta y lanza una FullStructureException.
	 * 
	 */
	public boolean addNode(T node) {
		// Completad el metodo...
		
// 		...		
		//throw new FullStructureException(node);
		if(node==null) {
			throw new NullPointerException("Element to insert is null.");
		}
		if(nodes[nodes.length-1]!=null) {
			throw new FullStructureException("Graph is full");
		}
		if(existsNode(node)) {
			return false;
		}
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i]==null) {
				nodes[i]=node;
				numNodes++;
				floyd();
				return true;
			}
			
		}
		return false;
	}

	/**
	 * Si existe, borra el nodo deseado del vector de nodos asi como las aristas en
	 * las que forma parte y duvuelve true. 
	 * Si el nodo no existe devuelve false.
	 * Si recibe un nodo nulo, lanza una NullPointerException
	 * 
	 */
	public boolean removeNode(T node) {
//		throw new NullPointerException("Element to remove is null.");
		// Completad el mï¿½todo...
		if(node==null) {
			throw new NullPointerException("Element to remove is null.");
		}
		int i = getNode(node);
		if(existsNode(node)) {
			for(int j=0; j<edges[0].length; j++) {
				edges[i][j]=edges[numNodes-1][j];
				edges[numNodes-1][j] = false;
				edges[j][i]=edges[j][numNodes-1];
				edges[j][numNodes-1] = false;
				weights[i][j]=weights[numNodes-1][j];
				weights[numNodes-1][j] = 0;
				weights[j][i]=weights[j][numNodes-1];
				weights[j][numNodes-1] = 0;
			}
			edges[i][i]=edges[numNodes-1][numNodes-1];
			weights[i][i]=weights[numNodes-1][numNodes-1];
			nodes[i] = nodes[numNodes-1];
			nodes[numNodes-1]=null;
			numNodes--;
			floyd();
			return true;
		}
		return false;
	}

	/**
	 * Si existe devuelve true
	 * Si no existe devuelve false
	 */
	public boolean existsNode(T node) {
		return getNode(node) == -1 ? false : true;
	}

	/**
	 * Comprueba si existe una arista entre dos nodos que se pasan como parametro
	 * 
	 * Devuelve true si existe la arista entre los dos nodos que se le pasan
	 * Devuelve false si no existe la arista o no existen ambos nodos
	 */
	public boolean existsEdge(T source, T target) {
		// Completad el metodo...
		return getEdge(source, target) == -1 ? false: true;
	}

	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen y
	 * otro destino. 
	 * Devuelve true si la inserta
	 * Devuelve falso si ya existe el arco (arista)
	 * Lanza una excepcion ElementNotPresentException si no existe el nodo origen o destino
	 * Lanza una IllegalArgumentException si el peso es invalido.
	 * 
	 */
	public boolean addEdge(T source, T target, double edgeWeight) {
		// Completad el metodo...
//		throw new ElementNotPresentException(
//				"Edge could not be loaded: source element " + source + " is not part of the graph.");
		
//		throw new ElementNotPresentException(
//				"Edge could not be loaded: target element " + target + " is not part of the graph.");
		
//		throw new IllegalArgumentException(
//				"Weight edge could not be less or equals to 0");
		int sourceNode = getNode(source);
		int targetNode = getNode(target);
		if(edgeWeight<=0) {
			throw new IllegalArgumentException("Weight edge could not be less or equals to 0");
		}
		if(sourceNode == -1) {
			throw new ElementNotPresentException("Edge could not be loaded: source element " + source + " is not part of the graph.");
		}
		if(targetNode == -1) {
			throw new ElementNotPresentException("Edge could not be loaded: source element " + target + " is not part of the graph.");
		}
		if(existsEdge(source, target)) {
			return false;
		}
		if(!edges[sourceNode][targetNode] && weights[sourceNode][targetNode]==0) {
			edges[sourceNode][targetNode]=true;
			weights[sourceNode][targetNode]=edgeWeight;
			floyd();
			return true;
		}
		return false;
	}

	/**
	 * Borra la arista del grafo que conecta dos nodos.
	 * Si la arista existe, se borra y devuelve true.
	 * Si los nodos source o target no existen, lanza una excepcion de tipo ElementNotPresentException
	 * Si tanto source como target existen, pero la arista a eliminar no, devuelve false.
	 * 
	 */
	public boolean removeEdge(T source, T target) {
		// Completad el metodo...
//		throw new ElementNotPresentException(
//				"Edge could not be removed: " + source + " is not present in the current graph.");

//		throw new ElementNotPresentException(
//				"Edge could not be removed: " + target + " is not present in the current graph.");
		int sourcePos = getNode(source);
		int targetPos = getNode(target);
		if(!existsNode(source)){
			throw new ElementNotPresentException("Edge could not be removed: " + source + " is not present in the current graph.");
		}
		if(!existsNode(target)){
			throw new ElementNotPresentException("Edge could not be removed: " + target + " is not present in the current graph.");
		}
		if(existsEdge(source, target)) {
			edges[sourcePos][targetPos]=false;
			weights[sourcePos][targetPos]=0;
			floyd();
			return true;
		}
		return false;
	}

	/**
	 * Devuelve el peso de la arista que conecta dos nodos.
	 * Si los nodos source o target no existen, lanza una excepcion de tipo ElementNotPresentException
	 * Si tanto source como target existen, pero la arista a eliminar no, devuelve -1
	 * 
	 */

	public double getEdge(T source, T target) {
		// Completad el metodo...
//		throw new ElementNotPresentException(
//		"Edge weight could not be obtained: " + source + " is not present in the current graph.");

//		throw new ElementNotPresentException(
//		"Edge weight could not be obtained: " + target + " is not present in the current graph.");
		int sourcePos = getNode(source);
		int targetPos = getNode(target);
		if(sourcePos ==-1) {
			throw new ElementNotPresentException("Edge weight could not be obtained: " + source + " is not present in the current graph.");
		}
		if(targetPos ==-1) {
			throw new ElementNotPresentException("Edge weight could not be obtained: " + target + " is not present in the current graph.");
		}
		for(int i=0; i<edges.length; i++) {
			for(int j=0; j<edges[0].length; j++) {
				if(edges[sourcePos][targetPos]) {
					return weights[sourcePos][targetPos];
				}
			}
		}
		return -1;
	}

	/**
	 * Aplica el algoritmo de Floyd al grafo actual
	 * Devuelve true si lo aplica y false en caso contrario (no hay nodos en el grafo) 
	 */
	public boolean floyd() {
		// Completad el metodo...
		if(numNodes==0) {
			return false;
		}
		for(int i=0; i<numNodes; i++) {
			for(int j=0; j<numNodes; j++) {
				if(edges[i][j]) {
					aFloyd[i][j]=weights[i][j];
				}else {
					aFloyd[i][j]=Double.POSITIVE_INFINITY;
					pFloyd[i][j]=-1;
				}
			}
			aFloyd[i][i]=0;
		}
		for(int k=0; k<numNodes; k++) {
			for(int i=0; i<numNodes; i++) {
				for(int j=0; j<numNodes; j++) {
					if(aFloyd[i][j]>aFloyd[i][k]+aFloyd[k][j]) {
						aFloyd[i][j]=aFloyd[i][k]+aFloyd[k][j];
						pFloyd[i][j]=k;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Lanza el recorrido en profundidad de un grafo desde un nodo determinado, No
	 * necesariamente recorre todos los nodos. Al recorrer cada nodo hace un
	 * tratamiento del mismo que consiste en un concatenar el toString del nodo y un
	 * tabulador detras
	 * 
	 */
	public String recorridoProfundidad(T nodo) {
		// Completad el metodo...
		boolean[] visited = new boolean[numNodes];
		return nodo + "\t" + dfPrint(nodo, visited);
	}

	private String dfPrint(T nodo, boolean[] visited) {
		int nodePos = getNode(nodo);
		visited[nodePos] = true;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<numNodes; i++) {
			if(!visited[i] && edges[nodePos][i]) {
				sb.append(nodes[i] +"\t");
				sb.append(dfPrint(nodes[i], visited));
			}
		}
	
		return sb.toString();
		
	}
	/**
	 * Indica el camino entre los nodos que se le pasan como parametros de esta
	 * forma: donde cada nodo (Origen, Destino, IntermedioN,...) se refiere al
	 * toString del nodo correspondiente
	 * Origen<tabulador>(coste0)<tabulador>Intermedio1<tabulador>(coste1)<tabulador>IntermedioN<tabulador>(costeN)<tabulador>Destino<tabulador>
	 * Si no hay camino: Origen<tabulador>(Infinity)<tabulador>Destino<tabulador>
	 * Si Origen y Destino coinciden: Origen<tabulador> 
	 * Si no existen los 2 nodos devuelve una cadena vacia
	 * 
	 */
	public String path(T origen, T destino) {
		// Completad el metodo
		int nodeOrigen = getNode(origen);
		int nodeDestino = getNode(destino);
		if(!existsNode(origen) || !existsNode(destino)) {
			return "";
		}
		if(origen.equals(destino)) {
			return origen + "\t";
		}
		int k = pFloyd[nodeOrigen][nodeDestino];
		if(aFloyd[nodeOrigen][nodeDestino]==0 || k<-1) {
			return origen+"\t"+"(Infinity)"+"\t"+destino+"\t";
		}
//		StringBuilder sb = new StringBuilder();
//		if(k>=0 && edges[nodeOrigen][nodeDestino]) {
//			sb.append(pFloyd[nodeOrigen][nodeDestino]+"\t"+"("+aFloyd[nodeOrigen][nodeDestino]+")"+"\t");
//			sb.append(path(origen, nodes[k]));
//		}else {
//			
//		}
		return origen + pathFloyd(nodeOrigen, nodeDestino) + "\t" + destino;
		}

	private String pathFloyd(int nodeOrigen, int nodeDestino) {
		int k = pFloyd[nodeOrigen][nodeDestino];
		if(k==-1) {
			return "\t" + "(" + aFloyd[nodeOrigen][nodeDestino] + ")" + "\t";
		}else {
			return pathFloyd(nodeOrigen, k) + "\t" +  nodes[k] +  pathFloyd(k, nodeDestino);
		}
	}
	/**
	 * Algoritmo de Dijkstra para encontrar el camino de coste minimo desde
	 * nodoOrigen hasta el resto de nodos
	 * Se le pasa el nodo origen como parametro
	 * Devuelve una DijkstraDataClass con los vectores D y P correspondientes si se aplica o null si no se puede aplicar
	 * 
	 */
	public DijkstraDataClass dijkstra(T nodoOrigen) {
		  int startIndex = getNode(nodoOrigen);
		    if (startIndex == -1) {
		        throw new ElementNotPresentException("Node " + nodoOrigen + " is not present in the graph.");
		    }

		    DijkstraDataClass dijkstraData = new DijkstraDataClass(numNodes, startIndex);
		    double[] vectorD = dijkstraData.getdDijkstra();
		    int[] vectorP = dijkstraData.getpDijkstra();
		    boolean[] visited = new boolean[numNodes];

		    // Inicialización manual de vectorD, vectorP y visited
		    for (int i = 0; i < numNodes; i++) {
		        vectorD[i] = Double.POSITIVE_INFINITY;  // Inicializamos todas las distancias a infinito
		        vectorP[i] = -1;  // Inicializamos el vector de predecesores a -1 (sin predecesor)
		        visited[i] = false;  // Inicializamos todos los nodos como no visitados
		    }
		    vectorD[startIndex] = 0;  // La distancia al nodo origen es 0

		    // Algoritmo de Dijkstra
		    for (int i = 0; i < numNodes; i++) {
		        int currentNode = minCost(vectorD, visited);
		        if (currentNode == -1) { // No quedan nodos accesibles
		        	break; 
		        }
		        

		        visited[currentNode] = true;

		        // Relajación de los vecinos
		        for (int neighbor = 0; neighbor < numNodes; neighbor++) {
		            if (edges[currentNode][neighbor] && !visited[neighbor]) {
		                double newDist = vectorD[currentNode] + weights[currentNode][neighbor];
		                if (newDist < vectorD[neighbor]) {
		                    vectorD[neighbor] = newDist;
		                    vectorP[neighbor] = currentNode;
		                }
		            }
		        }
		    }

		    return dijkstraData;
	}

	/**
	 * Busca el nodo con distancia minima en D al resto de nodos
	 * 
	 * Es una recomendacion pero no es imprescindible...
	 * 
	 * Se le pasa el vector d de dijkstra actual
	 * Un conjunto de visitados (conjunto S) como vector de booleanos 
	 * 	si se usa otro tipo de conjunto adaptarlo
	 * Se devuelve el indice del nodo buscado o -1 si el grafo es no conexo o no quedan
	 *         nodos sin visitar
	 */
	private int minCost(double[] vectorD, boolean[] visited) {
		// Completad el metodo...
	    int minNode = -1;
	    double minDist = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < vectorD.length; i++) {
	        if (!visited[i] && vectorD[i] < minDist) {
	            minDist = vectorD[i];
	            minNode = i;
	        }
	    }
	    
	    return minNode;
	}

	/**
	 * Devuelve el coste del camino de coste minimo entre origen y destino segun Floyd.
	 * Si los nodos source o target no existen, 
	 *        lanza una excepcion de tipo ElementNotPresentException
	 * Si no se ha aplicado Floyd, lo aplica. (OJO que este metodo SI lo invoca) 
	**/ 
	public double minCostPath(T origen, T destino) {
		// Implementad el metodo...
//		throw new ElementNotPresentException(
//		"Path could not be obtained: " + source + " is not present in the current graph.");

//		throw new ElementNotPresentException(
//		"Path could not be obtained: " + target + " is not present in the current graph.");
		if(!existsNode(destino)) {
			throw new ElementNotPresentException("Path could not be obtained: " + origen + " is not present in the current graph.");
		}
		if(!existsNode(destino)) {
			throw new ElementNotPresentException("Path could not be obtained: " + destino + " is not present in the current graph.");
		}
		int nodeOrigen = getNode(origen);
		int nodeDestino = getNode(destino);
		if(aFloyd==null) {
			floyd();
		}
		return aFloyd[nodeOrigen][nodeDestino];
	}


}
