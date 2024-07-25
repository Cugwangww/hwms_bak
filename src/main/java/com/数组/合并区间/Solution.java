package com.数组.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/20
 */
public class Solution {

    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(p,q)-> p[0] - q[0]);
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[]p = intervals[i];
            int m = ans.size();
            if(m>0 && p[0]<=ans.get(m-1)[1]){
                ans.get(m-1)[1]=Math.max(ans.get(m-1)[1],p[1]);
            }else {
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
