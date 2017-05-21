package leetcode;

import com.sun.media.jfxmedia.events.BufferListener;
import topcoder.ThreeProgrammers;

import java.lang.ref.SoftReference;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * Created by liusiwei on 2017/4/19.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    public int getLength(ListNode head) {
        if(head == null) return 0;
        return 1 + getLength(head.next);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode headA = ListNode.init(new Integer[]{1,2,3,4,5,6});

        System.out.println(sol.getLength(headA));
    }
}
