package com.ebg.矩阵.旋转图像;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/8/14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
