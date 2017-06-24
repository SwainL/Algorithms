package topcoder;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by liusiwei on 2017/6/22.
 */
public class UndoHistory {
    public int minPresses(String[] lines) {
        int min = lines[0].length() + 1;

        for(int i = 1; i < lines.length; i++ ) {
            int icost = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                int k = 0;
                while (k < lines[j].length() && k < lines[i].length() && lines[j].charAt(k) == lines[i].charAt(k)) {
                    k++;
                }
                int ijcost = 2 + lines[i].length() - k  + 1;
                if (j == i - 1 && k == lines[j].length()) {
                    ijcost -= 2;
                }
                icost = Math.min(icost, ijcost);
            }
            min += icost;
        }

        return min;
    }

    public static void main(String[] args) {
        UndoHistory uh = new UndoHistory();
        String[] lines = new String[] {
                "ba","a","a","b","ba"        };
        System.out.println(uh.minPresses(lines));
    }

}
