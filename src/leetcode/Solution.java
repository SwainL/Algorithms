package leetcode;

import java.util.*;

/**
 * Created by liusiwei on 2017/4/19.
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int lstZero = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                lstZero = i;
            }
        }
        for(int i = 0; i < lstZero - 1; i++) {
            if (nums[i] > lstZero - i) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

    }
}