package com.二叉搜索树.二叉树的最小深度;

import com.二叉搜索树.TreeNode;

/**
 * @author author
 * @description
 * @date 2024/3/24
 */
public class MinDepth {

    /**
     * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
     * 递归深度优先搜索求解，对于每一个节点，有三种情况： 1.没有子节点，当前节点深度为1； 2.有一个子节点，当前节点最小深度为单边子树的最小深度+1； 3.有两个子节点，当前节点的最小深度为两边子树的最小深度的最小值+1； 故有上述代码
     *
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int left = minDepth(root.left);
        int rigth = minDepth(root.right);
        if(left ==0 || rigth ==0){
            return Math.max(left,rigth)+1;
        }
        return Math.min(left,rigth)+1;
    }
}
