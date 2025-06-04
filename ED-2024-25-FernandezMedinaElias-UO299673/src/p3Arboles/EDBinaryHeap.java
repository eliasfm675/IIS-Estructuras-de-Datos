package p3Arboles;

/**
 * @author Profesores ED
 * @version 2024-25 distribuible
 */
 public class EDBinaryHeap<T extends Comparable<T>> implements EDPriorityQueue<T>{
	protected T [] elementos;
	protected int numElementos;

	@SuppressWarnings("unchecked")
	public EDBinaryHeap(int numMaxElementos) {
		elementos = (T[]) new Comparable[numMaxElementos];
	}

	@Override
	public boolean add(T info) {
		if(info==null || numElementos == elementos.length) {
			return false;
		}
		elementos[numElementos]=info;
		filtradoAscendente(numElementos);
		numElementos++;
		return true;
		
		
	}

	@Override
	public T poll() {
		if(numElementos==0) {
			return null;

		}
		T element = elementos[0];
		elementos[0] = elementos[numElementos-1];
		elementos[numElementos-1] = null;
		numElementos--;
		filtradoDescendente(0);	
		return element;
	}

	private T searchElement(T elem) {
		for(int i=0; i<numElementos; i++) {
			if(elementos[i].compareTo(elem)==0) {
				return elementos[i];
			}
		}
		return null;
	}
	@Override
	public boolean remove(T info) {
	    if (info == null || numElementos == 0 || searchElement(info)==null) {
	        return false;
	    }
	    for (int i = 0; i < numElementos; i++) {
	        if (elementos[i].compareTo(info) == 0) {
	            elementos[i] = elementos[numElementos - 1];  // Reemplaza el elemento con el último
	            elementos[numElementos - 1] = null;  // Elimina la referencia del último elemento
	            numElementos--;
	            filtradoDescendente(i);  // Filtrado descendente tras la eliminación
	            return true;
	        }
	    }
	    return false;  // El elemento no se encontró
	}

	@Override
	public boolean isEmpty() {
		return numElementos==0;
	}

	@Override
	public void clear() {
		for(int i=0; i<numElementos; i++) {
			elementos[i]=null;
		}
	}

	/**  
	 * Devuelve una cadena con la informacion de los elementos que contiene el  
	 * monticulo en forma visible (recomendado inorden-derecha-izquierda tabulado)  
	*/
	public String toString() {
	// Por ejemplo el arbol tumbado...  
		StringBuilder cadena = new StringBuilder();  
		cadena.append(inOrdenDerechaTabulado(0,0));  
		return cadena.toString();   
	}


    // el arbol que empieza en indice p tumbado con esp tabulaciones...
    private String inOrdenDerechaTabulado(int p,int esp) {
        String cadena="";
        if (p<numElementos) {
            int izq = Math.abs(2*p+1);
            int der = Math.abs(2*p+2);
            cadena+=inOrdenDerechaTabulado(der,esp+1);
            for(int i = 0;i<esp;i++)
                cadena+="\t";
            cadena += elementos[p]+"\n";
            cadena+=inOrdenDerechaTabulado(izq,esp+1);
        }
        return cadena;
    }

    /**
     * Realiza una filtrado ascendente de minimos en el monticulo
     * 
     * Se le pasa el indice del elemento a filtrar
     */

    protected void filtradoAscendente(int index) {
        while (index > 0 && elementos[index].compareTo(elementos[(index - 1) / 2]) < 0) {
            // Si el elemento es menor que su padre, intercámbialos
            T aux = elementos[(index - 1) / 2];
            elementos[(index - 1) / 2] = elementos[index];
            elementos[index] = aux;
            index = (index - 1) / 2;  // Subir al padre
        }
    }

    /**
     * Realiza una filtrado descendente de minimos en el monticulo
     * 
     * Se le pasa el indice del elemento a filtrar
     */

    protected void filtradoDescendente(int index) {
        int izq = 2 * index + 1;
        int der = 2 * index + 2;
        int min = index;

        // Verifica si el hijo izquierdo existe y es menor que el nodo actual
        if (izq < numElementos && elementos[izq].compareTo(elementos[min]) < 0) {
            min = izq;
        }

        // Verifica si el hijo derecho existe y es menor que el nodo actual
        if (der < numElementos && elementos[der].compareTo(elementos[min]) < 0) {
            min = der;
        }

        // Si el nodo actual no es el más pequeño, intercámbialo con el menor hijo
        if (min != index) {
            T aux = elementos[index];
            elementos[index] = elementos[min];
            elementos[min] = aux;
            filtradoDescendente(min);  // Recursivamente filtra el hijo al que se ha descendido
        }
    }

}
 
