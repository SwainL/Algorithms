package topcoder;

/**
 * Created by liusiwei on 2017/6/22.
 */
public class Robofactory {
    public int reveal(int[] query, String[] answer) {
        int count = 0;

        for(int i = 0; i < query.length; i++) {
            String expect = query[i] % 2 == 0 ? "Even" : "Odd";
            if (!expect.equals(answer[i])) {
                return i;
            }

            if (i < query.length - 1 && query[i] % 2 == 0) {
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return -1;
    }
}
