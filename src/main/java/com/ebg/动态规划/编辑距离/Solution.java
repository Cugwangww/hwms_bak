package com.ebg.动态规划.编辑距离;

/**
 *
 * @description
 * @date 2024/7/16
 */
public class Solution {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * 你可以对一个单词进行如下三种操作：
     * 删除一个字符
     * 替换一个字符
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        int[][] arr = new int[m+1][n+1];
        for (int i = 1; i <= n; i++) {
            arr[0][i] = i;
        }
        for (int j = 0; j < m; j++) {
            arr[j+1][0] = j+1;
            for (int i = 0; i < n; i++) {
                arr[j+1][i+1] = chars1[j]==chars2[i]?arr[j][i]:
                        Math.min(Math.min(arr[j][i+1],arr[j+1][i]),arr[j][i])+1;
            }
        }
        return arr[m][n];
    }
}
