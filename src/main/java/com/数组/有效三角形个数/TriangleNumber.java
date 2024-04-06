package 数组.有效三角形个数;

import java.util.Arrays;
import java.util.List;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class TriangleNumber {

  /**
   * https://leetcode.cn/problems/valid-triangle-number/description/
   *
   * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
   *
   *输入: nums = [2,2,3,4]
   * 输出: 3
   *
   * 双指针法比较，排序后 只要前面两个数之和大于第三个数 就++
   * @param nums
   * @return
   */
    public static int triangleNumber(int[] nums) {
      int abs = 0;
      Arrays.sort(nums);
      for (int i = nums.length -1 ; i >=2 ; i--) {
        int j = i - 1;
        int k = 0;
        while (k<j){
          if(nums[j] + nums[k] > nums[i]){
            abs += j-k;
            j--;
          }else{
            k++;
          }
        }
      }
      return abs;
    }

  public static void main(String[] args) {
    System.out.println(triangleNumber(new int[]{12,2,3,4}));
  }
}
