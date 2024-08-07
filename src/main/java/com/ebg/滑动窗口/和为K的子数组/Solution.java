package com.ebg.滑动窗口.和为K的子数组;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @return
     */

    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int end = i;
            int sum = nums[i];
            while (end<=nums.length){
                if(sum==k){
                    ans++;
                    if(end==nums.length-1){
                        break;
                    }
                }else{
                    if(end==nums.length-1){
                        break;
                    }
                }
                sum +=nums[end+1];
                end++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
}
