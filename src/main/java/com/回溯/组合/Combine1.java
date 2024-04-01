package com.回溯.组合;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/28
 */
public class Combine1 {

    /**
     *https://leetcode.cn/problems/combinations/description/
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<k || n<1){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < n; i++) {
            path.addLast(i);
            dfs(n,k,begin+1,path,res);
            path.removeLast();
        }
    }
}
