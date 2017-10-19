package com.skipper.service.learn.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * Description:具体策略角色
 * User: shoujian
 * Date: 2017-09-28
 * Time: 上午8:42
 */
public class DivContext implements NumberOperationContext {
    @Override
    public Integer operation(Integer num1, Integer num2) throws Exception {
        if (num2 == 0) {
            throw new Exception();
        }
        return num1 / num2;
    }
}
