package hackerrank;

import sun.nio.ch.sctp.SctpNet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(subseq(input));
    }

    public static String subseq(String input) {
        List<Integer>[] map = new List[26];
        for(int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i = 0; i < input.length(); i++) {
            map[input.charAt(i) - 'a'].add(i);
        }
        StringBuilder sb = new StringBuilder();
        int cur = -1;
        for(int i = 25; i >= 0; i--) {
            for(int index : map[i]) {
                if(index > cur) {
                    sb.append(input.charAt(index));
                    cur = index;
                }
            }
        }
        return sb.toString();
    }
}
