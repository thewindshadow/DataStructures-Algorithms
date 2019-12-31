package com.battle.leetcode;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class Solution_5 {

    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = LongestPalindromeSubStr(s);
        System.out.println("s1 = " + s1);
    }

    /**
     * 此代码有问题
     *
     * @param s
     * @return
     */
    private static String LongestPalindromeSubStr(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            str.append(chars[i]);
        }
        StringBuilder reverse = str.reverse();
        char[] reverseChars  = reverse.toString().toCharArray();
        StringBuilder palindromes = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == reverseChars[i]) {
                palindromes.append(chars[i]);
            }
        }
        return palindromes.toString();
    }
}
