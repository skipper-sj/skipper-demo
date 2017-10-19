package com.skipper.service.learn.designpattern.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author shoujian
 * Date: 2017-10-17
 * Time: 上午8:04
 */
public class Test {

    public static void main(String[] args) {
        String loginType = "password";
        String name = "name";
        String password = "password";
        Login login = LoginManager.factory(loginType);
        boolean bool = login.verify(name, password);
        System.out.println(login.getClass().getName());
    }

}
