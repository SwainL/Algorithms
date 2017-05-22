package practice;

/**
 * Created by liusiwei on 2017/4/18.
 */
public class ThreeProgrammers {

    public String validCodeHistory(String s) {
        int N = s.length();
        /*int[] cnts = new int[3];
        for(int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'A']++;
        }*/

        int A = 0;
        int B = 0;
        int C = 0;
        for(int i = 0; i < s.length(); i++) {
            A += s.charAt(i) == 'A' ? 1 : 0;
            B += s.charAt(i) == 'B' ? 1 : 0;
            C += s.charAt(i) == 'C' ? 1 : 0;
        }

        StringBuilder builder = new StringBuilder();

        for(; N > 0; N--) {
            if(N < 3 * C - 2 || N < 2 * B - 1) {
                return "impossible";
            }

            if(N == 3 * C - 2 && (builder.length() == 0 || builder.charAt(builder.length() - 1) != 'C')  && (builder.length() <= 1 || builder.charAt(builder.length() -2) != 'C')) {
                builder.append('C');
                C--;
            }
            else if(N == 2 * B - 1 && (builder.length() == 0 || builder.charAt(builder.length() - 1) != 'B')) {
                builder.append('B');
                B--;
            }
            else if(C > 0 && (builder.length() == 0 || builder.charAt(builder.length() - 1) != 'C')  && (builder.length() <= 1 || builder.charAt(builder.length() -2) != 'C')) {
                builder.append('C');
                C--;
            }
            else if(B > 0 && (builder.length() == 0 || builder.charAt(builder.length() - 1) != 'B')) {
                builder.append('B');
                B--;
            }
            else if(A > 0) {
                builder.append('A');
                A--;
            }
            else{
                return "impossible";
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ThreeProgrammers tps = new ThreeProgrammers();
        String result = tps.validCodeHistory("ACAC");
        System.out.println(result);
    }

}
