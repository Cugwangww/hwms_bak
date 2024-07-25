package com.链表.排序链表;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/7/24
 */
public class Solution {

    /**
     *
     * https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
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
}
