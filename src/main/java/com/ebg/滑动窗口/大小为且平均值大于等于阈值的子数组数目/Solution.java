package com.ebg.滑动窗口.大小为且平均值大于等于阈值的子数组数目;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
     * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
     * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
     * @return
     */

    public static int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum =0;
        for (int i = 0; i < k; i++) {
            sum+=arr[i];
        }
        int total =sum>=k*threshold?1:0;
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i]-arr[i-k];
            if(sum/k>=threshold){
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4));
    }
}
