package com.skipper.service.learn.designpattern.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author shoujian
 * Date: 2017-10-17
 * Time: 上午8:00
 */
public class PasscodeLogin implements Login {


    @Override
    public Boolean verify(String name, String password) {

        return true;
    }
}
