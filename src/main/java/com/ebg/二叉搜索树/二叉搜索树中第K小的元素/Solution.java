package com.ebg.二叉搜索树.二叉搜索树中第K小的元素;

import com.ebg.二叉搜索树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @description
 * @date 2024/8/3
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param root
     * @param k
     * @return
     */

    private static int count =0;
    private static int res =0;

    public static int kthSmallest(TreeNode root, int k) {
        help(root,k);
        return res;
    }

    private static void help(TreeNode root,  int k) {
        if(root==null){
            return;
        }
        help(root.left,k);
        count++;
        if(count==k){
            res = root.val;
            return;
        }
        help(root.right,k);
    }

    public static int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root!=null || !stack.isEmpty()){
             while (root!=null){
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             k--;
             if(k==0){
                 break;
             }
            root = root.right;
        }

        return root.val;
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest1(new TreeNode(5,new TreeNode(4),new TreeNode(6)),3));
    }
}
