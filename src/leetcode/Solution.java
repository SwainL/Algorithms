package leetcode;

import java.util.*;

/**
 * Created by liusiwei on 2017/4/19.
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if(nums[0] == 0) {
            return false;
        }
        int maxIndex = 0;

        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] == 0) {
                if(nums[maxIndex] <= i - maxIndex) {
                    return false;
                }
            }

            if (nums[i] + i >= nums[maxIndex]) {
                maxIndex = i;
            }
            System.out.println(nums[maxIndex]);
        }
        return true;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[] {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(sol.canJump(nums));
    }
}