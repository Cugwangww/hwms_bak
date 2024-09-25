package com.ebg.栈.每日温度;

import org.elasticsearch.cluster.block.ClusterBlockLevel;

import java.util.*;

/**
 *
 * @description
 * @date 2024/8/9
 */
public class Solution {

    /**
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length-1; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        res[temperatures.length-1]=0;
        return res;
    }

    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp>temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            int x = nums[i];
            if(i>0 && x==nums[i-1]){
                continue;
            }
            if(x + nums[i+1]+nums[i+2] >0){
                break;
            }
            int j = i+1;
            int k = length-1;
            while (j<k){
                int sum = x + nums[j]+nums[k];
                if(sum==0){
                    list.add(Arrays.asList(x,nums[j],nums[k]));
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 跳过重复数字
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 跳过重复数字
                }else if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(dailyTemperatures1(new int[]{4,2,6,3,5}));
    }

}
