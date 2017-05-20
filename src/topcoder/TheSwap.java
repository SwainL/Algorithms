package topcoder;

import java.util.Arrays;

/**
 * Created by lsw on 19/05/2017.
 */
public class TheSwap {
    public int findMax(int n, int k) {
        if(k == 0) return n;
        if(n < 10 || (n < 100 && n % 10 == 0)) return -1;
        int[] digits =  int2Digits(n);

        return 0;
    }

    public int[] int2Digits(int n) {
        String str = n + "";
        int[] digits = new int[str.length()];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public boolean isLargest(int[] digits) {
        if(digits.length == 1) return true;
        int first = digits[0];
        for(int digit : digits) {
            if(digit > first) {
                return false;
            }
        }
        return isLargest(Arrays.copyOfRange(digits, 1, digits.length));
    }

    public static void main(String[] args) {
        TheSwap ts = new TheSwap();
        System.out.println(ts.isLargest(ts.int2Digits(76531)));
    }
}
