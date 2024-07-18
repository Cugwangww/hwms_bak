package com.数组.移动零;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @Description TODO
 * @Author author
 * @Date 2024/3/20 22:21
 */

public class Solution {

    /**
     * https://leetcode.cn/problems/move-zeroes/
     *
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int size = nums.length, left = 0,right = 0;
        while(right < size){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] =0;
        }
    }

    /**
     * 暴力解法 超时
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                sum = Math.max(sum,Math.min(height[i],height[j])*(j-i));
            }
        }
        return sum;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int sum = 0;
        int left = 0,right = height.length-1;
        while (left<=right){
            sum = Math.max(sum,(right-left)*Math.min(height[right],height[left]));
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return sum;
    }

}
