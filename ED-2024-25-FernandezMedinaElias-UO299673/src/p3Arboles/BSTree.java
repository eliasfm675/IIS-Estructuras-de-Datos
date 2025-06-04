package p3Arboles;

/**
 * Clase que implementa un �rbol binario de b�squeda (BST).
 * @param <T> Tipo de los elementos en el �rbol que debe ser Comparable.
 * @author Prodesores ED (Espa�ol)
 * @version 2024-25 distribuible
 */
public class BSTree<T extends Comparable<T>> extends AbstractTree<T> {

    /**
     * Getter para obtener la ra�z del �rbol.
     * @return La ra�z del �rbol como un nodo de tipo BSTNode.
     */
    protected BSTNode<T> getRoot() {
        return (BSTNode<T>) super.getRoot();  // Retorna la ra�z del �rbol castada a BSTNode
    }

    /**
     * A�ade un nodo al �rbol.
     * Si el nodo ya existe, no lo inserta y devuelve false.
     * Si el nodo es nulo, lanza una NullPointerException.
     * @param info El valor que se quiere insertar en el �rbol.
     * @return true si el nodo se inserta correctamente, false si ya existe.
     */
    public boolean addNode(T info) {
        if (info == null) {
            throw new NullPointerException("Element to insert is null.");  // Si el valor es nulo, lanza una excepci�n.
        }
        try {
            if (this.getRoot() == null) {  // Si el �rbol est� vac�o, se crea la ra�z.
                this.setRoot(new BSTNode<T>(info));
                return true;
            } else {
                addRecursivo(info, getRoot());  // Llamada recursiva para insertar el nodo.
            }
        } catch (IllegalArgumentException e) {
            return false;  // Si el nodo ya existe, se captura la excepci�n y se devuelve false.
        }
        return true;
    }

    /**
     * Inserta un nodo de manera recursiva en el �rbol.
     * @param info El valor que se quiere insertar.
     * @param root El nodo ra�z desde donde comienza la inserci�n.
     */
    private void addRecursivo(T info, BSTNode<T> root) {
        // Si el valor es menor que el nodo actual, se inserta en el sub�rbol izquierdo.
        if (info.compareTo(root.getInfo()) < 0) {
            if (root.getLeft() == null) {  // Si el sub�rbol izquierdo est� vac�o, inserta el nodo.
                root.setLeft(new BSTNode<>(info));
            } else {
                addRecursivo(info, root.getLeft());  // Llamada recursiva a la izquierda.
            }
        }
        // Si el valor es mayor que el nodo actual, se inserta en el sub�rbol derecho.
        else if (info.compareTo(root.getInfo()) > 0) {
            if (root.getRight() == null) {  // Si el sub�rbol derecho est� vac�o, inserta el nodo.
                root.setRight(new BSTNode<>(info));
            } else {
                addRecursivo(info, root.getRight());  // Llamada recursiva a la derecha.
            }
        }
        // Si el valor es igual al nodo actual, lanza una excepci�n (el valor ya existe).
        else {
            throw new IllegalArgumentException("El nodo ya existe en el �rbol");
        }
    }

    /**
     * Busca un nodo en el �rbol que sea igual al valor proporcionado.
     * Devuelve el valor encontrado o null si no lo encuentra.
     * @param info El valor que se busca en el �rbol.
     * @return El valor encontrado o null si no existe.
     */
    public T searchNode(T info) {
        if (this.getRoot() == null) {
            return null;  // Si el �rbol est� vac�o, no se encuentra el valor.
        } else {
            return searchRecursivo(info, getRoot());  // Llamada recursiva para buscar el valor.
        }
    }

    /**
     * Realiza la b�squeda recursiva de un nodo en el �rbol.
     * @param info El valor que se busca.
     * @param root El nodo actual desde donde comienza la b�squeda.
     * @return El valor encontrado o null si no existe.
     */
    private T searchRecursivo(T info, BSTNode<T> root) {
        if (root == null) {
            return null;  // Si el nodo es null, no se encuentra el valor.
        } else if (info.compareTo(root.getInfo()) == 0) {
            return root.getInfo();  // Si el valor coincide con el nodo actual, lo retorna.
        } else if (info.compareTo(root.getInfo()) < 0) {
            return searchRecursivo(info, root.getLeft());  // Buscar en el sub�rbol izquierdo.
        } else {
            return searchRecursivo(info, root.getRight());  // Buscar en el sub�rbol derecho.
        }
    }

    /**
     * Realiza un recorrido en preorden del �rbol.
     * Devuelve un String con los valores de los nodos en preorden.
     * @return Un String con los valores en preorden.
     */
    public String preOrder() {
        if (getRoot() == null) {
            return "";  // Si el �rbol est� vac�o, devuelve una cadena vac�a.
        }
        return recursivoPreOrden(getRoot());  // Llamada recursiva para realizar el recorrido en preorden.
    }

    /**
     * Realiza el recorrido en preorden de manera recursiva.
     * @param root El nodo actual desde donde comienza el recorrido.
     * @return Una cadena con los valores en preorden.
     */
    private String recursivoPreOrden(BSTNode<T> root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root + "\t");  // Agrega el nodo actual.
        sb.append(recursivoPreOrden(root.getLeft()) + "\t");  // Llamada recursiva al sub�rbol izquierdo.
        sb.append(recursivoPreOrden(root.getRight()) + "\t");  // Llamada recursiva al sub�rbol derecho.
        return sb.toString();
    }

    /**
     * Realiza un recorrido en postorden del �rbol.
     * Devuelve un String con los valores de los nodos en postorden.
     * @return Un String con los valores en postorden.
     */
    public String postOrder() {
        if (getRoot() == null) {
            return "";  // Si el �rbol est� vac�o, devuelve una cadena vac�a.
        }
        return recursivoPostOrden(getRoot());  // Llamada recursiva para realizar el recorrido en postorden.
    }

    /**
     * Realiza el recorrido en postorden de manera recursiva.
     * @param root El nodo actual desde donde comienza el recorrido.
     * @return Una cadena con los valores en postorden.
     */
    private String recursivoPostOrden(BSTNode<T> root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(recursivoPostOrden(root.getLeft()) + "\t");  // Llamada recursiva al sub�rbol izquierdo.
        sb.append(recursivoPostOrden(root.getRight()) + "\t");  // Llamada recursiva al sub�rbol derecho.
        sb.append(root + "\t");  // Agrega el nodo actual.
        return sb.toString();
    }

    /**
     * Realiza un recorrido en inorden del �rbol.
     * Devuelve un String con los valores de los nodos en inorden.
     * @return Un String con los valores en inorden.
     */
    public String inOrder() {
        if (getRoot() == null) {
            return "";  // Si el �rbol est� vac�o, devuelve una cadena vac�a.
        }
        return recursivoInOrder(getRoot());  // Llamada recursiva para realizar el recorrido en inorden.
    }

    /**
     * Realiza el recorrido en inorden de manera recursiva.
     * @param root El nodo actual desde donde comienza el recorrido.
     * @return Una cadena con los valores en inorden.
     */
    private String recursivoInOrder(BSTNode<T> root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(recursivoInOrder(root.getLeft()) + "\t");  // Llamada recursiva al sub�rbol izquierdo.
        sb.append(root + "\t");  // Agrega el nodo actual.
        sb.append(recursivoInOrder(root.getRight()) + "\t");  // Llamada recursiva al sub�rbol derecho.
        return sb.toString();
    }

    /**
     * Elimina un nodo con el valor dado.
     * Devuelve true si el nodo se elimina correctamente, false si no lo encuentra.
     * Si el valor es nulo, lanza una NullPointerException.
     * @param x El valor del nodo que se desea eliminar.
     * @return true si el nodo fue eliminado, false si no se encontr�.
     */
    @Override
    public boolean removeNode(T x) {
        if (x == null) {
            throw new NullPointerException("Nodo recibido es null");  // Si el valor es nulo, lanza una excepci�n.
        }
        if (getRoot() == null) {
            return false;  // Si el �rbol est� vac�o, no se puede eliminar.
        }
        if (searchNode(x) != null) {
            this.setRoot(removeNodeRecursivo(x, getRoot()));  // Llamada recursiva para eliminar el nodo.
            return true;
        }
        return false;  // Si el nodo no se encuentra, devuelve false.
    }

    /**
     * Elimina un nodo de manera recursiva en el �rbol.
     * @param x El valor del nodo a eliminar.
     * @param root El nodo ra�z desde donde comienza la eliminaci�n.
     * @return El nodo ra�z actualizado despu�s de la eliminaci�n.
     */
    private AbstractTreeNode<T> removeNodeRecursivo(T x, BSTNode<T> root) {
        if (root == null) {
            return null;  // Si el nodo no se encuentra, retorna null.
        }
        if (x.compareTo(root.getInfo()) < 0) {
            root.setLeft(removeNodeRecursivo(x, root.getLeft()));  // Llamada recursiva al sub�rbol izquierdo.
        } else if (x.compareTo(root.getInfo()) > 0) {
            root.setRight(removeNodeRecursivo(x, root.getRight()));  // Llamada recursiva al sub�rbol derecho.
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;  // Nodo hoja, se elimina.
            } else if (root.getLeft() == null) {
                return root.getRight();  // Nodo con un solo hijo derecho.
            } else if (root.getRight() == null) {
                return root.getLeft();  // Nodo con un solo hijo izquierdo.
            } else {
                BSTNode<T> succesor = findMax(root.getLeft());  // Encuentra el sucesor.
                root.setInfo(succesor.getInfo());  // Sustituye el valor del nodo por el sucesor.
                root.setLeft(removeNodeRecursivo(succesor.getInfo(), root.getLeft()));  // Elimina el sucesor.
            }
        }
        return root;  // Retorna el nodo ra�z actualizado.
    }

    /**
     * Encuentra el nodo con el valor m�ximo en el sub�rbol izquierdo.
     * @param left El sub�rbol izquierdo donde buscar el valor m�ximo.
     * @return El nodo con el valor m�ximo.
     */
    private BSTNode<T> findMax(BSTNode<T> left) {
        BSTNode<T> max = left;
        while (max.getRight() != null) {
            max = max.getRight();  // Sigue hacia la derecha hasta encontrar el valor m�ximo.
        }
        return max;
    }
}
