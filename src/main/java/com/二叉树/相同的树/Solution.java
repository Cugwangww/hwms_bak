package com.二叉树.相同的树;

import com.二叉搜索树.TreeNode;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/30
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/same-tree/description/
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
