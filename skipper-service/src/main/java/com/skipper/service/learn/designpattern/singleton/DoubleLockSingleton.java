package com.skipper.service.learn.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: shoujian
 * Date: 2017-09-21
 * Time: 下午7:48
 */
public class DoubleLockSingleton {

    private volatile static DoubleLockSingleton singleton;

    private DoubleLockSingleton() {

    }

    public static DoubleLockSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleLockSingleton.class){
                if (singleton == null) {
                    singleton = new DoubleLockSingleton();
                }
            }
        }
        return singleton;
    }
}
