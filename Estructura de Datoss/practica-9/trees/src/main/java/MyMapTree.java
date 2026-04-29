import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyMapTree<K extends Comparable<? super K >, V extends Comparable<? super V>> implements SortedMap<K, V> {


    private class Node<K extends Comparable<? super K >, V extends Comparable<? super V>> {
        Node<K, V> hi, hd;
        K key;
        V value;
        int height;

        public Node (K key, V value){
            hi = null;
            hd = null;
            this.key = key;
            this.value = value;
            height = 1;
        }

        public Set<K> inOrder(){
            Set<K> result = new LinkedHashSet<>();
            if(hi != null){
                result.addAll(hi.inOrder());
            }
            result.add(key);
            if(hd != null) {
                result.addAll(hd.inOrder());
            }
            return result;
        }

    }

        protected Node<K, V> root;
        protected int size;

        public MyMapTree(){
            root = null;
            size = 0;
        }

    @Override
    public V put(K key, V value) {
        if(containsKey(key)) return null;

        root = add(root, key, value);
        size++;
        return value;
    }

    private Node<K,V> add(Node<K,V> nodo, K key, V value){
        if(nodo == null) return new Node<K,V>(key, value);

        int cmp = key.compareTo(nodo.key);

        if(cmp < 0){
            nodo.hi = add(nodo.hi, key, value);
        } else if (cmp > 0){
            nodo.hd = add(nodo.hd, key, value);
        } else {
            assert false;
        }
        nodo.height = 1 + Math.max(height(nodo.hd), height(nodo.hi));
        return balanceador(nodo);
    }

    @Override
    public V removeKey(K key) {
        if(!containsKey(key)) throw new NoSuchElementException();
        V aux = get(key);
        root = removeKey(root, key);
        return aux;
    }

    private Node<K,V> removeKey(Node<K,V> nodo, K key){
        if(nodo == null) return null;
        int cmp = key.compareTo(nodo.key);

        if(cmp < 0){
            nodo.hi = removeKey( nodo.hi, key);
        } else if( cmp > 0) {
            nodo.hd = removeKey(nodo.hd, key);
        } else {
                if(nodo.hi == null) return nodo.hd;
                if(nodo.hd == null) return nodo.hi;
                Node<K,V> min = getMin(nodo.hd);
                nodo.key = min.key;
                nodo.value = min.value;
                nodo.hd = removeKey(nodo.hd, min.key);
        }
        nodo.height = 1 + Math.max(height(nodo.hd), height(nodo.hi));
        return balanceador(nodo);
    }

    @Override
    public V get(K key) {
        return get(root, key).value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && root == null;
    }

    @Override
    public V min() {
        return getMin(root).value;
    }

    private Node<K,V> getMin(Node<K,V> nodo){
        if(nodo.hi == null){
            return nodo;
        }
        return getMin(nodo.hi);
    }

    @Override
    public void removeMin() {
        if(isEmpty()) throw new NoSuchElementException();
        root = removeMin(root);
        size--;
    }

    private Node<K,V> removeMin(Node<K,V> nodo){
        if(nodo.hi == null){
            return nodo.hd;
        }
        nodo.hi = removeMin(nodo.hi);
        nodo.height = 1 + Math.max(height(nodo.hd), height(nodo.hi));
        return balanceador(nodo);
    }

    @Override
    public Set<K> keySet() {
        return root.inOrder();
    }

    @Override
    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    private Node<K, V> get(Node<K, V> raiz, K key){
        if(raiz == null) return null;

        int cmp = key.compareTo(raiz.key);

        if(cmp < 0) {
            return get(raiz.hi, key);
        } else if( cmp > 0){
            return get(raiz.hd, key);
        } else {
            return raiz;
        }
        //return raiz;
        
    }

    private Node<K, V> rotateLeft(Node<K,V> nodo){
        Node<K, V> y = nodo.hd;
        nodo.hd = y.hi;
        y.hi = nodo;
        nodo.height = 1 + Math.max(height(nodo.hi), height(nodo.hd));
        y.height = 1 + Math.max(height(y.hd), height(y.hi));
        return y;
    }

    private Node<K,V> rotateRight(Node<K,V> nodo){
        Node<K,V> y = nodo.hi;
        nodo.hi = y.hd;
        y.hd = nodo;
        nodo.height = 1 + Math.max(height(nodo.hi), height(nodo.hd));
        y.height = 1 + Math.max(height(y.hi), height(y.hd));
        return y;
    }

    public Node<K,V> balanceador(Node<K,V> nodo){
        if(factorBalance(nodo) > 1){
            if(factorBalance(nodo.hi) < 0){
                nodo.hi = rotateLeft(nodo.hi);
            }
            nodo = rotateRight(nodo);
        } else if (factorBalance(nodo) < -1){
            if(factorBalance(nodo.hd) > 0){
                nodo.hd = rotateRight(nodo.hd);
            }
            nodo = rotateLeft(nodo);
        }
        return nodo;
    }

    private int factorBalance(Node<K,V> nodo) {
        return nodo == null ? 0 : height(nodo.hi) - height(nodo.hd);
    }

    private int height(Node<K, V> nodo) {
        return nodo == null ? 0 : nodo.height;
    }

    @Override
    public Iterator iterator() {
        return new AVLIterator<>();
    }

    private class AVLIterator<K extends Comparable<? super K >, V extends Comparable<? super V>> implements Iterator<K>{

        private Iterator<K> in;

        public AVLIterator(){
            in = (Iterator<K>) root.inOrder().iterator();
        }

        @Override
        public boolean hasNext() {
            return in.hasNext();
        }

        @Override
        public K next() {
            return in.next();
        }

    }

    


}
