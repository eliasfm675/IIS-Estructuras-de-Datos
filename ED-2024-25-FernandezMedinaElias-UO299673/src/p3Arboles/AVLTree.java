package p3Arboles;

public class AVLTree<T extends Comparable<T>> extends BSTree<T> {

    /**
     * Constructor de la clase AVLTree.
     * Inicializa un árbol AVL vacío.
     */
    public AVLTree() {
        super();
    }

    /**
     * Añade un nodo al árbol AVL.
     * Si el nodo ya existe o si es nulo, lanza una excepción o devuelve false.
     * Después de la inserción, asegura que el árbol mantenga sus propiedades de equilibrio.
     * @param node El valor que se quiere insertar.
     * @return true si se añadió correctamente, false si ya existía.
     */
    @Override
    public boolean addNode(T node) {
        if (node == null) {
            throw new NullPointerException("Element to insert is null.");
        }
        try {
            if (getRoot() == null) {
                AVLNode<T> newNode = new AVLNode<>(node);
                setRoot(newNode);
                return true;
            } else {
                setRoot(addRecursivo(node, getRoot()));  // Llamada recursiva para añadir el nodo y balancear
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * Inserta recursivamente un nodo en el árbol, actualizando la altura de cada nodo
     * y balanceando el árbol si es necesario.
     * @param info El valor a insertar.
     * @param root La raíz actual del subárbol donde se quiere insertar.
     * @return La nueva raíz del subárbol después de la inserción y el rebalanceo.
     */
    private AVLNode<T> addRecursivo(T info, AVLNode<T> root) {
        if (root == null) {
            return new AVLNode<>(info);  // Si el nodo es null, crea uno nuevo
        }

        // Inserción en el subárbol izquierdo o derecho según el valor comparado.
        if (info.compareTo(root.getInfo()) < 0) {
            root.setLeft(addRecursivo(info, root.getLeft()));  // Inserta en el subárbol izquierdo
        } else if (info.compareTo(root.getInfo()) > 0) {
            root.setRight(addRecursivo(info, root.getRight()));  // Inserta en el subárbol derecho
        } else {
            // Si el nodo ya existe, lanza una excepción para evitar duplicados.
            throw new IllegalArgumentException("Elemento ya existe en el árbol.");
        }

        // Actualiza la altura del nodo actual y lo balancea si es necesario.
        root.updateHeight();
        return updateAndBalanceIfNecesary(root);  // Asegura que el árbol esté balanceado
    }

    /**
     * Verifica y ajusta el equilibrio del nodo proporcionado y sus subárboles.
     * Realiza la rotación simple o doble correspondiente si el nodo está desequilibrado.
     * @param node El nodo a verificar y balancear.
     * @return La nueva raíz del subárbol balanceado.
     */
    private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> node) {
        node.updateHeight();  // Actualiza la altura del nodo actual
        int balance = node.getBF();  // Calcula el factor de equilibrio del nodo

        // Caso de desequilibrio a la derecha (balance > 1)
        if (balance > 1) {
            if (node.getRight() != null && node.getRight().getBF() < 0) {
                // Rotación doble a la izquierda
                return doubleRightRotation(node);
            }else if(node.getRight()!=null && node.getRight().getBF()==0) {
            	return singleRightRotation(node);  // Si el balance es 0, realiza una rotación simple a la derecha
            }
            // Rotación simple a la izquierda
            return singleLeftRotation(node);
        } 
        // Caso de desequilibrio a la izquierda (balance < -1)
        if (balance < -1) {
            if (node.getLeft() != null && node.getLeft().getBF() > 0) {
                // Rotación doble a la derecha
                return doubleLeftRotation(node);
            }else if(node.getLeft()!=null && node.getLeft().getBF()==0) {
            	return singleLeftRotation(node);  // Si el balance es 0, realiza una rotación simple a la izquierda
            }
            // Rotación simple a la derecha
            return singleRightRotation(node);
        }
        
        return node;  // Si no hay desequilibrio, no se realiza ninguna rotación
    }

    /**
     * Realiza una rotación simple a la izquierda.
     * Este método es usado para corregir un desequilibrio cuando el subárbol derecho es más alto.
     * @param node El nodo desequilibrado.
     * @return La nueva raíz del subárbol después de la rotación.
     */
    private AVLNode<T> singleLeftRotation(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getRight();  // El hijo derecho se convierte en la nueva raíz
        node.setRight(newRoot.getLeft());  // El subárbol izquierdo del hijo derecho se convierte en el subárbol derecho del nodo
        newRoot.setLeft(node);  // El nodo se convierte en el hijo izquierdo de la nueva raíz

        // Actualiza las alturas después de la rotación.
        node.updateHeight();
        newRoot.updateHeight();
        return newRoot;  // Retorna la nueva raíz del subárbol balanceado
    }

    /**
     * Realiza una rotación simple a la derecha.
     * Este método es usado para corregir un desequilibrio cuando el subárbol izquierdo es más alto.
     * @param node El nodo desequilibrado.
     * @return La nueva raíz del subárbol después de la rotación.
     */
    private AVLNode<T> singleRightRotation(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getLeft();  // El hijo izquierdo se convierte en la nueva raíz
        node.setLeft(newRoot.getRight());  // El subárbol derecho del hijo izquierdo se convierte en el subárbol izquierdo del nodo
        newRoot.setRight(node);  // El nodo se convierte en el hijo derecho de la nueva raíz

        // Actualiza las alturas después de la rotación.
        node.updateHeight();
        newRoot.updateHeight();
        return newRoot;  // Retorna la nueva raíz del subárbol balanceado
    }
    
    /**
     * Realiza una rotación doble a la izquierda.
     * Se compone de una rotación simple a la derecha seguida de una rotación simple a la izquierda.
     * @param node El nodo desequilibrado.
     * @return La nueva raíz del subárbol después de la rotación doble.
     */
    private AVLNode<T> doubleLeftRotation(AVLNode<T> node) {
        // Primero, rotación simple a la izquierda del hijo izquierdo
        node.setLeft(singleLeftRotation(node.getLeft()));
        // Luego, rotación simple a la derecha del nodo actual
        return singleRightRotation(node);
    }

    /**
     * Realiza una rotación doble a la derecha.
     * Se compone de una rotación simple a la izquierda seguida de una rotación simple a la derecha.
     * @param node El nodo desequilibrado.
     * @return La nueva raíz del subárbol después de la rotación doble.
     */
    private AVLNode<T> doubleRightRotation(AVLNode<T> node) {
        // Primero, rotación simple a la derecha del hijo derecho
        node.setRight(singleRightRotation(node.getRight()));
        // Luego, rotación simple a la izquierda del nodo actual
        return singleLeftRotation(node);
    }

    /**
     * Devuelve la raíz del árbol AVL como un nodo de tipo AVLNode.
     * Este método anula el método en la clase BSTree para asegurar que
     * el nodo raíz es tratado como un AVLNode.
     * @return La raíz del árbol AVL.
     */
    @Override
    public AVLNode<T> getRoot() {
        return (AVLNode<T>) super.getRoot();  // Retorna la raíz del árbol como un nodo AVLNode
    }

    /**
     * Se le pasa el objeto que se quiere borrar que coincida con equals
     * Si recibe un nodo nulo, lanza una NullPointerException
     * Devuelve true si lo ha borrado, false caso contrario
     */
    @Override
    public boolean removeNode(T x) {
    	if(x==null) {
    		throw new NullPointerException("Nodo recibido es null");
    	}
    	if(getRoot()==null) {
    		return false;  // No se puede borrar si el árbol está vacío
    	}
    	if(searchNode(x)!=null){
    		this.setRoot(removeNodeRecursivo(x, getRoot()));  // Llamada recursiva para eliminar el nodo
    		getRoot().updateHeight();  // Actualiza la altura de la raíz
    		updateAndBalanceIfNecesary(getRoot());  // Balancea el árbol si es necesario
    		return true;
    	}
    	return false;
    }

    /**
     * Elimina recursivamente un nodo en el árbol AVL.
     * @param x El valor del nodo a eliminar.
     * @param root La raíz del subárbol donde se realiza la eliminación.
     * @return El nuevo nodo raíz después de la eliminación.
     */
    private AbstractTreeNode<T> removeNodeRecursivo(T x, AVLNode<T> root) {
    	if(root==null) {
    		return null;
    	} 
    	root.updateHeight();
    	updateAndBalanceIfNecesary(root);  // Balancea después de cada eliminación
    	if(x.compareTo(root.getInfo())<0) {
    		root.setLeft(removeNodeRecursivo(x, root.getLeft()));  // Elimina del subárbol izquierdo
    	}else if(x.compareTo(root.getInfo())>0) {
    		root.setRight(removeNodeRecursivo(x, root.getRight()));  // Elimina del subárbol derecho
    	}else {
    		if(root.getLeft()==null && root.getRight()==null) {
    			return null;  // Nodo hoja, se elimina directamente
    		}
    		else if(root.getLeft()==null) {
    			return root.getRight();  // Nodo con solo hijo derecho
    		}
    		else if(root.getRight()==null) {
    			return root.getLeft();  // Nodo con solo hijo izquierdo
    		}else {
    			AVLNode<T> succesor = findMax(root.getLeft());  // Encuentra el sucesor
    			root.setInfo(succesor.getInfo());  // Sustituye el valor
    			root.setLeft(removeNodeRecursivo(succesor.getInfo(), root.getLeft()));  // Elimina el sucesor
    		}
    	}
    	return root;
    }

    /**
     * Encuentra el nodo con el valor máximo en un subárbol.
     * @param left El subárbol donde buscar el valor máximo.
     * @return El nodo con el valor máximo.
     */
    private AVLNode<T> findMax(AVLNode<T> left) {
    	AVLNode<T> max = left;
    	while(max.getRight()!=null) {
    		max = max.getRight();  // Sigue el enlace derecho hasta el nodo más grande
    	}
    	return max;
    }
}
