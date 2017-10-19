package com.skipper.service.learn.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * Description: 抽象策略角色
 * User: shoujian
 * Date: 2017-09-28
 * Time: 上午8:35
 */
public interface NumberOperationContext {

    Integer operation(Integer num1, Integer num2) throws Exception;
}
