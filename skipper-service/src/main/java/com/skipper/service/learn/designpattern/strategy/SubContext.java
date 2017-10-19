package com.skipper.service.learn.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * Description:具体策略角色
 * User: shoujian
 * Date: 2017-09-28
 * Time: 上午8:41
 */
public class SubContext implements NumberOperationContext {
    @Override
    public Integer operation(Integer num1, Integer num2) {
        return num1 - num2;
    }
}
