package com.ebg.回溯.组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @date 2024/10/9
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/combination-sum/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length==0){
            return res;
        }
        List<Integer> sub = new ArrayList<>();
        int length = candidates.length;
        dfs(res,sub,candidates,target,length,0);
        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> sub, int[] candidates, int target, int length,int index) {
        if(target<0){
            return;
        }
        if(target ==0){
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = index; i < length; i++) {
            sub.add(candidates[i]);
            dfs(res,sub,candidates,target-candidates[i],length,i);
            sub.remove(sub.size()-1);
        }
    }
}
