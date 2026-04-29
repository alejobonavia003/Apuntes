import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyAVLs<T extends Comparable<? super T>> implements SortedSet<T> {

    protected class AVLNode {
        T elemento;
        AVLNode left, right;
        int height;

        AVLNode(T key) {
            this.elemento = key;
            this.height = 1;
        }
    }

    private AVLNode root;
    private int size;

    public MyAVLs() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean add(T x) {
        if (contains(x)) return false;
        root = add(root, x);
        size++;
        return true;
    }

    private AVLNode add(AVLNode node, T key) {
        if (node == null) return new AVLNode(key);
        int cmp = key.compareTo(node.elemento);
        if (cmp < 0) {
            node.left = add(node.left, key);
        } else if (cmp > 0) {
            node.right = add(node.right, key);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    @Override
    public void removeMin() {
        if (isEmpty()) throw new NoSuchElementException();
        root = removeMin(root);
        size--;
    }

    private AVLNode removeMin(AVLNode node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    public boolean remove(T key) {
        if (!contains(key)) return false;
        root = remove(root, key);
        size--;
        return true;
    }

    private AVLNode remove(AVLNode node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.elemento);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            AVLNode min = getMinValue(node.right);
            node.elemento = min.elemento;
            node.right = remove(node.right, min.elemento);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private AVLNode getMinValue(AVLNode node) {
        return node.left == null ? node : getMinValue(node.left);
    }

    private AVLNode balance(AVLNode x) {
        int bf = getBalance(x);
        if (bf > 1) {
            if (getBalance(x.left) < 0) x.left = rotateLeft(x.left);
            return rotateRight(x);
        } else if (bf < -1) {
            if (getBalance(x.right) > 0) x.right = rotateRight(x.right);
            return rotateLeft(x);
        }
        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private AVLNode rotateRight(AVLNode x) {
        AVLNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    @Override
    public boolean contains(T key) {
        return get(root, key) != null;
    }

    private AVLNode get(AVLNode node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.elemento);
        if (cmp < 0) return get(node.left, key);
        if (cmp > 0) return get(node.right, key);
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        LinkedList<T> list = new LinkedList<>();
        inorder(root, list);
        return list.iterator();
    }

    private void inorder(AVLNode node, List<T> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.elemento);
        inorder(node.right, list);
    }

    @Override
    public String toString() {
        return "{}";
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
