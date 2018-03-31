package interview;

import java.util.Arrays;

/**
 * Created by lsw on 31/03/2018.
 */
public class KMPAlgo {
    public int indexOfSubString(String text, String pattern) {
        if (pattern == null || pattern.length() == 0 || pattern.length() > text.length()) {
            return -1;
        }
        // step1: construct a prefix table in O(N) time complexity
        int[] prefix = new int[pattern.length()];
        for (int i = 1, j = 0; i < pattern.length(); ++i) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefix[i] = j + 1;
                ++j;
            } else {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = prefix[j - 1];
                }
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    prefix[i] = j + 1;
                    ++j;
                }
            }
        }
        System.out.println("Prefix table: " + Arrays.toString(prefix));

        // step2: match using two pointers in O(M) time complexity
        int cur = 0, k = 0;
        while (cur < text.length() && k < pattern.length()) {
            if (text.charAt(cur) == pattern.charAt(k)) {
                ++k;
                ++cur;
                if (k == pattern.length()) {
                    return cur - pattern.length();
                }
            } else {
                if (k != 0) {
                    k = prefix[k - 1];
                } else {
                    cur += 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KMPAlgo algo = new KMPAlgo();
        //System.out.println(algo.indexOfSubString("abxabcabcaby", "abcaby"));
        System.out.println(algo.indexOfSubString("ababcaababcaabc", "ababcaabc"));
    }
}
