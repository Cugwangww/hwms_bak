package com.ebg.链表.反转链表2;

import com.ebg.链表.ListNode;


/**
 *
 * @description
 * @date 2024/7/23
 */
public class Solution {
    /**
     * https://leetcode.cn/problems/reverse-linked-list-ii/description/
     *
     * @param head
     * @return
     */
    public static ListNode reverseKGroup(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        System.out.println(reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3)))));

    }
}
