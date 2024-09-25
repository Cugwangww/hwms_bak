package com.ebg.二叉树.二叉树中的最大路径和;

import com.ebg.二叉搜索树.TreeNode;

/**
 *
 * @description
 * @date 2024/8/5
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked
     * @param root
     * @return
     */
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left+right+root.val,ans);
        return Math.max(Math.max(left,right)+ root.val,0);
    }

    public static int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int sum = a+b;
        if(n<3){
            return n;
        }
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        dp[0]=0;
        for (int i = 1; i <= nums.length; i++) {
            if(i==1){
                dp[i] = nums[i-1];
            }else{
                dp[i] = Math.max(dp[i-2]+nums[i-1],dp[i-1]);
            }
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2}));
    }
}
