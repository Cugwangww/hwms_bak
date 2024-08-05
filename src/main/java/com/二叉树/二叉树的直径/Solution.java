package com.二叉树.二叉树的直径;

import com.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/31
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param root
     * @return
     */
    private static int ans;
    private static List<List<Integer>> res = new ArrayList<>(100);

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode root) {
        if (root==null){
            return -1;
        }
        int left = dfs(root.left)+1;
        int right = dfs(root.right)+1;
        ans = Math.max(ans,left+right);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        diameterOfBinaryTree(new TreeNode(2,new TreeNode(3),new TreeNode(4)));
    }
}
