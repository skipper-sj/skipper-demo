package com.skipper.service.learn.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: shoujian
 * Date: 2017-09-21
 * Time: 上午8:22
 */
public class IdlerThreadSingleton {

    private static IdlerThreadSingleton instance;

    private IdlerThreadSingleton() {

    }

    public static IdlerThreadSingleton getInstance() {
        if (instance == null) {
            instance = new IdlerThreadSingleton();
        }
        return instance;
    }

}
