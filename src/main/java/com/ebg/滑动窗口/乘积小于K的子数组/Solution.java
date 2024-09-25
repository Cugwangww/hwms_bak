package com.ebg.滑动窗口.乘积小于K的子数组;

/**
 *
 * @description
 * @date 2024/8/14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/subarray-product-less-than-k/description/
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int ans = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod>=k){
                prod /= nums[left++];
            }
            ans += right-left +1;
        }
        return ans;
    }

}
