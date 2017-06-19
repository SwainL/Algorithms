package leetcode;

import java.util.List;

/**
 * Created by liusiwei on 2017/4/24.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    public static ListNode init(Integer[] arr) {
        if(arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    public String toString() {
        return val + "";
    }
    public static String traverse(ListNode head) {
        if (head == null) {
            return "null";
        }
        return head.val + "->" + traverse(head.next);
    }
}
