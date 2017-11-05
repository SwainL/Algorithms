package practice;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/5/25.
 */
public class SegTree {
    int[] nums = new int[] {1, 3, 5, 7, 9, 11};
    int[] tree = new int[nums.length * 2 + 1];

    public static void main(String[] args) {
        SegTree segTree = new SegTree();
        segTree.build(0, 0, segTree.nums.length - 1);
        System.out.println(Arrays.toString(segTree.tree));
        System.out.println(segTree.query(0, 0, segTree.nums.length - 1, 2, 4));
    }

    public void build(int node, int start, int end) {
        if(start == end) { // leaf node
            tree[node] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            // recurse on the left node
            build(2*node + 1, start, mid);
            // recurse on the right node
            build(2*node + 2, mid + 1, end);
            // internal nodes have the sum of both its children
            tree[node] = tree[2 * node + 1] + tree[2*node + 2];
        }
    }

    public int query(int node, int start, int end, int l, int r) {
        if(r < start || l > end) return 0;

        if(l <= start && r >= end) return tree[node];

        int mid = start + (end - start) / 2;
        return query(2*node + 1, start, mid, l, r) + query(2*node + 2, mid + 1, end, l, r);
    }
}
