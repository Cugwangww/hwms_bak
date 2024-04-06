package com.动态规划.爬楼梯;

/**
 * @author author
 * @description
 * @date 2024/3/21
 */
public class ClimbStairs {

    /**
     * https://leetcode.cn/problems/climbing-stairs/description/
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int p =0,q=0,r=1;
        for (int i = 1; i <=n ; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
