package com.数组.移动零;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @Description TODO
 * @Author wangweiwei
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

}
