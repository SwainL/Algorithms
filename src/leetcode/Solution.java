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
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 1) {
            sb.append(num % 16);
            num = num / 16;
        }
        return sb.reverse().toString();
    }




    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.toHex(26));
    }
}
