package com.ebg.贪心算法.跳跃游戏;

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
    public boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>mx){
                return false;
            }
            mx = Math.max(mx,i+nums[i]);
        }
        return true;
    }
}
