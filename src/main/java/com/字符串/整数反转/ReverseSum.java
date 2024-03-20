package com.字符串.整数反转;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/12
 */
public class ReverseSum {


    //
    // https://leetcode.cn/problems/reverse-integer/description/

    // 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    //如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

    public static int reverseSum(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans > 214748364 || ans < -214748364) return 0;
            int a = x % 10;
            ans = 10 * ans + a;
            x /= 10;
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(reverseSum(1534236461));
    }
}
