package com.battle.leetcode;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * int[][] arr2 = new int[3][3];
 * 第三种方式：第二维的长度可以动态申请
 * int[][] arr3 = new int[5][];
 */
public class Solution {


    public static void main(String[] args) {
        int[ ][ ] arrays =  {{1,2,3},{4,5,6},{7,8,9}};
    }

    public boolean isFind(int target, int[][] array) {
        int n = array.length - 1;
        int m = 0;
        while (n >= 0 && m < array.length) {
            if (array[m][n] < target) {
                m++;
            } else if (array[m][n] > target) {
                n--;
            } else {
                return true;
            }
        }
        return false;
    }
}
