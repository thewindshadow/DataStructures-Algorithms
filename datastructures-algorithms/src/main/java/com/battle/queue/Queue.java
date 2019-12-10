package com.battle.queue;


public interface Queue<E> {


    /**
     * 获取队列大小
     *
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 往队列中添加元素
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 往队列中取队首元素
     *
     * @return
     */
    E dequeue();

    /**
     * 获取队列从第一个元素
     *
     * @return
     */
    E getFront();

}
