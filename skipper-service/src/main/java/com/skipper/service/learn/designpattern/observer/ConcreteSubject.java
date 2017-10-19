package com.skipper.service.learn.designpattern.observer;

/**
 * Created with IntelliJ IDEA.
 * Description:具体主题角色类
 *
 * @author shoujian
 * Date: 2017-10-13
 * Time: 上午8:29
 */
public class ConcreteSubject extends Subject{
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}
