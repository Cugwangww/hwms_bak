package com.ebg.排序.冒泡排序;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * 冒泡排序
     * @param arr
     * @return arr
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
