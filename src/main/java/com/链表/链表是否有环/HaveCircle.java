package 链表.链表是否有环;

import 链表.ListNode;

import java.util.*;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class HaveCircle {

  /**
   * https://leetcode.cn/problems/linked-list-cycle/description/
   *
   * 给你一个链表的头节点 head ，判断链表中是否有环。
   * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
   * set集合存储元素 是否包含
   * @param head
   * @returngenerate-parentheses
   */
    public boolean hasCircle(ListNode head) {
        if(head == null || head.next ==null){
            return false;
        }
        ListNode slow =  head;
        ListNode quick =  head.next;

        while(slow != quick){
            if(quick == null || quick.next ==null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
