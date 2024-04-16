package com.贪心算法.卖卖股票;

/**
 * @author author
 * @description
 * @date 2024/4/10
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
     *
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        if(prices.length<=1){
            return sum;
        }
        for (int i = 1; i < prices.length-1; i++) {
            if(prices[i]>prices[i-1]){
                sum += (prices[i]-prices[i-1]);
            }
        }
        return sum;
    }
}
