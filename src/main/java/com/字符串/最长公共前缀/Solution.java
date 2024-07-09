package com.字符串.最长公共前缀;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/longest-common-prefix/description/
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String str = strs[0];
        for (int i = 0; i < strs.length-1; i++) {
            while (!strs[i].startsWith(str)){
                if(str.length()==0){
                    return "";
                }
                str = str.substring(0,str.length()-1);
            }
        }
        return str;
    }
}
