package practice;

import java.util.Arrays;

/**
 * Created by lsw on 01/02/2018.
 */
public class BubbleSort {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; --j) {
                int tmp = nums[j + 1];
                nums[j + 1] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {10, 3, 21, 50, 2, 8, 1, 12, 100};
        bubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
