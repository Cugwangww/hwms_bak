package 链表.链表反转;

import 链表.ListNode;

import java.util.Arrays;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/12
 */
public class ReverseList {


  /**
   * https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
   *
   *
   * 在遍历链表时，将当前节点的 next\textit{next}next 指针改为指向前一个节点。
   * 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
   * 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
   *
   * @param head
   * @return
   */
  public  static ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      return prev;
  }

  public static void main(String[] args) {
    ListNode ln1 = new ListNode(2);
    ListNode cur = ln1;
    for (int i = 0; i < 3; i++) {
      ListNode temp1 = new ListNode(i+3);
      while (cur.next!=null){
        cur = cur.next;
      }
      cur.next = temp1;
    }
    ListNode listNode = reverseList(ln1);

  }
}
