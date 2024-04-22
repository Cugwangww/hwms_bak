package com.动态规划.三角形最小路径和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class SolutionDG {

    /**
     * https://leetcode.cn/problems/triangle/description/
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * 递归 + 记忆化搜索
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     */
    private static Integer[][] dp;

    public static int minimumTotal(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle,0,0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        if(i==triangle.size()){
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] = Math.min(dfs(triangle,i+1,j),dfs(triangle,i+1,j+1))+triangle.get(i).get(j);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(-2,-3));
        System.out.println(minimumTotal(triangle));
    }
}
