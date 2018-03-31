package leetcode;

import java.util.Arrays;

class Solution {
    int[] tree;

    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        tree = new int[N << 2];
        build(0, N - 1, heights, 0);
        return helper(heights, 0, N - 1);
    }

    private int helper(int[] heights, int l, int r) {
        if (l >= r) return heights[l];
        int idx_min = query(0, heights.length - 1, 0, l, r, heights);
        return Math.max(Math.max(helper(heights, l, idx_min - 1), helper(heights, idx_min + 1, r)), heights[idx_min] * (r - l + 1));

    }

    private void build(int l, int r, int[] heights, int idx) {
        if (l >= r) {
            tree[idx] = l;
            return;
        }
        int mid = l + (r - l) / 2;
        build(l, mid, heights, idx * 2 + 1);
        build(mid + 1, r, heights, idx * 2 + 2);
        tree[idx] = heights[tree[idx * 2 + 1]] <= heights[tree[idx * 2 + 2]] ? tree[idx * 2 + 1] : tree[idx *2 + 2];
    }

    private int query(int lo, int hi, int idx, int l, int r, int[] heights) {
        if (l <= lo && r >= hi) return tree[idx];
        int mid = lo + (hi - lo) / 2;
        if (r <= mid) {
            return query(lo, mid, 2 * idx + 1, l, r, heights);
        } else if (l > mid) {
            return query(mid + 1, hi, 2 * idx + 2, l, r, heights);
        } else {
            int v1 = query(lo, mid, 2 * idx + 1, l, mid, heights);
            int v2 = query(mid + 1, hi, 2 * idx + 2, mid + 1, r, heights);
            return heights[v1] <= heights[v2] ? v1 : v2;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
    }
}