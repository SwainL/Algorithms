package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liusiwei on 2017/6/24.
 */
public class ShipLoading {
    public int minimumTime(int[] cranes, String[] boxes) {
        Arrays.sort(cranes);
        StringBuilder sb = new StringBuilder();
        for (String str : boxes) {
            sb.append(str);
        }
        String[] nums = sb.toString().split(" ");
        List<Integer> weights = new ArrayList<>();
        for (String num : nums) {
            weights.add(Integer.parseInt(num));
        }
        Collections.sort(weights);


        int index = 0;
        int res = 0;
        int p = 0;
        for(int i = weights.size() - 1; i >= 0; i--) {
            int K = 0;
            for(int j = cranes.length - index - 1; j >= 0; j--) {
                if (cranes[j] < weights.get(i)) {
                    break;
                }
                index++;
                K++;
            }

            if(index == 0) return -1;

            int count = 1;
            while(i - 1 >= 0 && weights.get(i - 1) == weights.get(i)) {
                count++;
                i--;
            }

            if(res * K + p >= count) {
                p = (res * K + p) - count;
            } else {
                int add = (int) Math.ceil((count - (res * K + p)) * 1.0 / index);
                p = index * add - (count - (res * K + p));
                res += add;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        ShipLoading sl = new ShipLoading();
        int[] cranes = new int[] {687, 765, 400, 19, 40, 545, 986, 419, 32, 1};
        String[] boxes = new String[]{"474 794 982 788 663 608 310 286 316 91 770 902 135", " 237 443 353 490 625 507 8 727 420 668 572 341 362", " 246 622 619 449"};
        System.out.println(sl.minimumTime(cranes, boxes));
    }
}
