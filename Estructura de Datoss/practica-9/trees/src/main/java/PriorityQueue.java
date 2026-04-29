public interface PriorityQueue<T extends Comparable<? super T>> {


    public void insert(T x);

    public boolean isEmpty();

    public int size();

    public T max();

    public T removeMax();
}
