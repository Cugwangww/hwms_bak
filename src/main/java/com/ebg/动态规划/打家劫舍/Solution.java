package com.ebg.动态规划.打家劫舍;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/Gu0c2T/solutions/
     *一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][]dp = new int[nums.length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    public int rob1(int[] nums) {
        int length = nums.length;
        int[]dp = new int[length+1];
        int res = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i <=length ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
