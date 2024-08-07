package com.ebg.动态规划.回文子串个数;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/palindromic-substrings/description/
     *给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     */
    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int lenth = chars.length;
        boolean dp[][] = new boolean[lenth][lenth];
        int result = 0;
        for (int i = lenth-1; i >0 ; i--) {
            for (int j = i; j < lenth; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if((j-i)<=1){
                        result++;
                        dp[i][j]=true;
                    }else if(dp[i+1][j-1]){
                        result++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
