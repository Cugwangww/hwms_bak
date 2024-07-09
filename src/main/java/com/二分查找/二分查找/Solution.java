package com.二分查找.二分查找;

/**
 * @author author
 * @description
 * @date 2024/4/13
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/binary-search/
     */
    public static int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){
            int mid = left + ((right-left)>>1);
            if(nums[mid]>target){
                right=mid-1;
            }else if (nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
    }
}
