package com.ebg.动态规划.子集;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @date 2024/10/8
 */
public class Solution1 {


    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        res.add(sub);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> integers = new ArrayList<>(res.get(j));
                integers.add(nums[i]);
                res.add(integers);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
