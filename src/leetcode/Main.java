package leetcode;

import java.util.Arrays;
import java.util.Scanner;


public class Main implements Runnable{

    int val = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 200; ++i) {
            val += 1;
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.start();
        t1.join();
        System.out.println(m.val);
        t2.start();
        t2.join();
        System.out.println(m.val);
    }



}
