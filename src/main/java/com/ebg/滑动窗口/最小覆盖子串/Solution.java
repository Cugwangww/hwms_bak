package com.ebg.滑动窗口.最小覆盖子串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author author
 * @description
 * @date 2024/4/6
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * @return
     */

    public String minWindow(String s, String t) {
        char[] array = s.toCharArray();
        int m = s.length();
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; //s子串字母出现的次数
        int[] cntT = new int[128]; //t子串字母出现的次数
        for ( char c: t.toCharArray()) {
            cntT[c]++;
        }
        int left = 0;
        for (int rigth = 0; rigth < m; rigth++) {
            cntS[array[rigth]]++;
            while (isCoved(cntS,cntT)){
                if((rigth-left)<(ansRight-ansLeft)){
                    ansLeft = left;
                    ansRight = rigth;
                }
                cntS[array[left++]]--;
            }
        }
        return  ansLeft<0?"":s.substring(ansLeft,ansRight);
    }

    private boolean isCoved(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

}
