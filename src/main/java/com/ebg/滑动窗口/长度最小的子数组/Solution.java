package com.ebg.滑动窗口.长度最小的子数组;

/**
 *
 * @description
 * @date 2024/8/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/2VG8Kg/description/
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int size = nums.length;
        int res = size+1;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            while (sum>=target){
                res = Math.min(res,i-left+1);
                sum-=nums[left++];
            }
        }
        return res<=size?res:0;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(5,new int[]{1,2,3,4}));
    }

}
