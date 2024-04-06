package com.二叉搜索树.验证二叉搜索树;

import com.二叉搜索树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class IsValidBST {


  /**
   *
   * https://leetcode.cn/problems/validate-binary-search-tree/
   *
   * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
   * 有效 二叉搜索树定义如下：节点的左子树只包含 小于 当前节点的数。
   * 节点的右子树只包含 大于 当前节点的数。
   * 所有左子树和右子树自身必须也是二叉搜索树。
   * @param root
   * @return
   */
  public boolean isValidBST(TreeNode root) {
      return isValidBSTTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
  }

  /**
   * 递归方式
   * @param root
   * @param minValue
   * @param maxValue
   * @return
   */
  private boolean isValidBSTTree(TreeNode root, long minValue, long maxValue) {
    if(root ==null){
      return true;
    }
    if(root.val<=minValue || root.val>=maxValue){
      return false;
    }
    return isValidBSTTree(root.left,minValue, root.val)&&isValidBSTTree(root.right, root.val, maxValue);
  }

    public boolean isValidZXBST(TreeNode root) {
      double inorder = Long.MIN_VALUE;
      Deque<TreeNode> stack = new LinkedList<TreeNode>();
      while (!stack.isEmpty() || root!=null){
        while (root != null) {
          stack.push(root);
          root = root.left;
        }
        // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
        if (root.val <= inorder) {
          return false;
        }
        inorder = root.val;
        root = root.right;
      }
      return true;
    }
}
