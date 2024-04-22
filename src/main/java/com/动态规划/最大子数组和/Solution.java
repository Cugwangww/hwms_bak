package com.动态规划.最大子数组和;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/maximum-subarray/description/
     *
     *给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组是数组中的一个连续部分。
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
