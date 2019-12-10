package com.battle.arrays;

import java.util.ArrayList;

/**
 * Description: Custom array operations
 * Algorithm complexity：O(1),O(n),O(lgn),O(nlogn),O(n^2)
 * Created by William.z on 2019/09/09
 */
public class Array<E> {

    //An array of data to store
    private E[] data;
    //The size of the array
    private int size;

    /**
     * Description:
     * Constructor, the capacity of the array passed in to construct the Array
     *
     * @param capacity Specify the capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Description:
     * Unreferenced constructor, default array capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * Description:
     * Gets the number of elements in the array
     */
    public int getSize() {
        return size;
    }

    /**
     * Description:
     * Gets the capacity of the array
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Description: Whether the array is empty
     *
     * @return true:Indicates that there are no elements in the array
     * false:Indicates that there are elements in the array
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Description: Add a new element to all elements
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * Description: Add an element at the first position in the array
     *
     * @param e 新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Adds a new element at the specified index location
     *
     * @param index Adds the index location of the element
     * @param e     new element
     */
    public void add(int index, E e) {


        //The index of the array starts at 0, so the index array must be greater than or equal to 0,
        //and the index is greater than size to prevent wasted space in the array
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed . Required index >= 0 and index < size");
        }
        if (size == data.length)
            resize(data.length * 2);
        //i>=index,Also contains the location element for the current specified index moved backwards
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * Expansion capacity
     *
     * @param capacity Specify the expansion size
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Description: Checks to see if the current element is included in the array
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description : Looks at the index of the element e in the array and returns -1 if it does not exist
     *
     * @param e Found element
     * @return Returns the index value of the element
     */
    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Description: Query data through the index
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * Description: Gets the first element from the array
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Description:Gets the last element from the array
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Description: Deletes the element at index from the array and returns the deleted element
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //Halved array capacity
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * Change the element at the index location to e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * Description ：Deletes the first element in the array and returns the element value
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Description: Removes the last element from the array, returning the deleted element
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Description : Removes the element from the array
     *
     * @param e Removes the element
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d ,capacity = %d \n ", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (!(i == size - 1)) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        boolean contains = arr.contains(100);
        System.out.println(contains);
        int find = arr.find(9);
        System.out.println(find);
        Array<Integer> str = new Array<>();
        for (int i = 0; i < 10; i++) {
            str.addLast(i);
        }
        str.addLast(0);
        System.out.println(str);
        str.removeElement(0);
        System.out.println(str);

    }
}
