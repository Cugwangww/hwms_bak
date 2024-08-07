package com.ebg.二叉树.二叉树中序遍历;

import com.ebg.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/26
 */
public class InorderTraversal {
    /**
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
     * 二叉树的中虚遍历 一种是递归调用 一种是维护一个栈
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root,res);
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if(root==null){
            return;
        }
        help(root.left,res);
        res.add(root.val);
        help(root.right,res);
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        inorderTraversal1(root);
    }

}
