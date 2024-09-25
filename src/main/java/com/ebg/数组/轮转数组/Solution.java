package com.ebg.数组.轮转数组;

/**
 *
 * @description
 * @date 2024/7/18
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
     * @param nums
     * @param k
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     *
     */
    public static int rotate(int[] nums, int k) {
        int n = nums.length;
        k %=n;
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[nums.length-1-i];
        }
        for (int j = nums.length-1; j >=0; j--) {
            if(j<k){
                nums[j] = res[k-j-1];
            }else{
                nums[j]=nums[j-k];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(rotate(new int[]{-1},2));
    }
}
