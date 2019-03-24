public class ArrayQueue<E> implements Queue<E> {

    /* ArrayQueue<E>
     * void enqueue(E) | O(1) 均摊
     * E dequeue() | O(n)
     * E getFront() | O(1)
     * int getSize() | O(1)
     * boolean isEmpty() | O(1)*/

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    // 入队
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // 出队
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    // 查看队首
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
