package com.ebg.二分查找.有效的完全平方数;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/valid-perfect-square/description/
     *
     *给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     * 不能使用任何内置的库函数，如  sqrt 。
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        int index = 1;
        while (index * index <= num){
            if(index * index ==num){
                return true;
            }
            index ++;
        }
        return false;
    }

    public static boolean isPerfectSquareErFen(int num) {
        int left = 1;
        int right = num;
        while (left < right){
            int mid = (right-left)/2 + left;
            if(mid * mid > num){
                right = mid -1;
            }else if(mid * mid < num){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        isPerfectSquareErFen(14);
    }
}
