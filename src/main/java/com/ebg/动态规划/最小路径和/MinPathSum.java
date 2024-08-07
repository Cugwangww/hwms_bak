package com.ebg.动态规划.最小路径和;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class MinPathSum {


    /**
     * https://leetcode.cn/problems/0i0mDW/description/
     *
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：一个机器人每次只能向下或者向右移动一步。
     *
     *输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i ==0 && j ==0){
                    continue;
                }else if(i ==0){
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }else if(j==0){
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][]test = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(test));
    }

}
