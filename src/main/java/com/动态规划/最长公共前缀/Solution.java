package com.动态规划.最长公共前缀;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
     *编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        String prefix = strs[0];
        int count = strs[0].length();
        for (int i = 1; i < count; i++) {
            prefix = longestCommon(prefix,strs[i]);
            if(prefix.length() ==0){
                break;
            }
        }
        return prefix;
    }

    private String longestCommon(String prefix, String str) {
        int length  = Math.min(prefix.length(),str.length());
        int index = 0;
        while (index<length && prefix.charAt(index) == str.charAt(index)){
            index++;
        }
        return prefix.substring(0,index);
    }

}
