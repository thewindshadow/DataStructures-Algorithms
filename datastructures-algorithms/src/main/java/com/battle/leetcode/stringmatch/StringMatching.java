package com.battle.leetcode.stringmatch;

/**
 * 字符串匹配算法
 */
public class StringMatching {


    /**
     * 暴力法
     */
    public static int forceSearch(String txt, String pat) {
        int M = txt.length();
        int N = pat.length();

        for (int i = 0; i < M; i++) {
            int j;
            for (j = 0; j < N; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == N) {
                return i;
            }
        }
        return -1;
    }
}
