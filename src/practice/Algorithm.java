package practice;

import leetcode.TreeNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liusiwei on 2017/4/27.
 */
public class Algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String token = "";
        while ((token = scanner.next()) != null) {
            if (stack.isEmpty() && token.equals(";")) {
                System.out.println(";");
                break;
            } else {
                if (token.equals("{")) {
                    stack.push(token);
                } else if (token.equals("}")) {
                    stack.pop();
                }
            }
        }
    }
}
