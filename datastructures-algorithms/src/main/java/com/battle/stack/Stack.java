package com.battle.stack;

/**
 * <p> Define the operation interface of a stack
 * @param <E>
 * Created by William.z on 2019/09/10
 */
public interface Stack<E> {
    /**
     * <p>Gets the stack size
     * @return
     */
    int getSize();

    /**
     * <p>Whether the stack is emptyy
     * @return
     */
    boolean isEmpty();

    /**
     * <p> Add an element to the stack
     * @param e
     */
    void push(E e);

    /**
     * <p>Delete top element
     * @return
     */
    E pop();

    /**
     * <p> View the top element of the stack
     * @return
     */
    E peek();
}
