package topcoder;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/6/24.
 */
public class MovieRating {
    public double calculate(int[] marks, int lowCount, int highCount) {
        Arrays.sort(marks);
        int total = 0;
        for(int i = lowCount; i < marks.length - highCount; i++) {
            total += marks[i];
        }
        return total * 1.0 / (marks.length - lowCount - highCount);
    }

    public static void main(String[] args) {
        MovieRating mr = new MovieRating();
        int[] marks = new int[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 2};
        int lowCount = 2;
        int highCount = 2;
        System.out.println(mr.calculate(marks, lowCount, highCount));
    }
}
