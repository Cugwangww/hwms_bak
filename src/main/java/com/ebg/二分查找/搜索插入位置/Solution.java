package com.ebg.二分查找.搜索插入位置;

/**
 *
 * @description
 * @date 2024/7/11
 */
public class Solution {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                if(mid==left){
                    return left;
                }
                right = mid;
            }else if(nums[mid]<target){
                if(mid==right){
                    return right+1;
                }
                left = mid+1;
            }
        }
        return 0;
    }


    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //左边有序 右边无序
            if(nums[mid]>nums[right]){
                if(nums[mid]>target && target>nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            //右边有序 左边无序
            if(nums[left]>nums[mid]){
                if(nums[right]>=target&&target>nums[mid]){
                    left = mid +1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1},0));
    }
}
