package com.battle;

import java.util.Arrays;

public class CalculatorTest {

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 6, 7, 8};
        Arrays.sort(arr);
        reversion(arr);
        System.out.println(Arrays.toString(arr));

        int[][] data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(data);
        twoDArrayReversion(data);
        System.out.println(" ==reverse==");
        printArray(data);
        String sa = "12,12";
        String s = sa.split(",")[0];
        System.out.println("s = " + s);
    }

    /**
     * example:
     * 0 1 2 3 4 5
     * 5 1 2 3 4 0
     * 5 4 2 3 1 0
     * 5 4 3 2 1 0
     * <p>
     * 1.Original array
     * 2.The first element and the last element swap places
     * 3.The second element swaps places with the penultimate, and so on
     *
     * @param arr
     */
    public static void reversion(int[] arr) {
        int head = 0;
        int tail = arr.length - 1;
        int center = arr.length / 2;
        for (int i = 0; i < center; i++) {
            int temp = arr[head];
            arr[head++] = arr[tail];
            arr[tail--] = temp;
//            head ++;
//            tail --;
        }

    }

    /**
     * 2D array inversion
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * after reversion
     * 1 4 7
     * 2 5 8
     * 3 6 9
     * @param array
     */
    public static void twoDArrayReversion(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }

    public static void printArray(int[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
