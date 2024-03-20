import java.util.ArrayList;
import java.util.List;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/13
 */
public class Palindrome1 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(2);
        ListNode cur = ln1;
        for (int i = 0; i < 4; i++) {
            ListNode temp1 = new ListNode(2);
            while (cur.next!=null){
                cur = cur.next;
            }
            cur.next = temp1;
        }
        System.out.println(isPalindrome(ln1));
    }

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
