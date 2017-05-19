package topcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by liusiwei on 2017/5/15.
 */
public class HealthFood {
    public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
        int[] calories = new int[protein.length];
        for (int i = 0; i < calories.length; i++) {
            calories[i] = 5 * protein[i] + 5 * carbs[i] + 9 * fat[i];

        }
        int[] res = new int[dietPlans.length];
        for (int i = 0; i < dietPlans.length; i++) {

        }

        return null;
    }

    public int bestDiet(Diet[] diets, String dietPlan) {
        MyComparator mc = new MyComparator(dietPlan);
        TreeSet<Diet> ts = new TreeSet<>(mc);
        for(Diet diet : diets) {
            ts.add(diet);
        }

        for(Diet diet : ts) {
            return diet.index;
        }

        return -1;
    }


    class Diet {
        private int protein;
        private int carbs;
        private int fat;
        private int calories;
        private int index;

        Diet(int protein, int carbs, int fat, int index) {
            this.protein = protein;
            this.carbs = carbs;
            this.fat = fat;
            this.calories = protein * 5 + carbs * 5 + fat * 9;
            this.index = index;
        }

        public boolean lessThan(Diet diet, char c) {
            switch (c) {
                case 't' :
                    return this.calories < calories;
                case 'T' :
                    return calories < this.calories;
                case 'p' :
                    return this.protein < protein;
                case 'P' :
                    return protein < this.protein;
                case 'c' :
                    return this.carbs < carbs;
                case 'C' :
                    return carbs < this.carbs;
                case 'f' :
                    return this.fat < fat;
                case 'F' :
                    return fat < this.fat;
                case 'i' :
                    return this.index < index;
                default:
                    return false;
            }
        }
    }

    class MyComparator implements Comparator {
        private String sortString;

        MyComparator(String s) {
            this.sortString = s + 'i';
        }

        @Override
        public int compare(Object o1, Object o2) {
            if(o1 == o2) return 0;
            Diet d1 = (Diet) o1;
            Diet d2 = (Diet) o2;
            for(char c : sortString.toCharArray()) {
                if(d1.lessThan(d2, c))
                    return 1;
                if(d2.lessThan(d1, c))
                    return -1;
            }
            return -1;
        }
    }





}
