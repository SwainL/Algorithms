package hihocoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by liusiwei on 2017/6/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[2*N][2];
        for(int i = 0; i < 2*N - 1; ) {
            arr[i ++] = new int[] {sc.nextInt(), 1};
            arr[i ++] = new int[] {sc.nextInt(), -1};
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    if (o1[1] > o2[1]) {
                        return 1;
                    } else if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int max = 0;
        int sum = 0;
        for(int i = 0; i < 2*N; i++) {
            sum += arr[i][1];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
