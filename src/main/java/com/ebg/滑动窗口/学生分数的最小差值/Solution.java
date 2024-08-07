package com.ebg.滑动窗口.学生分数的最小差值;

import java.util.Arrays;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
     *
     * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
     * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
     * 返回可能的 最小差值 。
     *
     * @param nums
     * @return
     */

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums[k-1]-nums[0];
        for (int i = 0; i < nums.length -k+1; i++) {
            res = Math.min(res,nums[i+k-1]-nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{1,2},22));
    }
}
