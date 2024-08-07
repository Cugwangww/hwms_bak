package com.ebg.数组.两数之和;

import java.util.*;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class ThreeSum {

    /**
     * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
     *
     * @param numbers
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left<right) {
            int s = numbers[left] + numbers[right];
            if (s == target) {
                return new int[]{left + 1, right + 1}; // 题目要求下标从 1 开始
            }
            if (s > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{1, 1};
    }

    public static int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                return new int[]{i,map.get(target-numbers[i])};
            }
            map.put(numbers[i],i);
        }
        return new int[]{1, 1};
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            List<String> list;
            if(map.containsKey(String.valueOf(chars))){
                 list = map.get(String.valueOf(chars));
            }else{
                list=new ArrayList<>();
            }
            list.add(word);
            map.put(String.valueOf(chars),list);
        }
        for(List<String> aaa:map.values()){
            res.add(aaa);
        }
        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < s.length()-p.length(); i++) {
            String substring = s.substring(i, i + p.length());
            char[] chars1 = substring.toCharArray();
            Arrays.sort(chars1);
            if(String.valueOf(chars).equals(String.valueOf(chars1))){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum(new int[]{3,2,4},6);
    }
}
