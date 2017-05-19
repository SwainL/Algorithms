package topcoder;

import java.util.Arrays;

/**
 * Created by liusiwei on 2017/5/15.
 */
public class HealthFood {
    public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
        int[] result = new int[dietPlans.length];
        int[] calories = new int[protein.length];
        for (int i = 0; i < calories.length; i++) {
            calories[i] = 5 * protein[i] + 5 * carbs[i] + 9 * fat[i];
        }
        for (int i = 0; i < dietPlans.length; i++) {
            String plan = dietPlans[i];
            if (plan.length() == 0) result[i] = 0;
            else {
                for (char criteria : plan.toCharArray()) {
                    if (criteria == 'c') {

                    }
                }
            }
        }

        return null;
    }




}
