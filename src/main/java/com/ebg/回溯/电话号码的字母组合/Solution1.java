package com.ebg.回溯.电话号码的字母组合;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution1 {

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

    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0 || digits ==null){
            return res;
        }
        iterStr(digits, new StringBuilder(), 0,res);
        return res;
    }

    private void iterStr(String digits, StringBuilder stringBuilder, int i,List<String> res) {
        if(i==digits.length()){
            res.add(new String(stringBuilder));
            return;
        }
        char c = digits.charAt(i);
        int pos = c - '0';
        String map_string = letter_map[pos];
        for (int j = 0; j < map_string.length(); j++) {
            stringBuilder.append(map_string.charAt(j));
            iterStr(digits,stringBuilder,i+1,res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

}
