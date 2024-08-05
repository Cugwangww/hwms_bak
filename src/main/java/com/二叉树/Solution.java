package com.二叉树;

import com.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/30
 */
public class Solution {

    /**
     * 中序遍历
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

    /**
     * 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root ==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res = Math.max(left,right)+1;
        return res;
    }

    /**
     * 反转二叉树
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

    public static boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue){
            return false;
        }
        return dfs(root.left,minValue, root.val)&&dfs(root.right, root.val,maxValue);
    }



    public static void main(String[] args) {
        System.out.println(isValidBST(new TreeNode(5,new TreeNode(4),new TreeNode(6,new TreeNode(3),new TreeNode(7)))));
    }
}