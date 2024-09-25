package com.ebg.动态规划.杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @date 2024/7/17
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                if(i==0||j==i)
                    sub.add(1);
                else
                    sub.add(list.get(j-1).get(i-1)+list.get(j-1).get(i));
            }
        }
        return list;
    }

    public static int maxSubArray(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0]=nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
