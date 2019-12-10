package com.battle.linked;

public class LinkedList<E> {

    private class Node {
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *  在链表的index(0-based)位置添加新的元素e
     * 第一步:先找到index前一个节点pre
     * 第二步:然后当前节点的下一个指针指向index前一个节点pre的后一个节点
     * 第三步:最后把index前一个节点的指针指向当前新增的节点
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail .Illegal index");
        }
        //虚拟头节点
        Node prev = dummyHead;
        //找寻index前一个节点的索引
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
        //把当前新增元素的下一个指针指向插入index前一个节点的后面一个节点
//            node.next = pre.next;
        //插入index前一个节点执行当前插入的节点
//            pre.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头添加新元素e
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get fail .Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get fail .Illegal index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 删除链表的第index(0-based)个位置的元素为e
     * 第一步，找到待删除元素前一个元素
     * 第二步，把待删除元素前一个元素 的指针指向待删除元素 的后一个元素 。
     * 第三步，把删除元素返回，删除元素的下一个元素指针置空，脱离链表。
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove fail .Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            //存储待删除节点的前节点
            prev = prev.next;
        }
        //待删除的节点
        Node resNode = prev.next;
        //把待删除元素前一个元素的指针指向待删除的元素的后一个元素
        prev.next = resNode.next;
        //待删除的元素元素指针置空，脱离俩表
        resNode.next = null;
        size--;
        return resNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * 查找链表中是否由元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
////        while (cur != null) {
////            res.append(cur + "=>");
////            cur = cur.next;
////        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.addLast(777);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println("remove = " + linkedList);
        linkedList.removeFirst();
        System.out.println("removeFirst = " + linkedList);
        linkedList.removeLast();
        System.out.println("removeLast = " + linkedList);
    }
}
