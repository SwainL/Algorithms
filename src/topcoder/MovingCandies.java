package topcoder;

import java.util.*;

public class MovingCandies {
    class Node {
        int i;
        int j;
        int val;

        Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }


    public int minMoved(String[] t) {
        int N = t.length;
        int M = t[0].length();

        char[][] candy = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                candy[i][j] = t[i].charAt(j);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N*M, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });

        pq.add(new Node(0, 0, t[0].charAt(0) == '#' ? 0 : 1));
        candy[0][0] = '-';

        while (!pq.isEmpty()) {
            Node cur = pq.remove();
            System.out.println(cur.i + " " + cur.j + " " + cur.val);
            if (cur.i == N - 1 && cur.j == M - 1) {
                return cur.val;
            }
            if (cur.i - 1 >= 0 && candy[cur.i - 1][cur.j] != '-') {
                int cost = cur.val + (t[cur.i - 1].charAt(cur.j) == '#' ? 0 : 1);
                candy[cur.i - 1][cur.j] = '-';
                pq.add(new Node(cur.i - 1, cur.j, cost));
            }
            if (cur.i + 1 < N && candy[cur.i + 1][cur.j] != '-') {
                int cost = cur.val + (t[cur.i + 1].charAt(cur.j) == '#' ? 0 : 1);
                candy[cur.i + 1][cur.j] = '-';
                pq.add(new Node(cur.i + 1, cur.j, cost));
            }
            if (cur.j - 1 >= 0 && candy[cur.i][cur.j - 1] != '-') {
                int cost = cur.val + (t[cur.i].charAt(cur.j - 1) == '#' ? 0 : 1);
                candy[cur.i][cur.j - 1] = '-';
                pq.add(new Node(cur.i, cur.j - 1, cost));
            }
            if (cur.j + 1 < M && candy[cur.i][cur.j + 1] != '-') {
                int cost = cur.val + (t[cur.i].charAt(cur.j + 1) == '#' ? 0 : 1);
                candy[cur.i][cur.j + 1] = '-';
                pq.add(new Node(cur.i, cur.j + 1, cost));
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        MovingCandies mc = new MovingCandies();
        String[] t = new String[]
                {
                        "#...###",
                        "#...#.#",
                        "##..#.#",
                        ".#....#"

                };
        System.out.println(mc.minMoved(t));
    }

    /*
      #  #  #  .  #  #  #  #  #  #  #  #  #  .  .  #  #  #  #  #
    [[0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3],


      .  #  #  #  #  #  #  #  .  #  #  #  #  #  #  #  #  #  #  #
     [1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
     */


    /*
    101232333344
    111222345655
    212233456556
    32234556.656
    2234566...6.
     */
 
}