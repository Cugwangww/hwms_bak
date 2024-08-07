package com.ebg.链表.两两交换链表中的节点;

import com.ebg.链表.ListNode;


/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/23
 */
public class Solution {
    /**
     * https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = node2.next;
        node1.next = swapPairs(node3); // 1 指向递归返回的链表头
        node2.next = node1; // 2 指向 1
        return node2; // 返回交换后的链表头节点
    }

    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0, head); // 用哨兵节点简化代码逻辑
        ListNode node0 = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) { // 至少有两个节点
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2; // 0 -> 2
            node2.next = node1; // 2 -> 1
            node1.next = node3; // 1 -> 3

            node0 = node1; // 下一轮交换，0 是 1
            node1 = node3; // 下一轮交换，1 是 3
        }
        return dummy.next; // 返回新链表的头节点
    }

    public static void main(String[] args) {

    }
}
