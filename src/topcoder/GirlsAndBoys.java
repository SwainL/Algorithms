package topcoder;

/**
 * Created by liusiwei on 2017/6/19.
 */
public class GirlsAndBoys {
    public int sortThem(String row) {
        int count_B = 0;
        int count_G = 0;
        for(int i = 0, j = 0, k = 0; i < row.length(); i++) {
            if (row.charAt(i) == 'B') {
                count_B += i - j;
                j++;
            } else {
                count_G += i - k;
                k++;
            }
        }
        return Math.min(count_B, count_G);

    }

    public static void main(String[] args) {
        GirlsAndBoys gnb = new GirlsAndBoys();
        System.out.println(gnb.sortThem("BGBGBGBGGGBBGBGBGG"));
    }

}
