package topcoder;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/6/24.
 */
public class TallPeople {
    public int[] getPeople(String[] people) {
        int[] rows = new int[people.length];
        int M = people[0].split(" ").length;
        int[] columns = new int[M];
        for(int i = 0; i < rows.length; i++) {
            int smallest = 1001;
            for(int j = 0; j < columns.length; j ++) {
                String[] strs = people[i].split(" ");
                smallest = Math.min(smallest, Integer.parseInt(strs[j]));
                columns[j] = Math.max(columns[j], Integer.parseInt(strs[j]));
            }
            rows[i] = smallest;
        }
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 1001;
        for(int i = 0; i < rows.length; i++) {
            res[0] = Math.max(res[0], rows[i]);
        }
        for(int j = 0; j < columns.length; j++) {
            res[1] = Math.min(res[1], columns[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        TallPeople tp = new TallPeople();
        String[] people = new String[]{"1 2",
                "4 5",
                "3 6"};
        System.out.println(Arrays.toString(tp.getPeople(people)));
    }
}
