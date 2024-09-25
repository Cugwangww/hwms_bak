package com.ebg.矩阵.搜索二维矩阵行列递增;

/**
 *
 * @description
 * @date 2024/8/14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr:matrix) {
            if(search(arr,target)){
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] arr, int target) {
        boolean flag = false;
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (right+left)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return flag;
    }
}
