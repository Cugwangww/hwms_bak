package com.数组.除自身以外数组的乘积;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/18
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/product-of-array-except-self/description/
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[]pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i]=pre[i-1]*nums[i];
        }
        int[]last = new int[nums.length];
        last[nums.length-1] = 1;
        for (int i = nums.length-2; i >=0; i++) {
            last[i]=last[i+1]*nums[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre[i] * last[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
    }
}
