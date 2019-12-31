package com.battle.algorithm4;

/**
 * 归并排序--分治（可以认为是快排的逆向操作）
 * 1、把长度为n的输入序列分成两个长度为n/2的子序列
 * 2、对这两个子序列分别采用归并排序
 * 3、将两个排序好的子序列合并成一个最终的排序序列
 *
 * 归并:先排序左右子数组，然后合并两个有序子数组
 */
public class MergeSort {

    public static void main(String[] args) {

    }


    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (left + right) >> 1;//(left+right)/2
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; //中间数组
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }
        //也可以用System.arraycopy(a,start1,b,start2,length)
    }
}
