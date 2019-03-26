# Data-Structures
使用 Java 实现一些基本数据结构

+ [Array](#Array)
+ [LinkedList](#LinkedList)
+ [Stack](#Stack)
  + [ArrayStack](#ArrayStack)
  + [LinkedListStack](#LinkedListStack)
+ [Queue](#Queue)
  + [ArrayQueue](#ArrayQueue)
  + [LinkedListQueue](#LinkedListQueue)
  + [LoopQueue](#LoopQueue)
+ [Binary Search Tree](#Binary-Search-Tree)

## Array
#### 构造器

```java
public Array(int capacity);	// 带参构造器，传入数组初始化容量
public Array();	// 无参构造器，默认数组容量为10
```

#### 方法

| 方法                                 | 详解                                                     |
| ------------------------------------ | -------------------------------------------------------- |
| `public int getSize()`               | 返回数组中的元素个数                                     |
| `public int getCapacity()`           | 获取数组的容量                                           |
| `public boolean isEmpty()`           | 返回数组是否为空                                         |
| `public void addLast(E e)`           | 向所有元素后添加一个新元素                               |
| `public void addFirst(E e)`          | 向所有元素前添加一个新元素                               |
| `public void add(int index, E e)`    | 在第 index 个位置插入一个新元素 e                        |
| `public E get(int index)`            | 获取 index 索引位置的元素                                |
| `public E getFirst()`                | 获取第一个元素                                           |
| `public E getLast()`                 | 获取最后一个元素                                         |
| `void set(int index, E e)`           | 修改 index 索引位置的元素为 e                            |
| `public boolean contains(E e)`       | 查找数组中是否有元素 e                                   |
| `public int find(E e)`               | 查找数组中元素e的索引，如果不存在元素e，则返回-1         |
| `public Array<Integer> findAll(E e)` | 查找数组中所有元素e的索引，如果不存在元素e，则返回空数组 |
| `public E remove(int index)`         | 从数组中删除index位置的元素，返回删除的元素              |
| `public E removeFirst()`             | 从数组中删除第一个元素，返回删除的元素                   |
| `public E removeLast()`              | 从数组中删除最后一个元素，返回删除的元素                 |
| `public void removeElement(E e)`     | 从数组中删除元素e                                        |
| `public String toString()`           | 转换为字符串                                             |



## LinkedList

#### 构造器

```java
public LinkedList();	// 构造一个空链表，带有虚拟头结点
```

#### 方法

| 方法                              | 详解                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| `public int getSize()`            | 获取链表中的元素个数                                         |
| `public boolean isEmpty()`        | 返回链表是否为空                                             |
| `public void add(int index, E e)` | 在链表的index(0-based)位置添加新的元素e（在链表中不是一个常用的操作，练习用） |
| `public void addLastR(E e)`       | 向链表尾部添加新的元素，递归做法                             |
| `public void addFirst(E e)`       | 在链表头添加新的元素e                                        |
| `public void addLast(E e)`        | 在链表末尾添加新的元素e                                      |
| `public E get(int index)`         | 获得链表的第index(0-based)个位置的元素（在链表中不是一个常用的操作，练习用） |
| `public E getFirst()`             | 获得链表的第一个元素                                         |
| `public E getLast()`              | 获得链表的最后一个元素                                       |
| `public boolean contains(E e)`    | 查找链表中是否有元素e                                        |
| `public boolean containsR(E e)`   | 查找链表中是否有元素e，递归做法                              |
| `public E remove(int index)`      | 从链表中删除index(0-based)位置的元素，返回删除的元素（在链表中不是一个常用的操作，练习用） |
| `public E removeFirst()`          | 从链表中删除第一个元素，返回删除的元素                       |
| `public E removeLast()`           | 从链表中删除最后一个元素，返回删除的元素                     |
| `public String toString()`        | 转换为字符串                                                 |



## Stack

#### 栈接口

```java
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
```

#### 方法

| 方法                | 详解               |
| ------------------- | ------------------ |
| `int getSize()`     | 获取栈中的元素个数 |
| `boolean isEmpty()` | 判断栈是否为空     |
| `void push(E e)`    | 入栈               |
| `E pop()`           | 出栈               |
| `E peek()`          | 查看栈顶元素       |



### ArrayStack

```java
public class ArrayStack<E> implements Stack<E>
```

#### 构造器

```java
public ArrayStack(int capacity);	// 带参构造器，传入数组栈的容量
public ArrayStack();	// 无参构造器，默认数组栈容量为10
```

#### 方法

| 方法                       | 详解                 |
| -------------------------- | -------------------- |
| @Override methods          | 实现接口中的所有方法 |
| `public int getCapacity()` | 获取数组栈的容量     |
| `public String toString()` | 转换为字符串         |



### LinkedListStack

```java
public class LinkedListStack<E> implements Stack<E>
```

#### 构造器

```java
public LinkedListStack();
```

#### 方法

| 方法                       | 详解                 |
| -------------------------- | -------------------- |
| @Override methods          | 实现接口中的所有方法 |
| `public String toString()` | 转换为字符串         |



## Queue

#### 队列接口

```java
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
```

#### 方法

| 方法                | 详解                 |
| ------------------- | -------------------- |
| `int getSize()`     | 获取队列中的元素个数 |
| `boolean isEmpty()` | 判断队列是否为空     |
| `void enqueue(E e)` | 入队                 |
| `E dequeue()`       | 出队                 |
| `E getFront()`      | 查看队首             |



### ArrayQueue

```java
public class ArrayQueue<E> implements Queue<E> 
```

#### 构造器

```java
public ArrayQueue(int capacity);	// 带参构造器，传入数组队列的容量
public ArrayQueue();	// 无参构造器，默认数组队列容量为10
```

#### 方法

| 方法                       | 详解                 |
| -------------------------- | -------------------- |
| @Override methods          | 实现接口中的所有方法 |
| `public int getCapacity()` | 获取数组队列的容量   |
| `public String toString()` | 转换为字符串         |



### LinkedListQueue

```java
public class LinkedListQueue<E> implements Queue<E>
```

#### 构造器

```java
public LinkedListQueue();
```

#### 方法

| 方法                     | 详解                 |
| ------------------------ | -------------------- |
| @Override methods        | 实现接口中的所有方法 |
| public String toString() | 转换为字符串         |



### LoopQueue

```java
public class LoopQueue<E> implements Queue<E>
```

#### 构造器

```java
public LoopQueue(int capacity);		// 带参构造器，传入循环队列的容量
public LoopQueue();		// 无参构造器，默认循环队列容量为10
```

#### 方法

| 方法                       | 详解                 |
| -------------------------- | -------------------- |
| @Override methods          | 实现接口中的所有方法 |
| `public int getCapacity()` | 获取循环队列的容量   |
| `public String toString()` | 转换为字符串         |



## Binary Search Tree 

#### 构造器

```java
public BST()
```

#### 方法

| 方法                           | 详解                                             |
| ------------------------------ | ------------------------------------------------ |
| `public int size()`            | 获取二分搜索树中的元素个数                       |
| `public boolean isEmpty()`     | 判断二分搜索树是否为空                           |
| `public void add(E e)`         | 向二分搜索树中添加新的元素e                      |
| `public boolean contains(E e)` | 判断二分搜索树中是否包含元素e                    |
| `public void preOrder()`       | 二分搜索树的前序遍历（深度优先遍历），递归写法   |
| `public void preOrderNR()`     | 二分搜索树的前序遍历（深度优先遍历），非递归写法 |
| `public void inOrder()`        | 二分搜索树的中序遍历（深度优先遍历）             |
| `public void postOrder()`      | 二分搜索树的后序遍历（深度优先遍历）             |
| `public String toString()`     | 转换为字符串                                     |

