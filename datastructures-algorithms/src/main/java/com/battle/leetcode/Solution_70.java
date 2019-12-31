package com.battle.leetcode;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * <p>
 * 思路；
 * 1：1
 * 2：2
 * 3：f(1) + f(2)
 * 4: f(2) + f(3)
 */
public class Solution_70 {


    public static void main(String[] args) {
        int i = solution_70(4);
        System.out.println("i = " + i);
    }

    /**
     * O(n)的时间复杂度
     * 使用recursion的时间复杂度是O(N^2)
     * @param a
     * @return
     */
    public static int solution_70(int a) {
        if (a <= 2) return a;
        int first = 0, second = 1;
        for (int i = 0; i < a; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

}
