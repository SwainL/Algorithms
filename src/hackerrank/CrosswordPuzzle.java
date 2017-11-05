package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lsw on 25/06/2017.
 */
public class CrosswordPuzzle {
    class Word {
        int i;
        int j;
        int dir; // 0: horizontal 1: vertical
        int len;

        Word(int i, int j, int dir, int len) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.len = len;
        }
    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[10][10];
        for(int i = 0; i < 10; i++) {
            char[] line = sc.nextLine().toCharArray();
            for(int j = 0; j < 10; j++) {
                board[i][j] = line[j];
            }
        }
        System.out.println(Arrays.deepToString(board));

    }
}
