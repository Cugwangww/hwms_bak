package com.ebg.二叉树.反转二叉树;

import com.ebg.二叉搜索树.TreeNode;

/**
 * @author author
 * @description
 * @date 2024/3/21
 */
public class InvertTree {

    /**
     * https://leetcode.cn/problems/UHnkqh/description/
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
     * 反转二叉树
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        invertTree(root);
    }
}
