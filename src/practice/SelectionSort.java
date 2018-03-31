package practice;

import java.util.Arrays;

/**
 * Created by lsw on 01/02/2018.
 */
public class SelectionSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int lo = i;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[lo]) {
                    lo = j;
                }
            }
            // swap nums[i] with nums[lo]
            int tmp = nums[i];
            nums[i] = nums[lo];
            nums[lo] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {10, 3, 21,50, 2, 8,1, 12, 100};
        selectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
