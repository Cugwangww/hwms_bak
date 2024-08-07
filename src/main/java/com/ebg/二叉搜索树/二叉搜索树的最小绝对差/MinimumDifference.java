package com.ebg.二叉搜索树.二叉搜索树的最小绝对差;

import java.util.*;

import com.ebg.二叉搜索树.TreeNode;


/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class MinimumDifference {


  /**
   *
   * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
   *
   * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
   * 差值是一个正数，其数值等于两值之差的绝对值。
   * 中序遍历   然后取差值 栈的方式遍历
   * @param root
   * @return
   */
    public static int getMinimumDifference(TreeNode root) {
      Deque<TreeNode> stack = new LinkedList<>();
      List<Integer> list = new ArrayList<>();
      int abs = Integer.MAX_VALUE;
      while (root != null || !stack.isEmpty()){
        while (root!= null){
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root .right;
      }
        for (int i = 0; i < list.size()-1; i++) {
            abs = Math.min(abs,list.get(i+1)-list.get(i));
        }
      return abs;
    }
}
