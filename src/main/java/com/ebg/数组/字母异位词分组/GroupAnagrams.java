package com.ebg.数组.字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/14
 */
public class GroupAnagrams {

    /**
     *   https://leetcode.cn/problems/group-anagrams/description/
     *
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 示例
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * 示例 1:
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * 由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
     * 故可以将排序之后的字符串作为哈希表的键。
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String text = strs[i];
            char[] chars = text.toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(String.valueOf(chars))){
                map.get(String.valueOf(chars)).add(text);
            }else{
                List<String> list = new ArrayList<>();
                list.add(text);
                map.put(String.valueOf(chars),list);
            }
        }
        for (List<String> aaa: map.values()) {
            res.add(aaa);
        }
        return res;
    }

    public static void main(String[] args) {
        char char1 = 'A';
        int ascii = char1;
        System.out.println(ascii);
        System.out.println(4 << 16);
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }

}
