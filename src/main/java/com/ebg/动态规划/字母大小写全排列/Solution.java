package com.ebg.动态规划.字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/letter-case-permutation/description/
     *
     * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
     * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
     *
     * 输入：s = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        res.add(sub);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        list.add(s);
        for (int i = 0; i < chars.length; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                if(Character.isDigit(chars[i])){
                    String s1 = list.get(j);
                    String tep = genarate(s1,i);
                    list.add(tep);
                }
            }
        }

        return list;
    }

    private static String genarate(String s, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if(i==j){
                if (Character.isLetter(chars[i])) {
                    stringBuffer.append(Character.toUpperCase(chars[i]));
                } else {
                    stringBuffer.append(Character.toLowerCase(chars[i]));
                }
            }else {
                stringBuffer.append(chars[j]);
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("C"));
    }
}
