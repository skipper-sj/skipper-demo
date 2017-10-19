package com.skipper.service.learn.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * Description:具体策略角色
 * User: shoujian
 * Date: 2017-09-28
 * Time: 上午8:45
 */
public class MultiContext implements NumberOperationContext {

    @Override
    public Integer operation(Integer num1, Integer num2) throws Exception {
        return num1 * num2;
    }
}
