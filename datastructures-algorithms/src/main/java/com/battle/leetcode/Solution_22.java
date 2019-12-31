package com.battle.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * left 随便加，只要超标
 * right 左个数>右个数
 */

public class Solution_22 {

    private List<String> result;

    public static void main(String[] args) {
        Solution_22 solution_22 = new Solution_22();
        System.out.println(solution_22.generateParenthesis(5));
    }

    private List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            return;
        }
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            _generate(left, right + 1, n, s + ")");
        }
    }

}
