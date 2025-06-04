package p3Arboles;

/**
 * Clase que implementa un árbol binario de búsqueda (BST).
 * @param <T> Tipo de los elementos en el árbol que debe ser Comparable.
 * @author Prodesores ED (Español)
 * @version 2024-25 distribuible
 */
public class BSTree<T extends Comparable<T>> extends AbstractTree<T> {

    /**
     * Getter para obtener la raíz del árbol.
     * @return La raíz del árbol como un nodo de tipo BSTNode.
     */
    protected BSTNode<T> getRoot() {
        return (BSTNode<T>) super.getRoot();  // Retorna la raíz del árbol castada a BSTNode
    }

    /**
     * Añade un nodo al árbol.
     * Si el nodo ya existe, no lo inserta y devuelve false.
     * Si el nodo es nulo, lanza una NullPointerException.
     * @param info El valor que se quiere insertar en el árbol.
     * @return true si el nodo se inserta correctamente, false si ya existe.
     */
    public boolean addNode(T info) {
        if (info == null) {
            throw new NullPointerException("Element to insert is null.");  // Si el valor es nulo, lanza una excepción.
        }
        try {
            if (this.getRoot() == null) {  // Si el árbol está vacío, se crea la raíz.
                this.setRoot(new BSTNode<T>(info));
                return true;
            } else {
                addRecursivo(info, getRoot());  // Llamada recursiva para insertar el nodo.
            }
        } catch (IllegalArgumentException e) {
            return false;  // Si el nodo ya existe, se captura la excepción y se devuelve false.
        }
        return true;
    }

    /**
     * Inserta un nodo de manera recursiva en el árbol.
     * @param info El valor que se quiere insertar.
     * @param root El nodo raíz desde donde comienza la inserción.
     */
    private void addRecursivo(T info, BSTNode<T> root) {
        // Si el valor es menor que el nodo actual, se inserta en el subárbol izquierdo.
        if (info.compareTo(root.getInfo()) < 0) {
            if (root.getLeft() == null) {  // Si el subárbol izquierdo está vacío, inserta el nodo.
                root.setLeft(new BSTNode<>(info));
            } else {
                addRecursivo(info, root.getLeft());  // Llamada recursiva a la izquierda.
            }
        }
        // Si el valor es mayor que el nodo actual, se inserta en el subárbol derecho.
        else if (info.compareTo(root.getInfo()) > 0) {
            if (root.getRight() == null) {  // Si el subárbol derecho está vacío, inserta el nodo.
                root.setRight(new BSTNode<>(info));
            } else {
                addRecursivo(info, root.getRight());  // Llamada recursiva a la derecha.
            }
        }
        // Si el valor es igual al nodo actual, lanza una excepción (el valor ya existe).
        else {
            throw new IllegalArgumentException("El nodo ya existe en el árbol");
        }
    }

    /**
     * Busca un nodo en el árbol que sea igual al valor proporcionado.
     * Devuelve el valor encontrado o null si no lo encuentra.
     * @param info El valor que se busca en el árbol.
     * @return El valor encontrado o null si no existe.
     */
    public T searchNode(T info) {
        if (this.getRoot() == null) {
            return null;  // Si el árbol está vacío, no se encuentra el valor.
        } else {
            return searchRecursivo(info, getRoot());  // Llamada recursiva para buscar el valor.
        }
    }

    /**
     * Realiza la búsqueda recursiva de un nodo en el árbol.
     * @param info El valor que se busca.
     * @param root El nodo actual desde donde comienza la búsqueda.
     * @return El valor encontrado o null si no existe.
     */
    private T searchRecursivo(T info, BSTNode<T> root) {
        if (root == null) {
            return null;  // Si el nodo es null, no se encuentra el valor.
        } else if (info.compareTo(root.getInfo()) == 0) {
            return root.getInfo();  // Si el valor coincide con el nodo actual, lo retorna.
        } else if (info.compareTo(root.getInfo()) < 0) {
            return searchRecursivo(info, root.getLeft());  // Buscar en el subárbol izquierdo.
        } else {
            return searchRecursivo(info, root.getRight());  // Buscar en el subárbol derecho.
        }
    }

    /**
     * Realiza un recorrido en preorden del árbol.
     * Devuelve un String con los valores de los nodos en preorden.
     * @return Un String con los valores en preorden.
     */
    public String preOrder() {
        if (getRoot() == null) {
            return "";  // Si el árbol está vacío, devuelve una cadena vacía.
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
        sb.append(recursivoPreOrden(root.getLeft()) + "\t");  // Llamada recursiva al subárbol izquierdo.
        sb.append(recursivoPreOrden(root.getRight()) + "\t");  // Llamada recursiva al subárbol derecho.
        return sb.toString();
    }

    /**
     * Realiza un recorrido en postorden del árbol.
     * Devuelve un String con los valores de los nodos en postorden.
     * @return Un String con los valores en postorden.
     */
    public String postOrder() {
        if (getRoot() == null) {
            return "";  // Si el árbol está vacío, devuelve una cadena vacía.
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
        sb.append(recursivoPostOrden(root.getLeft()) + "\t");  // Llamada recursiva al subárbol izquierdo.
        sb.append(recursivoPostOrden(root.getRight()) + "\t");  // Llamada recursiva al subárbol derecho.
        sb.append(root + "\t");  // Agrega el nodo actual.
        return sb.toString();
    }

    /**
     * Realiza un recorrido en inorden del árbol.
     * Devuelve un String con los valores de los nodos en inorden.
     * @return Un String con los valores en inorden.
     */
    public String inOrder() {
        if (getRoot() == null) {
            return "";  // Si el árbol está vacío, devuelve una cadena vacía.
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
        sb.append(recursivoInOrder(root.getLeft()) + "\t");  // Llamada recursiva al subárbol izquierdo.
        sb.append(root + "\t");  // Agrega el nodo actual.
        sb.append(recursivoInOrder(root.getRight()) + "\t");  // Llamada recursiva al subárbol derecho.
        return sb.toString();
    }

    /**
     * Elimina un nodo con el valor dado.
     * Devuelve true si el nodo se elimina correctamente, false si no lo encuentra.
     * Si el valor es nulo, lanza una NullPointerException.
     * @param x El valor del nodo que se desea eliminar.
     * @return true si el nodo fue eliminado, false si no se encontró.
     */
    @Override
    public boolean removeNode(T x) {
        if (x == null) {
            throw new NullPointerException("Nodo recibido es null");  // Si el valor es nulo, lanza una excepción.
        }
        if (getRoot() == null) {
            return false;  // Si el árbol está vacío, no se puede eliminar.
        }
        if (searchNode(x) != null) {
            this.setRoot(removeNodeRecursivo(x, getRoot()));  // Llamada recursiva para eliminar el nodo.
            return true;
        }
        return false;  // Si el nodo no se encuentra, devuelve false.
    }

    /**
     * Elimina un nodo de manera recursiva en el árbol.
     * @param x El valor del nodo a eliminar.
     * @param root El nodo raíz desde donde comienza la eliminación.
     * @return El nodo raíz actualizado después de la eliminación.
     */
    private AbstractTreeNode<T> removeNodeRecursivo(T x, BSTNode<T> root) {
        if (root == null) {
            return null;  // Si el nodo no se encuentra, retorna null.
        }
        if (x.compareTo(root.getInfo()) < 0) {
            root.setLeft(removeNodeRecursivo(x, root.getLeft()));  // Llamada recursiva al subárbol izquierdo.
        } else if (x.compareTo(root.getInfo()) > 0) {
            root.setRight(removeNodeRecursivo(x, root.getRight()));  // Llamada recursiva al subárbol derecho.
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
        return root;  // Retorna el nodo raíz actualizado.
    }

    /**
     * Encuentra el nodo con el valor máximo en el subárbol izquierdo.
     * @param left El subárbol izquierdo donde buscar el valor máximo.
     * @return El nodo con el valor máximo.
     */
    private BSTNode<T> findMax(BSTNode<T> left) {
        BSTNode<T> max = left;
        while (max.getRight() != null) {
            max = max.getRight();  // Sigue hacia la derecha hasta encontrar el valor máximo.
        }
        return max;
    }
}
