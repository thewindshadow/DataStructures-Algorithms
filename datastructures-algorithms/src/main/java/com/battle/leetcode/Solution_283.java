package com.battle.leetcode;

import java.util.Arrays;

/**
 * 283.移动零
 * 给定一个数组nums,编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入：[0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution_283 {


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        solution_1(nums);
//        System.out.println("last =" + Arrays.toString(nums));
//        solution_2(nums);
//        System.out.println("last =" + Arrays.toString(nums));

//        solution_3(nums);
//        System.out.println("last =" + Arrays.toString(nums));

        solution_4(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 思路：不等于0的数和等于0的数交换位置
     * [1, 0, 0, 3, 12]
     * [1, 3, 0, 0, 12]
     * [1, 3, 12, 0, 0]
     *
     * @param nums
     */
    private static void solution_1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    /**
     * 思路：使用一个变量记录非零的数字，nums.length - lastNonZeroFoundAt=就等于0的数字。
     */
    private static void solution_2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
//                nums[lastNonZeroFoundAt] = nums[i];
//                lastNonZeroFoundAt ++;
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    private static void solution_3(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }

        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void solution_4(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                System.out.println(Arrays.toString(nums));
            }
        }
    }

//
}
