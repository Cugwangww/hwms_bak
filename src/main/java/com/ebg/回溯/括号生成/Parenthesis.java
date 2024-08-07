package com.ebg.回溯.括号生成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class Parenthesis {

  /**
   * https://leetcode.cn/problems/generate-parentheses/description/
   *
   * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
   * @param n
   * @return
   */
    public static List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      generate(0,0,n,res,"");
      return res;
    }

    public  static void generate(int left, int right, int max, List<String> res,String s) {
        if(left == max && right ==max){
          res.add(s);
          return;
        }
        if(left<max){
          generate(left+1,right,max,res,s+"(");
        }
        if(right<left){
          generate(left,right+1,max,res,s+")");
        }
      }

    public static void main(String[] args) {
      System.out.println(generateParenthesis(2));
    }
}
