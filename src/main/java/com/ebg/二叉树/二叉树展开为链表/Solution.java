package com.ebg.二叉树.二叉树展开为链表;

import com.ebg.二叉搜索树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/8/3
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                list.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left=null;
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        flatten(new TreeNode(5,new TreeNode(4),new TreeNode(6)));
    }
}
