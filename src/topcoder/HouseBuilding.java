package topcoder;

/**
 * Created by lsw on 26/06/2017.
 */
public class HouseBuilding {
    public int getMinimum(String[] area) {
        int min = Integer.MAX_VALUE;
        for (int l = 0; l < 10; l++) {
            int cost = 0;
            for (int i = 0; i < area.length; i++) {
                for (int j = 0; j < area[0].length(); j++) {
                    int val = area[i].charAt(j) - '0';
                    cost += Math.min(Math.abs(val - l), Math.abs(val - l - 1));
                }
            }
            min = Math.min(cost, min);
        }
        return min;
    }

    public static void main(String[] args) {
        HouseBuilding hb = new HouseBuilding();
        String[] area = {"5781252",
                "2471255",
                "0000291",
                "1212489"};
        System.out.println(hb.getMinimum(area));
    }
}
