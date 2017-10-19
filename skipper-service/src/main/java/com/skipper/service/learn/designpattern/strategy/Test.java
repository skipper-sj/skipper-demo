package com.skipper.service.learn.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: shoujian
 * Date: 2017-09-28
 * Time: 上午8:55
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ConcreteStrategy concreteStrategy = new ConcreteStrategy();
        System.out.println(concreteStrategy.add.operation(11, 22));
        System.out.println(concreteStrategy.multi.operation(11, 22));
        System.out.println(concreteStrategy.div.operation(11, 22));
        System.out.println(concreteStrategy.sub.operation(11, 22));
    }
}
