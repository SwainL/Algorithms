package practice;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/4/18.
 */
public class SumFullSet {
    public String isSumFullSet(int[] elements) {
        Arrays.sort(elements);
        int index_0 = -1;
        for(int i = 0; i < elements.length; i++) {
            if(elements[i] == 0) {
                index_0 = i;
            }
        }
        if(index_0 == -1) {
            return "not closed";
        }

        if(index_0 == 0) {
            if(elements.length < 2 || elements[1] == elements[elements.length - 1]) {
                return "closed";
            }
        }

        if(index_0 == elements.length -1) {
            if(elements.length < 2 || elements[0] == elements[elements.length - 2]) {
                return "closed";
            }
        }

        if(elements[0] == elements[index_0 -1] && elements[index_0 + 1] == elements[elements.length -1]) {
            return "closed";
        }

        return "not closed";
    }

    public static void main(String[] args) {
        SumFullSet sfs = new SumFullSet();
        System.out.print(sfs.isSumFullSet(new int[]{10}));
    }
}
