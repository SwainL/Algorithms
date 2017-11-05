package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by liusiwei on 2017/4/21.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode init(Integer[] input) {
        int N = input.length;
        TreeNode root = new TreeNode(input[0]);
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if(2 * count + 1 < N && input[2 * count + 1] != null) {
                cur.left = new TreeNode(input[2 * count + 1]);
                queue.add(cur.left);
            }
            if(2 * count + 2 < N && input[2 * count + 2] != null) {
                cur.right = new TreeNode(input[2 * count + 2]);
                queue.add(cur.right);
            }
            count += 1;
        }
        return root;
    }

    public static void traverse(TreeNode root) {
        if(root == null) {
            return ;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }


    public static void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        if(root != null) {
            stack.add(root);
        }
        TreeNode out = root;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(cur.left != null && cur.left != out && cur.right != out) {
                stack.add(cur.left);
            } else if(cur.right != null && cur.right != out) {
                stack.add(cur.right);
            } else {
                out = stack.pop();
                System.out.println(out.val);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.init(new Integer[] {1, null, 2, 3});
    }
}
