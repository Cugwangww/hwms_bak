package com.ebg.滑动窗口.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/sliding-window-maximum/solutions/?envType=study-plan-v2&envId=top-100-liked
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * @return
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        //peekLast(): 获取队尾元素但不移除，如果队列无元素，则返回null
        //peekFirst(): 获取队头元素但不移除，如果队列无元素，则返回null
        //pollLast(): 返回并移除队尾元素，如果队列无元素，则返回null
        //pollFirst(): 返回并移除队头元素，如果队列无元素，则返回null
        //offerLast(): 向队尾插入元素，如果插入成功返回true，否则返回false
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,-1},1));
    }
}
