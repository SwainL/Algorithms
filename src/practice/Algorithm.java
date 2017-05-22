package practice;

import leetcode.TreeNode;

/**
 * Created by liusiwei on 2017/4/27.
 */
public class Algorithm {

    public int maxElement(TreeNode root) {
        if(root == null) return 0;
        return Math.max(root.val, Math.max(maxElement(root.left), maxElement(root.right)));
    }

    public int sizeOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return 1 + sizeOfBinaryTree(root.left) + sizeOfBinaryTree(root.right);
    }

    public static void main(String[] args) {
        Algorithm alg = new Algorithm();
        TreeNode root = TreeNode.init(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        System.out.println(alg.sizeOfBinaryTree(root));
    }
}
