package com.ebg.数组.盛最多水的容器;

/**
 * @author author
 * @description
 * @date 2024/3/14
 */
public class LargestRectangleArea {

    /**
     * https://leetcode.cn/problems/container-with-most-water/description/
     *
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 双指针法 或者栈
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int abs = 0;
        for (int i = 0; i < n-1; i++) {
            int j = 0,k=i+1;
            while (j>0 && heights[j]>heights[i])j--;
            while (k<n-1&&heights[k]>heights[i])k++;
            int width = k-j +1;
            abs = Math.max(width*heights[i],abs);
        }
        return abs;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
