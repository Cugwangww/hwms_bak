package com.ebg.二叉树.二叉树的右视图;

import com.ebg.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @date 2024/8/2
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0);
        return list;
    }

    private static void dfs(TreeNode root, List<Integer> list,int level) {
        if(root!=null){
            if(list.size()==level){
                list.add(root.val);
            }
        }else {
            return;
        }
        if(root.right!=null){
            dfs(root.right,list,level+1);
        }
        if(root.left!=null){
            dfs(root.left,list,level+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(rightSideView(new TreeNode(5,new TreeNode(4),new TreeNode(6))));

    }
}
