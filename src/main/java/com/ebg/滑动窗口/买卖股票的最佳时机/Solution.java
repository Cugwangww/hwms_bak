package com.ebg.滑动窗口.买卖股票的最佳时机;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/8/19
 */
public class Solution {

    /**
     *https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solutions/2464650/mei-ju-mai-chu-jie-ge-wei-hu-mai-ru-de-z-02ud/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ans;
    }
}
