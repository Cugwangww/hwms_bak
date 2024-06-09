package com.链表.删除链表的倒数第N个节点;


import 链表.ListNode;

/**
 * @Description TODO
 * @Author author
 * @Date 2024/3/20 22:21
 */

public class Solution {

    /**
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head);
        int length = getLength(head);
        ListNode cur = pre;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = pre.next;
        return ans;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head!=null){
            length++;
            head = head.next;
        }
        return length;
    }


    public static void main(String[] args) {

    }
}
