package com.battle.parentheses;

import java.util.Stack;

/**
 * 给定一个只包括“(",")","{","}","[","]”的字符串，判断字符串是否有效
 * 括号必须以正确的顺序关系，“() [] {}” 是有效的但是“{]” 和“[{)]” 不是
 */
public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && c == '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str ="[({})]";
        boolean valid = isValid(str);
        System.out.println("valid = " + valid);
        String str1 ="[(})]";
        boolean valid1 = isValid(str1);
        System.out.println("valid1 = " + valid1);
    }
}
