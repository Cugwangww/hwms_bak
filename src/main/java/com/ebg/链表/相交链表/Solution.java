package com.ebg.链表.相交链表;

import com.ebg.链表.ListNode;

/**
 *
 * @description
 * @date 2024/7/9
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        while (cur!=null){
            ListNode pre = headB;
            if(cur==pre){
                break;
            }else {
                pre = pre.next;
            }
        }
        return cur;
    }
}
