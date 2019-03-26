public class LinkedList<E> {

    /* LinkedList
     * 添加操作 O(n)
     * addLast(e) | O(n)
     * addFirst(e) | O(1)
     * add(index, e) | O(n/2) = O(n)
     * 删除操作 O(n)
     * removeLast(e) | O(n)
     * removeFirst(e) | O(1)
     * remove(index, e) | O(n/2) = O(n)
     * 修改操作 O(n)
     * set(int index, E e) | O(n)
     * 查找操作 O(n)
     * get(index) | O(n)
     * contains(e) | O(n)
     * 如果只对链表头进行增删查的操作则为O(1)
     * */

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用:)
    public void add(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;

        prev.next = new Node(e, prev.next);
        size ++;
    }

    // 向链表尾部添加新的元素，递归做法
    public void addLastR(E e) {
        dummyHead.next = addLastR(dummyHead.next, e);
    }

    private Node addLastR(Node node, E e) {
        if(node == null){
            size++;
            return new Node(e);
        }
        node.next = addLastR(node.next, e);
        return node;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用:)
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用:)
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 查找链表中是否有元素e，递归做法
    public boolean containsR(E e) {
        return containsR(dummyHead.next,e);
    }

    private boolean containsR(Node node, E e) {
        if(node == null){
            return false;
        }

        if(node.e.equals(e)){
            return true;
        } else {
            return containsR(node.next, e);
        }
    }

    // 从链表中删除index(0-based)位置的元素，返回删除的元素
    // 在链表中不是一个常用的操作，练习用:)
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        // Node cur = dummyHead.next;
        // while(cur != null) {
        // res.append(cur + "->");
        // cur = cur.next;
        // }
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }
}
