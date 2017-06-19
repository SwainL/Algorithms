package topcoder;

/**
 * Created by liusiwei on 2017/6/17.
 */
public class RowAndCoins {
    public String getWinner(String cells) {
        int[] counts = new int[2];
        if (cells.charAt(0) == 'A') {
            counts[0] = 1;
        } else {
            counts[1] = 1;
        }
        for(int i = 1; i < cells.length(); i++) {
            if (cells.charAt(i - 1) != cells.charAt(i)) {
                if (cells.charAt(i) == 'A') {
                    counts[0]++;
                } else {
                    counts[1]++;
                }
            }
        }

        if (counts[0] >= counts[1]) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static void main(String[] args) {
        RowAndCoins rowAndCoins = new RowAndCoins();
        System.out.println(rowAndCoins.getWinner("BBBB"));
    }
}
