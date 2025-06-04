package p3Arboles;

public class AVLTree<T extends Comparable<T>> extends BSTree<T> {

    /**
     * Constructor de la clase AVLTree.
     * Inicializa un �rbol AVL vac�o.
     */
    public AVLTree() {
        super();
    }

    /**
     * A�ade un nodo al �rbol AVL.
     * Si el nodo ya existe o si es nulo, lanza una excepci�n o devuelve false.
     * Despu�s de la inserci�n, asegura que el �rbol mantenga sus propiedades de equilibrio.
     * @param node El valor que se quiere insertar.
     * @return true si se a�adi� correctamente, false si ya exist�a.
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
                setRoot(addRecursivo(node, getRoot()));  // Llamada recursiva para a�adir el nodo y balancear
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * Inserta recursivamente un nodo en el �rbol, actualizando la altura de cada nodo
     * y balanceando el �rbol si es necesario.
     * @param info El valor a insertar.
     * @param root La ra�z actual del sub�rbol donde se quiere insertar.
     * @return La nueva ra�z del sub�rbol despu�s de la inserci�n y el rebalanceo.
     */
    private AVLNode<T> addRecursivo(T info, AVLNode<T> root) {
        if (root == null) {
            return new AVLNode<>(info);  // Si el nodo es null, crea uno nuevo
        }

        // Inserci�n en el sub�rbol izquierdo o derecho seg�n el valor comparado.
        if (info.compareTo(root.getInfo()) < 0) {
            root.setLeft(addRecursivo(info, root.getLeft()));  // Inserta en el sub�rbol izquierdo
        } else if (info.compareTo(root.getInfo()) > 0) {
            root.setRight(addRecursivo(info, root.getRight()));  // Inserta en el sub�rbol derecho
        } else {
            // Si el nodo ya existe, lanza una excepci�n para evitar duplicados.
            throw new IllegalArgumentException("Elemento ya existe en el �rbol.");
        }

        // Actualiza la altura del nodo actual y lo balancea si es necesario.
        root.updateHeight();
        return updateAndBalanceIfNecesary(root);  // Asegura que el �rbol est� balanceado
    }

    /**
     * Verifica y ajusta el equilibrio del nodo proporcionado y sus sub�rboles.
     * Realiza la rotaci�n simple o doble correspondiente si el nodo est� desequilibrado.
     * @param node El nodo a verificar y balancear.
     * @return La nueva ra�z del sub�rbol balanceado.
     */
    private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> node) {
        node.updateHeight();  // Actualiza la altura del nodo actual
        int balance = node.getBF();  // Calcula el factor de equilibrio del nodo

        // Caso de desequilibrio a la derecha (balance > 1)
        if (balance > 1) {
            if (node.getRight() != null && node.getRight().getBF() < 0) {
                // Rotaci�n doble a la izquierda
                return doubleRightRotation(node);
            }else if(node.getRight()!=null && node.getRight().getBF()==0) {
            	return singleRightRotation(node);  // Si el balance es 0, realiza una rotaci�n simple a la derecha
            }
            // Rotaci�n simple a la izquierda
            return singleLeftRotation(node);
        } 
        // Caso de desequilibrio a la izquierda (balance < -1)
        if (balance < -1) {
            if (node.getLeft() != null && node.getLeft().getBF() > 0) {
                // Rotaci�n doble a la derecha
                return doubleLeftRotation(node);
            }else if(node.getLeft()!=null && node.getLeft().getBF()==0) {
            	return singleLeftRotation(node);  // Si el balance es 0, realiza una rotaci�n simple a la izquierda
            }
            // Rotaci�n simple a la derecha
            return singleRightRotation(node);
        }
        
        return node;  // Si no hay desequilibrio, no se realiza ninguna rotaci�n
    }

    /**
     * Realiza una rotaci�n simple a la izquierda.
     * Este m�todo es usado para corregir un desequilibrio cuando el sub�rbol derecho es m�s alto.
     * @param node El nodo desequilibrado.
     * @return La nueva ra�z del sub�rbol despu�s de la rotaci�n.
     */
    private AVLNode<T> singleLeftRotation(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getRight();  // El hijo derecho se convierte en la nueva ra�z
        node.setRight(newRoot.getLeft());  // El sub�rbol izquierdo del hijo derecho se convierte en el sub�rbol derecho del nodo
        newRoot.setLeft(node);  // El nodo se convierte en el hijo izquierdo de la nueva ra�z

        // Actualiza las alturas despu�s de la rotaci�n.
        node.updateHeight();
        newRoot.updateHeight();
        return newRoot;  // Retorna la nueva ra�z del sub�rbol balanceado
    }

    /**
     * Realiza una rotaci�n simple a la derecha.
     * Este m�todo es usado para corregir un desequilibrio cuando el sub�rbol izquierdo es m�s alto.
     * @param node El nodo desequilibrado.
     * @return La nueva ra�z del sub�rbol despu�s de la rotaci�n.
     */
    private AVLNode<T> singleRightRotation(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getLeft();  // El hijo izquierdo se convierte en la nueva ra�z
        node.setLeft(newRoot.getRight());  // El sub�rbol derecho del hijo izquierdo se convierte en el sub�rbol izquierdo del nodo
        newRoot.setRight(node);  // El nodo se convierte en el hijo derecho de la nueva ra�z

        // Actualiza las alturas despu�s de la rotaci�n.
        node.updateHeight();
        newRoot.updateHeight();
        return newRoot;  // Retorna la nueva ra�z del sub�rbol balanceado
    }
    
    /**
     * Realiza una rotaci�n doble a la izquierda.
     * Se compone de una rotaci�n simple a la derecha seguida de una rotaci�n simple a la izquierda.
     * @param node El nodo desequilibrado.
     * @return La nueva ra�z del sub�rbol despu�s de la rotaci�n doble.
     */
    private AVLNode<T> doubleLeftRotation(AVLNode<T> node) {
        // Primero, rotaci�n simple a la izquierda del hijo izquierdo
        node.setLeft(singleLeftRotation(node.getLeft()));
        // Luego, rotaci�n simple a la derecha del nodo actual
        return singleRightRotation(node);
    }

    /**
     * Realiza una rotaci�n doble a la derecha.
     * Se compone de una rotaci�n simple a la izquierda seguida de una rotaci�n simple a la derecha.
     * @param node El nodo desequilibrado.
     * @return La nueva ra�z del sub�rbol despu�s de la rotaci�n doble.
     */
    private AVLNode<T> doubleRightRotation(AVLNode<T> node) {
        // Primero, rotaci�n simple a la derecha del hijo derecho
        node.setRight(singleRightRotation(node.getRight()));
        // Luego, rotaci�n simple a la izquierda del nodo actual
        return singleLeftRotation(node);
    }

    /**
     * Devuelve la ra�z del �rbol AVL como un nodo de tipo AVLNode.
     * Este m�todo anula el m�todo en la clase BSTree para asegurar que
     * el nodo ra�z es tratado como un AVLNode.
     * @return La ra�z del �rbol AVL.
     */
    @Override
    public AVLNode<T> getRoot() {
        return (AVLNode<T>) super.getRoot();  // Retorna la ra�z del �rbol como un nodo AVLNode
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
    		return false;  // No se puede borrar si el �rbol est� vac�o
    	}
    	if(searchNode(x)!=null){
    		this.setRoot(removeNodeRecursivo(x, getRoot()));  // Llamada recursiva para eliminar el nodo
    		getRoot().updateHeight();  // Actualiza la altura de la ra�z
    		updateAndBalanceIfNecesary(getRoot());  // Balancea el �rbol si es necesario
    		return true;
    	}
    	return false;
    }

    /**
     * Elimina recursivamente un nodo en el �rbol AVL.
     * @param x El valor del nodo a eliminar.
     * @param root La ra�z del sub�rbol donde se realiza la eliminaci�n.
     * @return El nuevo nodo ra�z despu�s de la eliminaci�n.
     */
    private AbstractTreeNode<T> removeNodeRecursivo(T x, AVLNode<T> root) {
    	if(root==null) {
    		return null;
    	} 
    	root.updateHeight();
    	updateAndBalanceIfNecesary(root);  // Balancea despu�s de cada eliminaci�n
    	if(x.compareTo(root.getInfo())<0) {
    		root.setLeft(removeNodeRecursivo(x, root.getLeft()));  // Elimina del sub�rbol izquierdo
    	}else if(x.compareTo(root.getInfo())>0) {
    		root.setRight(removeNodeRecursivo(x, root.getRight()));  // Elimina del sub�rbol derecho
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
     * Encuentra el nodo con el valor m�ximo en un sub�rbol.
     * @param left El sub�rbol donde buscar el valor m�ximo.
     * @return El nodo con el valor m�ximo.
     */
    private AVLNode<T> findMax(AVLNode<T> left) {
    	AVLNode<T> max = left;
    	while(max.getRight()!=null) {
    		max = max.getRight();  // Sigue el enlace derecho hasta el nodo m�s grande
    	}
    	return max;
    }
}
