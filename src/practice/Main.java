package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by lsw on 14/09/2017.
 */
public class Main {
    static int[] nums = null;
    static int[] tree = null;
    static int[] indicators = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        indicators = new int[N];
        for(int i = 0; i < N; i++) {
            indicators[i] = 1;
        }
        tree = new int[N * 2];
        int Q = sc.nextInt();
        int[] ans =  new int[Q];
        int[][] querys = new int[Q][4];
        for(int i = 0; i < Q; i++) {
            querys[i][0] = i;
            querys[i][1] = sc.nextInt();
            querys[i][2] = sc.nextInt();
            querys[i][3] = sc.nextInt();
        }
        Arrays.sort(querys, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });
        System.out.println(Arrays.deepToString(querys));
        build(1, 0, N - 1);
        System.out.println(Arrays.toString(tree));
        for(int i = 0; i < Q; i++) {
            for(int j = 0; j < N; j++) {
                if(nums[j] <= querys[i][3]) update(j, 1, 0, N - 1);
            }
            ans[querys[i][0]] = query(1, 0, N - 1, querys[i][1] - 1, querys[i][2] -1);
        }

        System.out.println(Arrays.toString(ans));
    }

    public static void build(int node, int start, int end) {
        if(start == end) {
            tree[node] = indicators[start];
        } else {
            int mid = start + (end - start) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public static void update(int pos, int node, int start, int end) {
        if(start == end) {
            tree[node] = 0;
            return;
        }
        int mid = start + (end - start) / 2;
        if(pos <= mid) update(pos, 2 * node, start, mid);
        else update(pos, 2 * node + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static int query(int node, int start, int end, int l, int r) {
        if(r < start || l > end) return 0;
        if(l <= start && r >= end) return tree[node];
        int mid = start + (end - start) / 2;
        return query(node * 2, start, mid, l, r) + query(node * 2 + 1, mid + 1, end, l, r);
    }
}
