package topcoder;

/**
 * Created by liusiwei on 2017/6/17.
 */
public class RangeEncoding {
    public int minRanges(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                count++;
            }
        }
        return count;
    }
}
