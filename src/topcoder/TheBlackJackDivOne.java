package topcoder;


/**
 * Created by liusiwei on 2017/5/19.
 */
public class TheBlackJackDivOne {

    public double expected(String[] cards) {
        int total = 52;
        int[] count = new int[12];
        for(int i = 2; i < 10; i++) {
            count[i] = 4;
        }
        count[10] = 12;
        count[11] = 4;
        int score = 0;
        for(String card : cards) {
            char c = card.charAt(0);
            int value = 0;
            if(c >= 2 && c <= 9) {
                value = c - '0';
            } else if(c == 'A') {
                value = 11;
            } else {
                value = 10;
            }
            score += value;
            count[value] --;
            total --;
        }
        return solve(score, count);
    }

    public double solve(int score, int[] count) {
        if(score >= 21) {
            return 0.0;
        }

        //double result = 0;

        for(int i = 2; i <= 11; i++) {
            if(count[i] > 0) {
                double prob = count[i] * 1.0 / ( total -- );
                count[i] --;
                result += prob * (1 + solve(score + i, count));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TheBlackJackDivOne tbjdo = new TheBlackJackDivOne();
        System.out.println(tbjdo.expected(new String[] {"2D", "7S"}));
    }
}
