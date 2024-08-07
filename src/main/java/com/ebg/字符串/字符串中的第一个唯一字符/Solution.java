package com.ebg.字符串.字符串中的第一个唯一字符;

import java.util.HashMap;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/first-unique-character-in-a-string/description/
     * @param 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * @return
     */
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length()-1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length()-1; i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
