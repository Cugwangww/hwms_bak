package com.二叉树.二叉树中的最大路径和;

import com.二叉搜索树.TreeNode;

/**
 * @author wangweiwei22@hikvision.com.cn
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
}
