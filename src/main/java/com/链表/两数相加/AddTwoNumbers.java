package 链表.两数相加;

import 链表.ListNode;

/**
 * @author author
 * @description
 * @date 2024/3/12
 */
public class AddTwoNumbers {


  /**
   * https://leetcode.cn/problems/add-two-numbers/description/
   *
   * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
   * 请你将两个数相加，并以相同形式返回一个表示和的链表。
   * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
   *
   * 示例输入：l1 = [2,4,3], l2 = [5,6,4]
   * 输出：[7,0,8]
   * 解释：342 + 465 = 807.
   *
   *遍历两个链表节点
   * 用一个变量保存10位数 再加到下一个节点
   * @param l1
   * @param l2
   * @return
   */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode pre = new ListNode(0);
      ListNode cur = pre;
      int carry = 0;
      while (l1!= null || l2 != null){
        int x = l1 != null ? l1.val : 0;
        int y = l2 != null ? l2.val : 0;
        int sum = x + y + carry;
        carry = sum / 10;
        sum = sum % 10;
        cur.next = new ListNode(sum);
        cur = cur.next;
        if (l1!=null) l1 = l1.next;
        if (l2!=null) l2 = l2.next;
      }
      if(carry == 1){
        cur.next = new ListNode(carry);
      }
      return pre.next;
    }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(2);
    ListNode cur = ln1;
    for (int i = 0; i < 8; i++) {
      ListNode temp1 = new ListNode(i+2);
      while (cur.next!=null){
        cur = cur.next;
      }
      cur.next = temp1;
    }

    ListNode ln2 = new ListNode(6);
    ListNode cur1 = ln2;
    for (int i = 0; i < 5; i++) {
      ListNode temp2 = new ListNode(i+5);
      while (cur1.next!=null){
        cur1 = cur1.next;
      }
      cur1.next = temp2;
    }
    addTwoNumbers(ln1,ln2);
  }
}
