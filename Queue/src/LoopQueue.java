public class LoopQueue<E> implements Queue<E>{

    /* ArrayQueue<E>
     * void enqueue(E) | O(1) 均摊
     * E dequeue() | O(1) 均摊
     * E getFront() | O(1)
     * int getSize() | O(1)
     * boolean isEmpty() | O(1)*/

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null; // 手动回收
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        // 循环队列的遍历方式1
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        // 循环队列的遍历方式2
        for(int i = 0 ; i != tail ; i = (i + 1) % data.length) {
            res.append(data[i]);
            if((i +1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
