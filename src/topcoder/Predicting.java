package topcoder;

import static java.lang.Math.*;

/**
 * Created by liusiwei on 2017/5/1.
 */
public class Predicting {
    public double avgError(double[] data) {
        double vs[] = new double[]{-1,-.9,-.8,-.7,-.6,-.5,-.4,-.3,-.2,-.1,
                0,.1,.2,.3,.4,.5,.6,.7,.8,.9,1};
        double best = 1e18;
        for(double a:vs)
            for(double b:vs)
                for(double c:vs)
                    for(double d:vs)
                        for(double e:vs) {
                            if(abs(1-e-d-b-c-a)>1e-8) continue;
                            double score = 0;
                            for(int i=5;i<data.length;i++) {
                                double p = a*data[i-5]+ b * data[i - 4] + c * data[i - 3] + d * data[i - 2] + e * data[i - 1];
                                score += abs(p - data[i]);
                            }
                            best = min(best,score);
                        }
        return best/(data.length-5);
    }



    public static void main(String[] args) {
        Predicting predictor = new Predicting();
        System.out.println(predictor.avgError(new double[] {50, 60, 50, 60, 50, 60, 60}));
    }
}
