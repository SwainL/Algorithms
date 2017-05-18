package topcoder;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/4/26.
 */
public class Zoo {
    public long theCount(int[] answers) {
        int twos = 0, ones = 0;
        int[] cnt = new int[41];

        for(int i = 0; i < answers.length; i++) {
            cnt[answers[i]]++;
        }
        if(cnt[0] == 0) return 0;
        for(int i = 0; i < 39; i++) {
            if(cnt[i] > 2) return 0;
            else if(cnt[i + 1] > cnt[i]) return 0;
            else if(cnt[i] == 2) {
                twos++;
            }
            else if(cnt[i] == 1){
                ones++;
            }
        }
        return (long)(Math.pow(2, twos) * (ones > 0 ? 2 : 1));

    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        System.out.println(zoo.theCount(new int[] {40, 40}));
    }


}
