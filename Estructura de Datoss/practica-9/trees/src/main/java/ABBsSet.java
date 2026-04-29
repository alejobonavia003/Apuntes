import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ABBsSet<T extends Comparable<? super T>> implements SortedSet<T> {

    private class NodeTree<T extends Comparable<? super T>> {
        private T element;
        private NodeTree left;
        private NodeTree right;

        public NodeTree(T elem){
            element = elem;
            left = null;
            right = null;
        }

        public NodeTree(){
            element = null;
            left = null;
            right = null;
        }

        public List<T> preOrder() {
            List<T> result = new LinkedList<>();
            //agregamos la raiz 
            result.add(element);
            //recorremos el hijo izquierdo 
            if(left != null){
                result.addAll(left.preOrder());
            }

            //recorremos el hijo derecho 
            if (right != null) {
                result.addAll(right.preOrder());
            }
            return result;
        }

        public List<T> inOrder(){
            List<T> result = new LinkedList<>();

            //agregamos el hijo izquierdo 
            if ( left != null) {
                result.addAll(left.inOrder());
            }
            //agregamos la raiz
            result.add(element);

            if(right != null){
                result.addAll(right.inOrder());
            }

            return result;

        }

        public List<T> postOrder(){
            List<T> result = new LinkedList<>();

            //agregamos el hijo izquierdo 
            if (left != null){
                result.addAll(left.preOrder());
            }
            //agregamos el hijjp derecho 
            if(right != null){
                result.addAll(right.preOrder());
            }
            return result;
        }
    }

    protected NodeTree<T> root;
    protected Integer size;

    public ABBsSet(){
        root = null;
        size = 0;
    }

    @Override
    public boolean add(T key) {
        if(contains(key)){
            return false;
        } 
        
        root = add(key, root);
        size++;
        return true;

    }

        private NodeTree<T> add(T key, NodeTree<T> x) {
            if(x == null) {
                return new NodeTree<>(key);
            } 

            Integer aux = key.compareTo(x.element);

            if (aux < 0) {
                x = add(key, x.left);
            }else if (aux > 0) {
                x = add(key, x.right);
            } else {
                assert false;
            }

            return x;
        }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void removeMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMin'");
    }

    @Override
    public boolean contains(T key) {
        return get(key, root) != null;
    }
        public NodeTree<T> get(T key, NodeTree<T> x ){
            if (x == null) {
                return null;
            }
            Integer aux = key.compareTo(x.element);
            if (aux < 0){
                return get(key, x.left);
            } else if(aux > 0) {
                return get(key, x.right);
            } else {
                return x;
            }
        }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
