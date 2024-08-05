package com.二叉树.对称二叉树;

import com.二叉搜索树.TreeNode;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/30
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
