package leetcode;

import com.sun.media.jfxmedia.events.BufferListener;
import com.sun.xml.internal.ws.util.Pool;
import topcoder.ThreeProgrammers;

import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * Created by liusiwei on 2017/4/19.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int target = sc.nextInt();
        int[] dishes = new int[len];
        for(int i = 0; i < len; i++) {
            dishes[i] = sc.nextInt();
        }
        //Arrays.sort(dishes);
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += dishes[i];
        }
        if (sum < target) {
            System.out.println(-1);
            return ;
        }
        int d = sum - target;
        int[][] dp = new int[len][d + 1];
        for(int i = dishes[0]; i < d + 1; i++) {
            for(int j = 0; j < len; j++)
            dp[j][i] = dishes[0];
        }
        for(int i = 1; i < len; i ++) {
            for(int j = 0; j < d + 1; j++) {
                if (j - dishes[i] >= 0) {
                    dp[i][j] = Math.max(dp[i -1][j], dp[i - 1][j - dishes[i]] + dishes[i]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(sum - dp[len - 1][d]);


    }
}