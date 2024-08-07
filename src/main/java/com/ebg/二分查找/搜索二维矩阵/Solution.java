package com.ebg.二分查找.搜索二维矩阵;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {


    /**
     * https://leetcode.cn/problems/search-a-2d-matrix/description/
     *
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     * @param matrix
     * @param target
     * @return
     */
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix.length;
        int row = matrix[0].length;
        int left = 0;
        int right = col * row -1;
        while (left<=right){
            int mid = left + (right -left)/2;
            int num = matrix[mid/row][mid%row];
            if(num>target){
                right = mid-1;
            }else if(num<target){
                left = mid +1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] num = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
        System.out.println(searchMatrix1(num,3));
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
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
