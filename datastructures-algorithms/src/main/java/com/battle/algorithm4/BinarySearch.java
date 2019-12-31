package com.battle.algorithm4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * The
 */
public class BinarySearch {

    /**
     * Return the index of the specified key in the specified array.
     * @param a the array of integers,must be sorted in ascending order
     * @param key  the search key
     * @return
     */
    public static int indexOf(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 45, 6, 5, 9, 10, 3};
        Arrays.sort(array);
        System.out.println("array = " + Arrays.toString(array));
        int index = indexOf(array, 3);
        System.out.println("index = " + index);


    }


}
