package com.ebg.二叉树;

import com.ebg.二叉搜索树.TreeNode;

import java.util.*;

/**
 *
 * @description
 * @date 2024/7/30
 */
public class Solution {

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root,res);
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if(root==null){
            return;
        }
        help(root.left,res);
        res.add(root.val);
        help(root.right,res);
    }

    /**
     * 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root ==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res = Math.max(left,right)+1;
        return res;
    }

    /**
     * 反转二叉树
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue){
            return false;
        }
        return dfs(root.left,minValue, root.val)&&dfs(root.right, root.val,maxValue);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int clo = matrix[0].length;
        boolean[] r = new boolean[row];
        boolean[] c = new boolean[clo];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if(matrix[i][j]==0){
                    r[i]=true;
                    c[j]=true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (r[i] || c[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        char[] chars = s.toCharArray();
        Deque<Character> stack= new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char cha = chars[i];
            if(map.containsKey(cha)){
                if(stack.isEmpty() || !stack.peek().equals(map.get(cha))){
                    return false;
                }else {
                    stack.pop();
                }
            }else{
                stack.push(cha);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("[{]"));
    }
}