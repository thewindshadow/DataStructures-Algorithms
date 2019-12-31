package com.battle.leetcode;

import java.util.Arrays;

/**
 * 今天的题目是：二分法
 * arr是一组有序的数组，
 * （1）请找到target第一次出现的位置下标
 * （2）请找到target最后一次出现在数组中的位置下标
 * （3）如果target不存在数组中，返回-1
 */
public class BinaryArrays {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 3, 87, 4, 23};
        int i = binarySearch(arr, 5);
        System.out.println("i = " + i);
        int j = binarySearchFinally(arr, 5);
        System.out.println("j = " + j);
        Arrays.sort(arr);
        System.out.println(" 数组=" + Arrays.toString(arr));
        int k = binarySearchs(arr, 5);
        System.out.println("k = " + k);

        int q = binarySearch2(arr, 66);
        System.out.println("q = " + q);
    }

    /**
     * （1）请找到target第一次出现的位置下标
     *
     * @param arr    数组
     * @param target 在数组中查找的目标数字
     * @return 存在数组中则返回目标数字在数组中的下标，否则返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int flag = -1;
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }

        return flag;
    }

    /**
     * （2）请找到target最后一次出现在数组中的位置下标
     *
     * @param arr    数组
     * @param target 在数组中查找的目标数字
     * @return 存在数组中则返回目标数字在数组中的下标，否则返回-1
     */
    public static int binarySearchFinally(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int flag = -1;
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                flag = i;
            }
        }
        return flag;
    }

    /**
     * 请找到target第一次出现在数组中的位置下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchs(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    /**
     * 请找到target最后一次出现在数组中的位置下标
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch2(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                index = mid;
                low = mid + 1;
            }
        }
        return index;
    }
}
