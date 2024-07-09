package com.数组.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/14
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/3sum/
     *编给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            int x = nums[i];
            if(i>0 && x==nums[i-1]){
                continue;
            }
            if(x + nums[i+1]+nums[i+2] >0){
                break;
            }
            if (x + nums[i - 2] + nums[i - 1] < 0) continue; // 优化二
            int j = i+1;
            int k = length-1;
            while (j<k){
                int sum = x + nums[j]+nums[k];
                if(sum==0){
                    list.add(Arrays.asList(x,nums[j],nums[k]));
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 跳过重复数字
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 跳过重复数字
                }else if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,2,3,4,-1,-2,-3}));
    }


}
