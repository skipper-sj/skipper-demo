package com.skipper.service.learn.designpattern.state;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:环境角色类
 * User: shoujian
 * Date: 2017-09-30
 * Time: 下午5:45
 */
public class Context {

    //持有一个State类型的对象实例
    private State state;

    private Integer count = 0;

    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        if (count < 3) {
            state = new ConcreteStateA();
            count++;
        } else {
            state = new ConcreteStateB();
            count++;
        }
        //转调state来处理
        state.handle(sampleParameter);
    }
}
