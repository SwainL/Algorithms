package topcoder;

/**
 * Created by liusiwei on 2017/6/17.
 */
public class MaximumRange {
    public int findMax(String s) {
        int res = 0;
        int[] counts = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '+') {
                counts[0]++;
            } else {
                counts[1]++;
            }
        }
        return Math.max(counts[0], counts[1]);
    }
}
