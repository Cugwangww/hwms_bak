package com.ebg.二叉树.层序遍历;

import com.ebg.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @date 2024/8/1
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        dfsOrder(root,res,0);
        return res;
    }

    private static void dfsOrder(TreeNode root, List<List<Integer>> res, int level) {
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        if(root!=null){
            res.get(level).add(root.val);
        }else {
            return;
        }
        if(root.left!=null){
            dfsOrder(root.left, res, level+1);
        }
        if(root.right!=null){
            dfsOrder(root.right, res, level+1);
        }
    }
}
