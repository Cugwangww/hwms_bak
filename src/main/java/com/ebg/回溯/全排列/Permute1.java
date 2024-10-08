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
        List<Integer> list = new ArrayList<>();
        dfs(nums,list,res);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2}));
    }
}
