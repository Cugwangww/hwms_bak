package com.回溯.电话号码的字母组合;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
     *
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(StringUtils.isEmpty(digits)){
            return res;
        }
        generate(digits,0,res,"");
        return res;
    }

    private void generate(String digits, int i, List<String> res, String s) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(i == digits.length()){
            res.add(s);
            return;
        }
        String s1 = map.get(digits.charAt(i));
        for (int j = 0; j < s1.length(); j++) {
            generate(digits,i+1,res,s+s1.charAt(j));
        }
    }
}
