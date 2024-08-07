package com.ebg.回溯.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/subsets/solutions/420294/zi-ji-by-leetcode-solution/
     *
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
     * （幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     * @param nums
     * @return
     */
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> sub = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    private static void dfs(int i,int[] nums) {
        if(i==nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        dfs(i+1,nums);
        sub.add(nums[i]);
        dfs(i+1,nums);
        sub.remove(sub.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2}));
    }
}
