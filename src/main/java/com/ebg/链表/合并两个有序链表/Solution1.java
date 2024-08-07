package com.ebg.链表.合并两个有序链表;


import com.ebg.链表.ListNode;

/**
 * @Description TODO
 * @Author author
 * @Date 2024/3/20 22:21
 */

public class Solution1 {

    /**
     * https://leetcode.cn/problems/merge-two-sorted-lists/description/
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(0);
        ListNode cur = prehead;
        while (list1!=null && list2!=null){
            if(list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1==null?list2:list1;
        return prehead.next;
    }


    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(1,new ListNode(2)),new ListNode(1,new ListNode(3))));
    }
}
