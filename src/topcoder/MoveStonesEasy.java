package topcoder;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/6/23.
 */
public class MoveStonesEasy {

    public int get(int[] a, int[] b) {
        int cost = 0;
        int p = 0;
        for(int i = 0; i < a.length; i++) {
            int has = p + a[i];
            int needs = b[i];
            p = has - needs;
            cost += Math.abs(p);
        }
        return p == 0 ? cost : -1;
    }

    public static void main(String[] args) {
        MoveStonesEasy mse = new MoveStonesEasy();
        int[] a = new int[]	{0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 1000};
        int[] b = new int[] {1000, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0};
        System.out.println(mse.get(a, b));
    }


}

