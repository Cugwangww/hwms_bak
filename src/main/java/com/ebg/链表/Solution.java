package com.ebg.链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @description
 * @date 2024/7/21
 */
public class Solution {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            ListNode next = cur.next;
            cur = next;
        }
        int left = 0,right = list.size()-1;
        while (left<=right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }else {
                left++;right--;
            }
        }
        return true;
    }

    public static boolean hasCycle(ListNode head) {
        if(head==null ||head.next==null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while(slow != quick){
            if(quick == null || quick.next ==null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
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

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int gewei = 0;
        int shiwei =0;
        while (list1!=null || list2!=null){
            int total = shiwei;
            if(list1!=null){
                total += list1.val;
                list1 = list1.next;
            }
            if(list2!=null){
                total += list2.val;
                list2 = list2.next;
            }
            shiwei = total/10;
            gewei = total%10;
            pre.next = new ListNode(gewei);
            pre = pre.next;
        }
        if(shiwei>0){
            pre.next = new ListNode(shiwei);
        }
        return head.next;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0,head);
        int length = getLength(head);
        ListNode cur = pre;
        for (int i = 1; i < length-n+1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return pre.next;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur!=null){
            cur = cur.next;
            length++;
        }
        return length;
    }

    public static ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        Object[] objects = list.toArray();
        Arrays.sort(objects);
        ListNode pre = new ListNode(0);
        ListNode cur1 = pre;
        for (int i = 0; i < objects.length; i++) {
            cur1.next = new ListNode((int)objects[i]);
            cur1 = cur1.next;
        }
        return pre.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(3,new ListNode(2)));
        System.out.println(sortList(node1));
    }
}
