import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/12
 */
public class MaxArea {


  //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
  //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
  //返回容器可以储存的最大水量。
  //输入：[1,8,6,2,5,4,8,3,7]
  //输出：49
  //解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int abs = 0;
        while (i<j){
          int area = (j-i)*Math.min(height[i],height[j]);
          abs = Math.max(abs,area);
          if(height[i]<=height[j]){
              i++;
          }else{
              j--;
          }
        }
      return abs;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
