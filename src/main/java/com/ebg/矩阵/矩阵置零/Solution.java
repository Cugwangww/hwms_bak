package com.ebg.矩阵.矩阵置零;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/8/14
 */
public class Solution {


    /**
     * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int clo = matrix[0].length;
        boolean[] r = new boolean[row];
        boolean[] c = new boolean[clo];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if(matrix[i][j]==0){
                    r[i]=true;
                    c[j]=true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (r[i] || c[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
