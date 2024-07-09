package com.动态规划.最长回文子串;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked
     *给你一个字符串 s，找到 s 中最长的
     * 回文
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        char[] str = s.toCharArray();
        int length = str.length;
        boolean dp[][]=new boolean[length][length];
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < length; i++) {
            dp[i][i]=true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if(str[i]!=str[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        longestPalindrome("abcd");
    }
}
