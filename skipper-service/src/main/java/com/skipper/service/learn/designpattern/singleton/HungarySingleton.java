package com.skipper.service.learn.designpattern.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: shoujian
 * Date: 2017-09-21
 * Time: 上午8:26
 */
public class HungarySingleton {
    private static HungarySingleton instance;

    private HungarySingleton() {

    }

    public static HungarySingleton GetInstance() {
        return instance;
    }
}
