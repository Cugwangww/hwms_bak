package com.字符串.最后一个单词的长度;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/length-of-last-word/description/
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int count =0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)==' '){
                if(count==0){
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
