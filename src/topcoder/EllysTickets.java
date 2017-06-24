package topcoder;

/**
 * Created by liusiwei on 2017/6/22.
 */
public class EllysTickets {
    public double getPrice(int[] ticketPrice, int fine) {
        double min = fine;
        int N = ticketPrice.length;
        for(int i = 0; i < N; i++) {
            if (ticketPrice[i] >= fine) {
                continue;
            }

            double cost = (i * 1.0) / N * fine + (1 - (i * 1.0) / N) * ticketPrice[i];
            min = Math.min(min, cost);
        }
        return min;
    }

    public static void main(String[] args) {
        EllysTickets et = new EllysTickets();
        int[] ticketPrice = new int[]{50, 40, 30, 20, 10};
        int fine = 42;
        System.out.println(et.getPrice(ticketPrice, fine));
    }
}
