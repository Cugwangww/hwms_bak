package com.二分查找.x平方根;

/**
 * @author author
 * @description
 * @date 2024/4/13
 */
public class Solution {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left =1;
        int right = x/2;
        if(x<=1){
            return x;
        }
        while (left<right){
            int mid = left + (right-left+1)/2;
            if(mid * mid < x){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}
