package com.battle.algorithm4;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度O(N*LogN)
 * 每次寻找最小数，然后放到待排序数组的起始位置
 * 思路:首先遍历数组所有元素，找到最小元素，并把最小元素放在起始位置
 *
 * 先调配出左右子数组，然后对于左右子数组进行排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 6, 8, 0, 43, 74};
        System.out.println(Arrays.toString(quickSort(nums)));

    }

    public static int[] quickSort(int[] nums) {
        int len = nums.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {//寻找最小的数
                    minIndex = j;//将最小的数索引保存
                }
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static void quickSort_1(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort_1(array, begin, pivot - 1);
        quickSort_1(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        //pivot:标杆位置，counter:小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }
}
