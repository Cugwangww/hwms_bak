package 链表;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/20
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
