package com.ebg.贪心算法.跳跃游戏2;

/**
 * @author author
 * @description
 * @date 2024/4/10
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int end = 0;
        int step = 0;
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,i+nums[i]);
            if(i==end){
                end = max;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
}
