package com.ebg.回溯.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class Solution {

  /**
   * https://leetcode.cn/problems/generate-parentheses/description/
   *
   * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
   * @param n
   * @return
   */
    public static List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      dfs(0,0,n,res,"");
      return res;
    }

    private static void dfs(int left, int right, int n, List<String> res, String sb) {
        if(left == n && right ==n){
            res.add(new String(sb));
            return;
        }
        if(left<n){
            dfs(left+1,right,n,res,sb+"(");
        }
        if(right<left){
            dfs(left,right+1,n,res,sb+")");
        }
    }

    public static void main(String[] args) {
      System.out.println(generateParenthesis(2));
    }
}
