package com.ebg.动态规划.最长公共子序列;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/longest-common-subsequence/solutions/696763/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
     *
     *给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * 是求最长公共子序列长度 不是输出最长公共子序列
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= col; j++) {
                char c2 = text2.charAt(j-1);
                if(c1==c2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        longestCommonSubsequence("abcd","ace");
    }
}
