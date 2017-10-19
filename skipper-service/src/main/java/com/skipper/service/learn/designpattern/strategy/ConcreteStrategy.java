package com.skipper.service.learn.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * Description:环境角色
 * User: shoujian
 * Date: 2017-09-28
 * Time: 上午8:49
 */
public class ConcreteStrategy {

    public final static AddContext add = new AddContext();

    public final static DivContext div = new DivContext();

    public final static MultiContext multi = new MultiContext();

    public final static SubContext sub = new SubContext();

}
