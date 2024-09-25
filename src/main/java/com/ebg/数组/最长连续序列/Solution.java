package com.ebg.数组.最长连续序列;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @description
 * @date 2024/6/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/longest-consecutive-sequence/description/
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     */
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer res = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.getOrDefault(nums[i]-1,0) ;
            map.put(nums[i], value+1);
            res = Math.max(value+1,res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,3,4}));
    }
}
