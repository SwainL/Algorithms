package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class HealthFood {

    class Dish {
        int protein;
        int carbs;
        int fat;
        int calories;
        int index;

        public Dish(int p, int c, int f, int i) {
            protein = p;
            carbs = c;
            fat = f;
            index = i;
            calories = 9 * f + 5 * (c + p);
        }

        public String toString() {
            return "p = " + protein + ", c = " + carbs + ", f = " + fat + ", t = " + calories + ", ind = " + index;
        }

        public boolean lessThan(Dish d, char c) {
            switch (c) {
                case 'P':
                    return protein < d.protein;
                case 'p':
                    return d.protein < protein;
                case 'C':
                    return carbs < d.carbs;
                case 'c':
                    return d.carbs < carbs;
                case 'F':
                    return fat < d.fat;
                case 'f':
                    return d.fat < fat;
                case 'T':
                    return calories < d.calories;
                case 't':
                    return d.calories < calories;
                case 'i':
                    return d.index < index;
                default:
                    return false;
            }
        }
    }

    class MyComparator implements Comparator {
        String sortString = null;

        public MyComparator(String s) {
            sortString = s + "i";
        }

        public int compare(Object o1, Object o2) {
            if (o1 == o2) return 0;
            Dish d1 = (Dish) o1;
            Dish d2 = (Dish) o2;
            for (int i = 0; i < sortString.length(); i++) {
                if (d1.lessThan(d2, sortString.charAt(i)))
                    return 1;
                if (d2.lessThan(d1, sortString.charAt(i)))
                    return -1;
            }
            return -1;
        }
    }

    public int returnIndexFor(String dietPlan, Dish[] ds) {
        MyComparator mc = new MyComparator(dietPlan);
        TreeSet ts = new TreeSet(mc);
        for (int i = 0; i < ds.length; i++) {
            ts.add(ds[i]);
        }
        for (Iterator i = ts.iterator(); i.hasNext(); ) {
            Dish d = (Dish) i.next();
            return d.index;
        }
        return -1;
    }

    public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
        Dish[] ds = new Dish[protein.length];
        for (int i = 0; i < protein.length; i++) {
            ds[i] = new Dish(protein[i], carbs[i], fat[i], i);
        }
        int[] res = new int[dietPlans.length];
        for (int j = 0; j < dietPlans.length; j++) {
            res[j] = returnIndexFor(dietPlans[j], ds);
        }
        return res;
    }


    public static void main(String[] args) {
        HealthFood hf = new HealthFood();
        System.out.println(Arrays.toString(hf.selectMeals(new int[]{3, 4, 1, 5},
                new int[]{2, 8, 5, 1},
                new int[]{5, 2, 4, 4},
                new String[]{"tFc", "tF", "Ftc"})));
    }

} 