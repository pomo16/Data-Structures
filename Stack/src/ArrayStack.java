public class ArrayStack<E> implements Stack<E> {

    /* ArrayStack<E>
     * void push(E) | O(1) 均摊
     * E pop() | O(1) 均摊
     * E peak() | O(1)
     * int getSize() | O(1)
     * boolean isEmpty() | O(1)*/

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
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

    // 入栈
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    // 出栈
    @Override
    public E pop() {
        return array.removeLast();
    }

    // 查看栈顶
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
