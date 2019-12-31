package com.battle.leetcode;

/**
 * 11.盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 思路:
 * 一维数组的坐标变换！ i,j
 * 1.枚举: left bar x , right bar y ,(x-y)*height_diff
 * 时间复杂度 O(n^2)
 * 2. O(n) ,左右边界， i,j  ，向中间收敛：左右夹逼
 */
public class Solution_11 {


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = solution_maxArea(a);
        System.out.println("i = " + i);
        int i1 = solution_maxArea_1(a);
        System.out.println("i1 = " + i1);
        int i2 = solution_maxArea_2(a);
        System.out.println("i2 = " + i2);

    }


    public static int solution_maxArea(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; ++j) {
                int area = (j - 1) * Math.min(a[i], a[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }


    public static int solution_maxArea_1(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; ++j) {
                int area = (j - 1) * Math.min(a[i], a[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static int solution_maxArea_2(int[] nums) {
        int max = 0;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int minHeight = nums[i] < nums[j] ? nums[i++] : nums[j--];
            max = Math.max(max, (j - i + 1) + minHeight);
        }
        return max;
    }
}
