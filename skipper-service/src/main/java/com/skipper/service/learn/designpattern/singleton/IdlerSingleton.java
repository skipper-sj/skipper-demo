package com.skipper.service.learn.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:懒汉式单例模式
 * User: shoujian
 * Date: 2017-09-21
 * Time: 上午8:10
 */
public class IdlerSingleton {

    private static IdlerSingleton instance;

    private IdlerSingleton() {

    }

    public static IdlerSingleton getInstance() {
        if (instance == null) {
            instance = new IdlerSingleton();
        }
        return instance;
    }
}
