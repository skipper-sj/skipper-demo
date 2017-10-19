package com.skipper.service.learn.designpattern.observer;

/**
 * Created with IntelliJ IDEA.
 * Description:抽象观察者角色类
 *
 * @author shoujian
 * Date: 2017-10-13
 * Time: 上午8:27
 */
public interface Observer {

    /**
     * 更新接口
     *
     * @param state 更新的状态
     */
    void update(String state);

}
