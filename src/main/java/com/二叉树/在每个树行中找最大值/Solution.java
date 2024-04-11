package com.二叉树.在每个树行中找最大值;

import com.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/4/9
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
     *
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     *
     * @param root
     * @return
     */
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res,0);
        return  res;
    }

    public static void dfs(TreeNode root, List<Integer> res, int i) {
        if(res.size()==i){
            res.add(root.val);
        }else{
            res.set(i,Math.max(res.get(i), root.val));
        }
        if(root.left!=null){
            dfs(root.left,res,i+1);
        }
        if(root.right!=null){
            dfs(root.right,res,i+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(3),new TreeNode(2));
        List<Integer> lists = largestValues(root);
    }
}
