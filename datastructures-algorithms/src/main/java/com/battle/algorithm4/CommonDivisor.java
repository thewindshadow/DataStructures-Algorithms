package com.battle.algorithm4;

import java.util.Arrays;

/**
 * 求最大公约数
 * 计算两个非负数证书P和q最大公约数：若q是0，则最大公约数为p.否则，将p除以q得到余数r,
 * p和q的最大公约数即为q和r的最大公约数
 */
public class CommonDivisor {

    public static int gcd(int p, int q){
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {

        int gcd = gcd(4, 8);
        System.out.println("gcd = " + gcd);
        int[] arr = {3, 4, 6, 7, 9, 0};
        int[] revr = revr(arr);
        System.out.println(" = " + Arrays.toString(revr));
//        int[][] a ={[12}][21]};
//        mutilply();
    }

    /**
     * 数组反转
     * @param arr
     * @return
     */
    public static int[] revr(int arr[]){
        int length = arr.length;
        for (int i = 0; i < length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length-i-1]=temp;
        }
        return arr;
    }
    public static  int[][] mutilply(int[][] a,int[][] b ){
        int length = a.length;
        int[][] c = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    c[i][j] = a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
