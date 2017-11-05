package topcoder;

import sun.font.TrueTypeFont;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/6/17.
 */
public class ColorfulCards {
    public int[] theCards(int N, String colors) {
        boolean[] notPrimes = new boolean[N + 1];
        notPrimes[1] = true;
        for(int i = 2; i < N + 1; i++) {
            if (!notPrimes[i]) {
                for(int j = i * i; j < N + 1; j += i) {
                    notPrimes[j] = true;
                }
            }
        }

        int T = colors.length();
        int x = 0;
        int[] minPossibles = new int[T];
        for(int i = 0; i < T; i++) {
            do {
                x++;
            } while (notPrimes[x] != (colors.charAt(i) == 'B'));
            minPossibles[i] = x;
        }

        x = N + 1;
        int[] maxPossibles = new int[T];
        for(int i = T - 1; i >= 0; i--) {
            do {
                x--;
            } while (notPrimes[x] != (colors.charAt(i) == 'B'));
            maxPossibles[i] = x;
        }

        for(int i = 0; i < T; i++) {
            minPossibles[i] = minPossibles[i] == maxPossibles[i] ? minPossibles[i] : -1;
        }


        return minPossibles;
    }


    public static void main(String[] args) {
        ColorfulCards colorfulCards = new ColorfulCards();
        int[] res = colorfulCards.theCards(58, "RBRRBRBBRBRRBBRRBBBRRBBBRR");
        System.out.println(Arrays.toString(res));
    }
}
