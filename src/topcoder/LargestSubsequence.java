package topcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liusiwei on 2017/6/17.
 */
public class LargestSubsequence {
    public String getLargest(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new ArrayList<Integer>());
            }
            map.get(s.charAt(i)).add(i);
        }
        StringBuilder sb = new StringBuilder();
        int lastPosit = -1;
        for(int i = 25; i >= 0; i--) {
            char c = (char) ('a' + i);
            if (map.containsKey(c)) {
                for(int j = 0; j < map.get(c).size(); j++) {
                    if (map.get(c).get(j) > lastPosit) {
                        sb.append(c);
                        lastPosit = map.get(c).get(j);
                    }
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestSubsequence ls = new LargestSubsequence();
        //System.out.println(ls.getLargest("aquickbrownfoxjumpsoverthelazydog"));
        System.out.println(ls.getLargest("example"));
    }
}
