package com.二分查找.在排序数组中查找元素的第一个和最后一个位置;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/17
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-100-liked
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int first = -1,last=-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                first = mid;
                right = mid-1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        left = 0;
        right = nums.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                last = mid;
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        return new int[]{first,last};
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10},8));
    }
}
