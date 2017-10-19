package com.skipper.service.learn.designpattern.state;

/**
 * Created with IntelliJ IDEA.
 * Description: 抽象状态类
 * User: shoujian
 * Date: 2017-09-30
 * Time: 下午5:45
 */
public interface State {

    /**
     * 状态对应的处理
     */
    void handle(String sampleParameter);
}
