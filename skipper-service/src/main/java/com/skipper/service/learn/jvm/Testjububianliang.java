package com.skipper.service.learn.jvm;

import java.util.Random;

/**
 * Created by shoujian on 2017/7/18.
 */
public class Testjububianliang {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[1024 * 1024 * 64];
        }
        int a = 0;
        System.gc();
        Random random = new Random();
        System.out.println(random.nextInt(2));

    }
}
