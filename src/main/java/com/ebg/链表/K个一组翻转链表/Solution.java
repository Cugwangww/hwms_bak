package com.ebg.链表.K个一组翻转链表;

import com.ebg.链表.ListNode;


/**
 *
 * @description
 * @date 2024/7/23
 */
public class Solution {
    /**
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param head
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 判断当前长度是否小于k
        ListNode p0 = head;
        for (int i = 0; i < k; i++) {
            if (p0 == null) return head;
            p0 = p0.next;
        }
        // 翻转k个链表
        ListNode pre = null, cur = head, nex;
        for (int i = 0; i < k; i++) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        // 继续检索下一组
        head.next = reverseKGroup(cur, k);
        return pre;
    }
    public static void main(String[] args) {
        //System.out.println(reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3)))));
    }
}
