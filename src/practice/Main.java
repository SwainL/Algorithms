package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by lsw on 14/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(int2Str((int) Math.pow(10, 5)));
    }

    public static int walk(TrieNode root, String[] words, char[] bases) {
        int count = 0;
        for (String word : words) {
            char[] digits = word.toCharArray();
            for(int i = 0; i < bases.length; i++) {
                if (bases[i] == '0') {
                    if (digits[i] == '0') {
                        count +=
                    }
                } else if (bases[i] == '1') {
                    if (digits[i] == '0') {
                        count +=
                    }
                }
            }
        }


    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] digits = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < digits.length; i++) {
                if(cur.links[digits[i] - '0'] == null) {
                    cur.links[digits[i] - '0'] = new TrieNode();
                }
                cur = cur.links[digits[i] - '0'];
                cur.paths++;
            }
        }
        return root;
    }

    public static String int2Str(int num) {
        // 10 ^ 5 = 11000011010100000 (17 bits in total)
        // to guarantee the precision, we need at 17 bits to represent a binary number
        char[] digits = new char[17];
        for(int i = 0; i < 17; i++) {
            digits[16 - i] = (num >> i & 1) == 0 ? '0' : '1';
        }
        return String.valueOf(digits);
    }


}
