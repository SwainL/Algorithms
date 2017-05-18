package topcoder;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/4/18.
 */
public class ThreeProgrammers {
    final int MAXN = 52;
    int memo[][][][][] = new int[MAXN][MAXN][MAXN][3][3];
    int n;
    int[] maxCnt = new int[3];

    int dp(int idx, int cntB, int cntC, int last, int prevLast) {
        if (memo[idx][cntB][cntC][last][prevLast] != -1) {
            return memo[idx][cntB][cntC][last][prevLast];
        }

        int cnt[] = new int[3];
        cnt[0] = idx - cntB - cntC;
        cnt[1] = cntB;
        cnt[2] = cntC;

        int res = 0;
        if (idx == n) {
            res = 1;
        } else {
            for (int cur = 0; cur < 3; cur++) {
                if (cnt[cur] + 1 <= maxCnt[cur]) {
                    if (cur == 1) { // For 'B'
                        if (cur != last) {
                            if (dp(idx + 1, cnt[1] + 1, cnt[2], cur, last) > 0) {
                                res = 1;
                            }
                        }
                    }
                    else if (cur == 2) { // For 'C'
                        if (cur != last && cur != prevLast) {
                            if (dp(idx + 1, cnt[1], cnt[2] + 1, cur, last) > 0) {
                                res = 1;
                            }
                        }
                    } else { // For 'A'
                        if (dp(idx + 1, cnt[1], cnt[2], cur, last) > 0) {
                            res = 1;
                        }
                    }
                }
            }
        }

        memo[idx][cntB][cntC][last][prevLast] = res;
        return res;
    }

    public String construct(int idx, int cntB, int cntC, int last, int prevLast) {
        if (idx == n) {
            return "";
        } else {
            int cnt[] = new int[3];
            cnt[0] = idx - cntB - cntC;
            cnt[1] = cntB;
            cnt[2] = cntC;

            for (int cur = 0; cur < 3; cur++) {
                cnt[cur] += 1;
                if (dp(idx + 1, cnt[1], cnt[2], cur, last) > 0) {
                    return (char) ('A' + cur) + construct(idx + 1, cnt[1], cnt[2], cur, last);
                }
            }
        }
        return "";
    }

    public String validCodeHistory(String code) {
        int[] cnt = new int[3];
        for (int i = 0; i < code.length(); i++) {
            cnt[code.charAt(i) - 'A']++;
        }

        n = code.length();
        System.arraycopy(cnt, 0, maxCnt, 0, 3);

        for (int[][][][] x : memo) {
            for (int[][][] y : x) {
                for (int[][] z : y) {
                    for (int[] w : z) {
                        Arrays.fill(w, -1);
                    }
                }
            }
        }

        int res = dp(0, 0, 0, 0, 0);
        if (res == 0) {
            return "impossible";
        } else {
            return construct(0, 0, 0, 0, 0);
        }
    }

    public static void main(String[] args) {
        ThreeProgrammers tps = new ThreeProgrammers();
        String result = tps.validCodeHistory("ACAC");
        System.out.println(result);
    }

}
