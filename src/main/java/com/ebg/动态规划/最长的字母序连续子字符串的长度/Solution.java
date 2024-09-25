package com.ebg.动态规划.最长的字母序连续子字符串的长度;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/
     *字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
     * 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
     * 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
     * @return
     */
    public int longestContinuousSubstring(String s) {
        char[] chars = s.toCharArray();
        int [] dp = new int[chars.length];
        int res = 1;
        dp[0]=1;
        for (int i = 1; i < chars.length; i++) {
            int index = chars[i];
            int index1 = chars[i-1];
            if((index-index1)==1){
                dp[i] = dp[i-1]+1;
            }else {
                dp[i] = 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
