package com.skipper.service.learn.spring;

import com.skipper.service.demo.service.impl.DemoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: shoujian
 * Date: 2017-09-11
 * Time: 下午7:44
 */
public class SpringStart {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        ac.getBean(DemoServiceImpl.class);
    }

}
