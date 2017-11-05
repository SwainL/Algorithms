package topcoder;

/**
 * Created by lsw on 15/08/2017.
 * Source link: https://community.topcoder.com/stat?c=problem_statement&pm=14429
 */

public class ThueMorseGame {
    public static String get(int n, int m) {
        int i = 0, lastLossPos = 0;

        while (i <= n)
            if (Integer.bitCount(i)%2 == 1) i++;
            else {
                lastLossPos = i;
                i += (m + 1);
            }

        return (lastLossPos == n) ? "Bob" : "Alice";
    }

    public static void main(String[] args) {
        System.out.println(get(387, 22));
    }

}
