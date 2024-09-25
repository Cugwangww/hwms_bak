package com.ebg.二叉树.将有序数组转换为二叉搜索树;

import com.ebg.二叉搜索树.TreeNode;

/**
 *
 * @description
 * @date 2024/8/2
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid-1);
        root.right = dfs(nums,mid+1,right);
        return root;
    }

}
