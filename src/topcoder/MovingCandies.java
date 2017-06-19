package topcoder;

import java.util.*;

public class MovingCandies {
    static final int INF = (int) 1e9;
 
    public int minMoved(String[] t) {
        int height = t.length;
        int width = t[0].length();
        int[][] cost = new int[height][width];
        int totalCandies = 0;
        for (int r = 0; r < height; ++r) {
            for (int c = 0; c < width; ++c) {
                boolean isCandy = t[r].charAt(c) == '#';
                cost[r][c] = isCandy ? 0 : 1;
                if (isCandy) ++totalCandies;
            }
        }
        int[][] best = new int[height][width];
        for (int[] x : best) Arrays.fill(x, INF);
        best[0][0] = cost[0][0];
        int res = best[height - 1][width - 1];
        for (int steps = 2; steps <= totalCandies; ++steps) {
            int[][] nbest = new int[height][width];
            for (int[] x : nbest) Arrays.fill(x, INF);
            for (int r = 0; r < height; ++r) {
                for (int c = 0; c < width; ++c) {
                    int cur = best[r][c];
                    if (cur >= INF) continue;
                    for (int dr = -1; dr <= 1; ++dr) {
                        for (int dc = -1; dc <= 1; ++dc) {
                            if (Math.abs(dr) + Math.abs(dc) == 1) {
                                int nr = r + dr;
                                int nc = c + dc;
                                if (nr >= 0 && nr < height && nc >= 0 && nc < width) {
                                    nbest[nr][nc] = Math.min(nbest[nr][nc], cur + cost[nr][nc]);
                                }
                            }
                        }
                    }
                }
            }
            best = nbest;
            res = Math.min(res, best[height - 1][width - 1]);
        }
        if (res >= INF) res = -1;
        return res;
    }

    public static void main(String[] args) {
        MovingCandies mc = new MovingCandies();
        String[] t = new String[] {"#...###", "#...#.#", "##..#.#", ".#....#" };
        System.out.println(mc.minMoved(t));
    }
 
}