package com.二叉搜索树.二叉树的最大深度;

import com.二叉搜索树.TreeNode;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/24
 */
public class MaxDepth {

    /**
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     * 深度优先遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
