package com.battle.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * leetcode 125
 */
public class Solution_125 {

    public static void main(String[] args) {

    }


    public boolean isPalindrome(String s){
        //高层次(主干) 逻辑。
        //1. filter out number & char:2 .reverse and compare
        String filteredS = _filterNonNumberAndChar(s);
        return _reverseString(filteredS).equalsIgnoreCase(filteredS);
    }

    private String _reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String _filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]","");
    }


}
