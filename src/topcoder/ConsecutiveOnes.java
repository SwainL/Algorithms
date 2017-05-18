package topcoder;


import java.nio.file.FileStore;
import java.util.Arrays;

/**
 * Created by liusiwei on 2017/4/22.
 */
public class ConsecutiveOnes {
    public int thirdMax(int[] nums) {
        int a = 0;
        long[] max = new long[3];
        max[0] = Long.MIN_VALUE;
        max[1] = Long.MIN_VALUE;
        max[2] = Long.MIN_VALUE;
        do{
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] > max[a] && (a == 0 || nums[i] < max[a - 1])) {
                    max[a] = nums[i];
                }
            }
            if(max[a] == Long.MIN_VALUE) {
                return (int)max[0];
            }
            a++;
        }while(a < 3);
        return (int)max[2];
    }

    public static void main(String[] args) {
        ConsecutiveOnes cos = new ConsecutiveOnes();
        System.out.println(cos.thirdMax(new int[]{1,2,-2147483648}));

    }
}
