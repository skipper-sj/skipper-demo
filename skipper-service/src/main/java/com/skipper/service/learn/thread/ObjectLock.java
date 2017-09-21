package com.skipper.service.learn.thread;

import java.util.HashMap;

/**
 * Created by shoujian on 2017/6/22.
 */
public class ObjectLock {
    // index属性来标记当前打印的次数
    private int index;
    // isPrint用来标记是否被打印
    private boolean isPrint;

    private HashMap<Character, Long> counterMap = new HashMap<Character, Long>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isPrint() {
        return isPrint;
    }

    public void setPrint(boolean isPrint) {
        this.isPrint = isPrint;
    }

    public HashMap<Character, Long> getCounterMap() {
        return counterMap;
    }

    public void setCounterMap(HashMap<Character, Long> counterMap) {
        this.counterMap = counterMap;
    }

}
