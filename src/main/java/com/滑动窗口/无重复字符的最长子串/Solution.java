package com.滑动窗口.无重复字符的最长子串;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @return
     */

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] last =new int[128];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start,last[index]);
            res = Math.max(res,i-start+1);
            last[index]=i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcad"));
    }
}
