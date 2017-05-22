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
        if(isLargest(digits, 0)) {
            int temp = digits[digits.length - 1];
            digits[digits.length - 1] = digits[digits.length -2];
            digits[digits.length - 2] = temp;
        }
        k--;
        n = digits2Int(digits);
        return findMax(n, k);
    }

    public int[] int2Digits(int n) {
        String str = n + "";
        int[] digits = new int[str.length()];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public int digits2Int(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int digit : digits) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }

    public boolean isLargest(int[] digits, int start) {
        if(start == digits.length - 1) return true;
        int max_index = start;
        for(int i = start + 1; i < digits.length; i++) {
            if(digits[i] >= digits[max_index]) {              // it's critical to include "="
                max_index = i;
            }
        }
        if(max_index != start && digits[max_index] != digits[start]) {
            int temp = digits[max_index];
            digits[max_index] = digits[start];
            digits[start] = temp;
            return false;
        }
        start++;
        return isLargest(digits, start);
    }

    public static void main(String[] args) {
        TheSwap ts = new TheSwap();
        System.out.println(ts.findMax(87993, 2));
    }
}
