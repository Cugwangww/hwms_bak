package com.ebg.链表.合并两个有序链表;


import com.ebg.链表.ListNode;

/**
 * @Description TODO
 * @Author author
 * @Date 2024/3/20 22:21
 */

public class Solution {

    /**
     * https://leetcode.cn/problems/merge-two-sorted-lists/description/
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (list1!=null && list2!=null){
            if(list1.val<= list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 ==null?list2:list1;
        return prehead.next;
    }

    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if(list1.val<=list2.val){
            list1.next = mergeTwoLists1(list1.next,list2);
            return list1.next;
        }else {
            list2.next = mergeTwoLists1(list1,list2.next);
            return list2.next;
        }
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(1,new ListNode(2)),new ListNode(1,new ListNode(3))));
    }
}
