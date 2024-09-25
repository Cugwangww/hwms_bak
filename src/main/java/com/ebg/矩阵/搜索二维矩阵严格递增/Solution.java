package com.ebg.矩阵.搜索二维矩阵严格递增;

/**
 *
 * @description
 * @date 2024/8/14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/search-a-2d-matrix/
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0,right= matrix.length*matrix[0].length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            int row = matrix[0].length;
            if(matrix[mid/row][mid%row]==target){
                return true;
            }else if(matrix[mid/row][mid%row]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}
