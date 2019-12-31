package com.battle.leetcode;

import java.util.Arrays;

/**
 * 239.滑动窗口最大值
 * 给定一个数组nums,有一个大小为K得滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口K内的数字，滑动窗口每次只向右移动一位。
 * 示例：
 * 输入：nums=[1,3,-1,-3,5,3,6,7],和k=3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置            最大值
 * [1 3 -1] -3 5 3 6 7        3
 * 1 [3 -1 -3] 5 3 6 7        3
 * 1 3 [-1 -3 5] 3 6 7        5
 * 1 3 -1 [-3 5 3] 6 7        5
 * 1 3 -1 -3 [5 3 6] 7        6
 * 1 3 -1 -3 5 [3 6 7]        7
 */
public class SilidingWindow {


    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSilidingWindow(arr, 3);
        System.out.println("ints = " + Arrays.toString(ints));
    }


    /**
     * 1、遍历arr
     * 2、比较三个数，返回最大的元素保存在数组中
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] maxSilidingWindow(int[] arr, int k) {
        if (arr.length == 0 || k == 0)
            return null;
        int[] silidingMax = new int[6];
        for (int i = 0; i <= arr.length - k; i++) {
            int max = CompareAndReplace(arr[i], arr[i + 1], arr[i + 2]);
            silidingMax[i] = max;
        }
        return silidingMax;
    }

    private static int CompareAndReplace(int i, int j, int k) {
        if (i > j && i > k) {
            return i;
        } else if (j > k && j > i) {
            return j;
        } else {
            return k;
        }
    }

}
