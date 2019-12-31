package com.battle.leetcode;


import java.util.Stack;

/**
 * leetcode 20:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class Solution_20 {


    public static void main(String[] args) {
        String s = "({}[])";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
        boolean valid_1 = isValid_1(s);
        System.out.println("valid_1 = " + valid_1);

    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }

    public static boolean isValid_1(String s) {
        Stack<Integer> p = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if (q % 2 == 1) {
                if (p.isEmpty() || p.pop() != q - 1) return false;
            } else {
                p.push(q);
            }
        }
        return p.isEmpty();
    }


}
