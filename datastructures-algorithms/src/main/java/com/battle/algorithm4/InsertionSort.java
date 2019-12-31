package com.battle.algorithm4;

import java.util.Arrays;

/**
 * 插入排序
 * 从前到后逐步构建有序序列；对于未排序数据，
 * 在已排序序列中从后向前扫描，找到相应位置并插入
 */
public class InsertionSort {


    public static void main(String[] args) {
        int[] nums = {20, 2, 10, 4, 3, 6, 5, 7, 8};
        System.out.println(Arrays.toString(insertionSort(nums)));
    }

    public static int[] insertionSort(int[] nums) {
        int len = nums.length;
        int preIndex, current;
        for (int i = 0; i < len; i++) {
            preIndex = i - 1;
            current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
        return nums;
    }


}
