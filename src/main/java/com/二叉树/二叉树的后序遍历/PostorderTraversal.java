package com.二叉树.二叉树的后序遍历;

import com.二叉搜索树.TreeNode;

import java.util.*;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/26
 */
public class PostorderTraversal {
    /**
     *https://leetcode.cn/problems/binary-tree-postorder-traversal/solutions/431066/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/
     *
     * 二叉树的前序遍历 一种是递归调用 一种是维护一个栈
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root,res);
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if(root==null){
            return;
        }
        help(root.left,res);
        help(root.right,res);
        res.add(root.val);
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        preorderTraversal1(root);
    }

}
