package com.ebg.二叉树.另一棵树的子树;

import com.ebg.二叉搜索树.TreeNode;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/8/4
 */
public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val&&dfs(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }

    private boolean dfs(TreeNode node, TreeNode sub) {
        if(node == null || sub == null){
            return node == sub;
        }
        if(node.val != sub.val){
            return false;
        }
        return dfs(node.left, sub.left) && dfs(node.right, sub.right);
    }

    public static void main(String[] args) {

    }
}
