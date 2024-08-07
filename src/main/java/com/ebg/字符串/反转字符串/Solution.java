package com.ebg.字符串.反转字符串;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/reverse-string/
     * 输出："fl"
     * @return
     */
    public void reverseString(char[] s) {
        if(s.length==0){
            return;
        }
        for (int i = 0,j=s.length-1; i <j ; i++,j--) {
            char tep = s[i];
            s[i] = s[j];
            s[j] = tep;
        }
    }
}
