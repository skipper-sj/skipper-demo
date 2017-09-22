package com.skipper.service.learn.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: shoujian
 * Date: 2017-09-21
 * Time: 下午7:56
 */
public class StaticSingleton {

    private static class StaticSingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    private StaticSingleton() {

    }

    public static final StaticSingleton getInstance() {
        return StaticSingletonHolder.INSTANCE;
    }
}
