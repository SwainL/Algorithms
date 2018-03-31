package hackerrank;

import java.util.*;

class TestClass {
    static class Period {
        long numerator;
        long denominator;

        Period(long nu, long de) {
            this.numerator = nu;
            this.denominator = de;
        }

        public long compares(Period p) {
            return this.numerator * p.denominator - this.denominator * p.numerator;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String args[] ) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] times = new int[N];
        int[] speeds = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = scanner.nextInt();
            speeds[i] = scanner.nextInt();
        }

        int[] sum = new int[N];   // sum[i] denotes the sum of speeds from [T0, Ti)
        sum[0] = 0;
        for(int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + speeds[i -1] * (times[i] - times[i - 1]);
        }

        Period[] starts = new Period[N];
        int rptr = 1;
        for(int i = 0; i < N; i++) {
            int target = sum[i] + S;
            while(rptr < N && sum[rptr] < target) rptr++;
            long denominator = 1;
            long numerator = 0;
            if(rptr >= N) {
                denominator = speeds[N - 1];
                numerator = (times[N - 1] - times[i]) * denominator + target - sum[N - 1];
            } else if(sum[rptr] == target) {
                numerator = times[rptr] - times[i];
            } else {
                denominator = speeds[rptr];
                numerator = (times[rptr - 1] - times[i]) * denominator + target - sum[rptr - 1];
            }
            starts[i] = new Period(numerator, denominator);
        }


        for(int i = 0; i < N; i++) {
            System.out.println(starts[i]);
        }
    }
}
