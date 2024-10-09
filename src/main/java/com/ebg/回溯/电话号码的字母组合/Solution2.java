package com.ebg.回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution2 {

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
        insertStr(digits,res,0,new StringBuilder());
        return res;
    }

    private void insertStr(String digits, List<String> res, int i, StringBuilder leter) {
        if(digits.length()==i){
            res.add(new String(leter));
            return;
        }
        int index = digits.charAt(i) - '0';
        String map = letter_map[index];
        for (int j = 0; j < map.length(); j++) {
            leter.append(map.charAt(j));
            insertStr(digits, res, i+1, leter);
            leter.deleteCharAt(leter.length()-1);
        }
    }
}
