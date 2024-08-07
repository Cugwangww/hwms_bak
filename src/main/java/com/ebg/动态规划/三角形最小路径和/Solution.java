package com.ebg.动态规划.三角形最小路径和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/triangle/description/
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        int res = dp[length-1][0];
        for (int i = 0; i < length; i++) {
            res = Math.min(res,dp[length-1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(-2,-3));
        System.out.println(minimumTotal(triangle));
    }
}
