package com.ebg.二叉树.二叉树的层序遍历;

import com.ebg.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
     *
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root ==null ){
            return res;
        }
        dfs(res,root,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, TreeNode root, int i) {
        if(res.size()==i){
            res.add(new ArrayList<>());
        }
        res.get(i).add(root.val);
        if(root.left!=null){
            dfs(res,root.left,i+1);
        }
        if(root.right!=null){
            dfs(res,root.right,i+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        List<List<Integer>> lists = levelOrder(root);
    }
}
