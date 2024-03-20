package 数组.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/12
 */
public class ThreeSum {

    /**
     * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
     *
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            if(nums[i]>0)break;
            if(i>0 && (nums[i] == nums[i-1]))continue;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum<0){
                    while(j<k && nums[j] == nums[++j]);
                }
                if(sum>0){
                    while(j<k && nums[k] == nums[--k]);
                }
                if(sum==0){
                    list.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(j<k && nums[j] == nums[++j]);
                    while(j<k && nums[k] == nums[--k]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-2,0,0,2,2});
    }
}
