package com.ebg.链表.环形链表;

import com.ebg.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/8/12
 */
public class Solution {

    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr:matrix) {
            if(search(arr,target)){
                return true;
            }
        }
        return false;
    }

    private static boolean search(int[] arr, int target) {
        boolean flag = false;
        int left = 0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (right+left)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}},3));
    }
}
