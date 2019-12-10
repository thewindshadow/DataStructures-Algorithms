package com.battle.stack;

import com.battle.arrays.Array;

public class ArraysStack<E> implements Stack<E> {

    Array<E> array;

    public ArraysStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArraysStack() {
        this.array = new Array<>();
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

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArraysStack<Integer> stack = new ArraysStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println("stack = " + stack);
        }
        stack.pop();
        System.out.println("stack = " + stack);

    }
}
