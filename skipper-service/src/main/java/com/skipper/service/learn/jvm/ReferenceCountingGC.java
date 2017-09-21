package com.skipper.service.learn.jvm;

/**
 * Created by shoujian on 2017/7/12.
 */
public class ReferenceCountingGC {

    public Object instatce = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instatce = objB;
        objB.instatce = objA;

        objA = null;
        objB = null;

        System.gc();

    }

    public static void main(String[] args) {
        testGC();

    }

}
