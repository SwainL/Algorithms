package topcoder;

/**
 * Created by liusiwei on 2017/4/26.
 */
public class BalancedTrees {
    public int maxHeight(int k, int n) {
        int h = 0;
        while(n > fewest(h, k)) {
            h++;
        }
        return h;
    }

    public int fewest(int h, int k) {
        if(h <= 0) return 0;
        return 1 + fewest(h - 1, k) + fewest(h - k - 1, k);
    }

    public static void main(String[] args) {
        BalancedTrees bts = new BalancedTrees();
        System.out.println(bts.maxHeight(1, 7));
    }
}
