public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    // 传入数组，构造成线段树
    public SegmentTree(E[] arr, Merger<E> merger) {

        this.merger = merger;

        data = (E[])new Object[arr.length];
        for (int i = 0 ; i < arr.length ; i ++) {
            data[i] = arr[i];
        }

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 在 treeIndex 的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){

        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        // 创建左子树
        buildSegmentTree(leftTreeIndex, l, mid);
        // 创建右子树
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    // 获取线段树的元素个数
    public int getSize(){
        return data.length;
    }

    // 获取索引为 index 的元素
    public E get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index){
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index){
        return 2 * index + 2;
    }
}
