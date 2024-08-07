package com.ebg.回溯.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/25
 */
public class Permute1 {

    /**
     * https://leetcode.cn/problems/permutations/description/
     *
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2}));
    }
}
