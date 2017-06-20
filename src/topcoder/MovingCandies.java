package topcoder;

import java.util.*;

public class MovingCandies {
 
    public int minMoved(String[] t) {
        int[][] dp = new int[t.length][t[0].length()];

        dp[0][0] = t[0].charAt(0) == '#' ? 0 : 1;

        for(int j = 1; j < dp[0].length; j++) {
            int cost = t[0].charAt(j) == '#' ? 0 : 1;
            dp[0][j] = dp[0][j - 1] + cost;;
        }

        for(int i = 1; i < dp.length; i ++) {
            int cost = t[i].charAt(0) == '#' ? 0 : 1;
            dp[i][0] = dp[i - 1][0] + cost;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                int cost = t[i].charAt(j) == '#' ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cost;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[t.length - 1][t[0].length() - 1];
    }

    public static void main(String[] args) {
        MovingCandies mc = new MovingCandies();
        String[] t = new String[] {"###.#########..#####",".#######.###########" };
        System.out.println(mc.minMoved(t));
    }

    /*
      #  #  #  .  #  #  #  #  #  #  #  #  #  .  .  #  #  #  #  #
    [[0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3],


      .  #  #  #  #  #  #  #  .  #  #  #  #  #  #  #  #  #  #  #
     [1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
     */
 
}