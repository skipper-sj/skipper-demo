package com.skipper.service.learn.designpattern.state;

/**
 * Created with IntelliJ IDEA.
 * Description:具体状态类
 * User: shoujian
 * Date: 2017-09-30
 * Time: 下午5:49
 */
public class ConcreteStateB implements State {
    @Override
    public void handle(String sampleParameter) {
        System.out.println("ConcreteStateB handle ：" + sampleParameter);
    }
}
