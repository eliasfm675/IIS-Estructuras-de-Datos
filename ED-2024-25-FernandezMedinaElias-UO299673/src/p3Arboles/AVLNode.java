package p3Arboles;

/**
 * Clase derivada de BSTNode añadiendo funcionalidad de AVL.
 * @param <T> el tipo de datos almacenado en el nodo, que debe ser comparable.
 */
public class AVLNode<T extends Comparable<T>> extends BSTNode<T> {

    /**
     * Altura del nodo.
     */
    protected int height;

    /**
     * Factor de balance (BF) del nodo.
     */
    protected int balanceFactor;

    /**
     * Constructor que llama al constructor de la clase padre y establece la altura inicial.
     * @param info el valor que se almacenará en el nodo
     */
    public AVLNode(T info) {
        super(info);
        this.height = 1; // Altura inicial del nodo
        this.balanceFactor = 0; // Balance inicial
    }

    /**
     * Devuelve la altura del nodo.
     * @return altura del nodo
     */
    public int getHeight() {
        return height;
    }

    /**
     * Devuelve el factor de balance del nodo, calculado como la diferencia entre las alturas
     * del subárbol derecho y el izquierdo.
     * @return el factor de balance
     */
    public int getBF() {
        return balanceFactor;
    }

    /**
     * Actualiza la altura y el factor de balance del nodo según las alturas de sus hijos.
     */
    protected void updateHeight() {
        int leftHeight = (getLeft() != null) ? getLeft().getHeight() : 0;
        int rightHeight = (getRight() != null) ? getRight().getHeight() : 0;

        // Calcula la altura del nodo actual
        height = 1 + Math.max(leftHeight, rightHeight);

        // Calcula el factor de balance como diferencia entre alturas de subárbol derecho e izquierdo
        balanceFactor = rightHeight - leftHeight;
    }

    /**
     * Devuelve el hijo izquierdo como un nodo AVL.
     * @return el nodo hijo izquierdo
     */
    @Override
    public AVLNode<T> getLeft() {
        return (AVLNode<T>) super.getLeft();
    }

    /**
     * Devuelve el hijo derecho como un nodo AVL.
     * @return el nodo hijo derecho
     */
    @Override
    public AVLNode<T> getRight() {
        return (AVLNode<T>) super.getRight();
    }

    /**
     * Representación en cadena del nodo, que incluye el valor almacenado y el factor de balance.
     * @return una cadena que representa el nodo y su factor de balance
     */
    @Override
    public String toString() {
        return super.toString() + ":BF=" + getBF();
    }
}
