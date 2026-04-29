    import java.util.LinkedList;
    import java.util.List;
    import java.util.Iterator;
    import java.util.NoSuchElementException;

    import javax.swing.tree.TreeNode;


    public class MyBinarySearch<T extends Comparable<? super T>> implements SortedSet<T> {
        
        /**
         * creo la clase de los nodos
         */

        protected class NodeTree {//el tipo que uses tiene que ser un tipo que se pueda comparar
            protected T elemento;
            private NodeTree left;
            private NodeTree right;

            public NodeTree(){
                elemento = null;
                left = null;
                right = null;
            }

            public NodeTree(T key){
                elemento = key;
                left = null;
                right = null;
            }

            /**
             * retorna una lista con su respectivo recorrido
             * recorrido preorder raiz - hijoIzquierdo - hijoDerecho
             */
            public List preOrder(){
                List result = new LinkedList<>(); //creo una lista para devolver su vista en preorder
                //se agrega la raiz
                result.add(elemento);
                //se recorre el hijo izquierdo
                if(left != null){
                    result.addAll(left.preOrder());
                }
                //se recorre el hijo derecho
                if(right != null){
                    result.addAll(right.preOrder());
                }

                return result;
            }

            /**
             * recorrido postOrder hijoIzquierdo - HijoDerecho - raiz 
             */
            public List postOrder(){
                List result = new LinkedList();

                if(left != null ) {
                    result.addAll(left.postOrder());
                }

                if (right != null){
                    result.addAll(right.postOrder());
                }
                result.add(elemento);

                return result;
            }

            /**
             * recorrido inOrder hijoIzquierdo - raiz - hijoDerecho
             */
            public List inOrder(){
                List result = new LinkedList();
                if(left != null){
                    result.addAll(left.inOrder());
                }
                result.add(elemento);
                if(right != null){
                    result.addAll(right.inOrder());
                }

                return result;
            }
        }



        protected NodeTree root;
        protected int size;

        public MyBinarySearch(){
            root = null;
            size = 0;
        }

            /**
         * @post Adds 'x' to the elements of 'this'.
         *   More formally, it satisfies: this = old(this) U {e}.
         */
        public boolean add(T x){

            if(x == null) throw new NoSuchElementException("null esta en todos lados papa");

            if (contains(x)){
                return false;
                }

            root = add(root, x);
            size++;
            return true;

            
        }

        private NodeTree add(NodeTree raiz, T key){
            //si esta vacio retorno un nuevo nodo justo en la raiz
            if(raiz == null){
                return new NodeTree(key);
            }
            //comparamos que el elemento no este ya que no se pueden repetir elementos
            int cmp = key.compareTo(raiz.elemento);
            // y ahora depende del resultado de la comparacion vemos para donde vamos...
            if(cmp < 0){
                raiz.left = add(raiz.left, key);
            }else if (cmp > 0 ){
                raiz.right = add(raiz.right, key);
            } else {
                assert false;
            }
            //siempre se retorna la raiz para no perder de vista el arbol en memoria 
            return raiz;
        }

        /**
         *@post te dice si el arbol esta vacio
        */
        public boolean isEmpty(){
            return root == null;
        }

        /**
         * @post Returns the cardinality of 'this'.
         *   More formally, it satisfies: #this.
         */
        public int size(){
            return size;
        }

            public boolean remove (T key){
            if(!contains(key)) return false;//si no esta la key no hay nada para eliminar 

            root = remove(root, key);
            size --;
            return true;
        }

        private NodeTree remove(NodeTree raiz, T key){//si llegamos aca es que la key exciste 
            int cmp = key.compareTo(raiz.elemento);
            if(cmp < 0){
                raiz.left = remove(raiz.left, key);
            } else if ( cmp > 0) {
                raiz.right = remove(raiz.right, key);
            }
                return null;
            
        } 
        
        /**
         * @pre !isEmpty()
         * @post Deletes the smallest element of 'this'.
         */   
        public void removeMin(){
            if (isEmpty()) {
                throw new NoSuchElementException("arbol vacio");
            } 

            //throw new UnsupportedOperationException("metodo a implementar");
        }

        private NodeTree getMin(NodeTree raiz){
            if(raiz.left == null){
                return raiz;
            } else {
                return getMin(raiz.left);
            }
        }
        
        /**
         * @post Returns true iff 'key' is in 'this'.
         */  
        public boolean contains(T key){
            if(key == null) throw new NoSuchElementException("null esta en todos lados papa");
            return get(root, key) != null;

            //throw new UnsupportedOperationException("metodo a implementar");
        }

        public T getRootElement(){
            return get(root, root.elemento).elemento;
        }


        private NodeTree get(NodeTree x, T key){
            if (x == null){
                return null;
            }

            int cmp = key.compareTo(x.elemento);

            if(cmp < 0){
                return get(x.left, key);
            } else if ( cmp > 0) {
                return get(x.right, key);
            } else {
                return x;
            }
        }


        /**
         * @post Returns an iterator for the set that iterates through 
         *   the items in order.
         */
        public Iterator<T> iterator(){
            return new TreeIterator();
        }

        private class TreeIterator implements Iterator<T> {
            private LinkedList<T> allElements;

            public TreeIterator(){
                allElements = new LinkedList<>();
                if (root != null) {
                    allElements.addAll(root.inOrder());
                }
            }

            @Override
            public boolean hasNext(){
                return !allElements.isEmpty();
            }

            @Override 
            public T next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return allElements.removeFirst();
            }
        }


                @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Iterable<?> other)) return false;
            Iterator<T> it1 = this.iterator();
            Iterator<?> it2 = other.iterator();
            while (it1.hasNext() && it2.hasNext()) {
                T e1 = it1.next();
                Object e2 = it2.next();
                if (!e1.equals(e2)) return false;
            }
            // deben acabarse juntos
            return !it1.hasNext() && !it2.hasNext();
        }

        @Override
        public int hashCode() {
            int h = 0;
            for (T e : this) {
                h = 31*h + e.hashCode();
            }
            return h;
        }




    }
