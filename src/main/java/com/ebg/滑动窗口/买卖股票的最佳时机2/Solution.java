package com.ebg.滑动窗口.买卖股票的最佳时机2;

/**
 *
 * @description
 * @date 2024/8/19
 */
public class Solution {

    /** 可以买卖多次
     *https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/476791/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][]dp = new int[prices.length][2];
        //卖
        dp[0][0]=0;
        //买
        dp[0][1]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            //卖
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //买
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]- prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
