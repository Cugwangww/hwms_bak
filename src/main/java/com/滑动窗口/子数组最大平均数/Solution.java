package com.滑动窗口.子数组最大平均数;

import java.util.Arrays;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/maximum-average-subarray-i/solutions/590322/zi-shu-zu-zui-da-ping-jun-shu-i-by-leetc-us1k/
     *
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     *
     * @param nums
     * @return
     */

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        int sumMax = sum;
        for (int i = 1; i < nums.length -k+1; i++) {
            sum = sum+nums[i+k]-nums[i];
            sumMax = Math.max(sum,sumMax);
        }
        return sum/k *1.0;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1},1));
    }
}
