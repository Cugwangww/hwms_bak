package com.ebg.链表.合并K个排序链表;

import com.ebg.链表.ListNode;


/**
 *
 * @description
 * @date 2024/7/25
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/merge-k-sorted-lists/
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    private static ListNode mergeKLists(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0) return null; // 注意输入的 lists 可能是空的
        if (m == 1) return lists[i]; // 无需合并，直接返回
        ListNode left = mergeKLists(lists, i, i + m / 2); // 合并左半部分
        ListNode right = mergeKLists(lists, i + m / 2, j); // 合并右半部分
        return mergeTwoLists(left, right); // 最后把左半和右半合并
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1!=null && list2!=null){
            if(list1.val>= list2.val){
                pre.next = new ListNode(list2.val);
                list2 = list2.next;
            }else {
                pre.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            pre = pre.next;
        }
        pre.next = list1!=null?list1:list2;
        return head.next;
    }
}
