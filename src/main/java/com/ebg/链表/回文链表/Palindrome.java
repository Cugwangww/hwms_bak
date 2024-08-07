package com.ebg.链表.回文链表;

import java.util.ArrayList;
import java.util.List;
import com.ebg.链表.ListNode;


/**
 * @author author
 * @date 2024/3/13
 */
public class Palindrome {


    /**
     * https://leetcode.cn/problems/palindrome-linked-list/description/
     *
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * @return
     */
    public static boolean isPalindrome(ListNode listNode){
        List<Integer> list = new ArrayList<>();
        ListNode pre = listNode;
        while (pre!=null){
            list.add(pre.val);
            pre = pre.next;
        }
        int i = 0,j=list.size()-1;
        while (i<j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
