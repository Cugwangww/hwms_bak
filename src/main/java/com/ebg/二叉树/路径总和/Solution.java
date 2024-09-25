package com.ebg.二叉树.路径总和;

import com.ebg.二叉搜索树.TreeNode;

/**
 *
 * @description
 * @date 2024/8/4
 */
public class Solution {

    public int pathSum(TreeNode root, long targetSum) {
        if(root==null){
            return 0;
        }
        int res = rootSum(root, targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    private int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if(root==null){
            return 0;
        }
        if(root.val==targetSum){
            ret++;
        }
        ret += rootSum(root.left,targetSum-root.val);
        ret += rootSum(root.right,targetSum-root.val);
        return ret;
    }
}
