package com.ebg.滑动窗口.买卖股票的最佳时机3;

/**
 * @description
 * @date 2024/8/19
 */
public class Solution {

    /** 至多买卖两次
     *https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solutions/552695/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
