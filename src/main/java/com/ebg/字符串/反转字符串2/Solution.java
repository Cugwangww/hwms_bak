package com.ebg.字符串.反转字符串2;

/**
 *
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/reverse-string-ii/
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i+=2*k) {
            int start = i;
            int end = Math.min(s.length()-1,i+k-1);
            while (start<end){
                char tep = s.charAt(start);
                chars[start]=chars[end];
                chars[end] = tep;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
