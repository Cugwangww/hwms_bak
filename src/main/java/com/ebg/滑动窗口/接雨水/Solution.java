package com.ebg.滑动窗口.接雨水;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author author
 * @description
 * @date 2024/4/10
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
     *
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int currWidth = i -left -1;
                int currHeight =  Math.min(height[left], height[i]) - height[top];
                ans += currHeight*currWidth;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,3,0,1,4}));
    }
}
