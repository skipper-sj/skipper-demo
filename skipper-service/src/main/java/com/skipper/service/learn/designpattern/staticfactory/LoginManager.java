package com.skipper.service.learn.designpattern.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author shoujian
 * Date: 2017-10-17
 * Time: 上午8:01
 */
public class LoginManager {

    public static Login factory(String type) {
        if ("passcode".equals(type)) {
            return new PasscodeLogin();
        } else if ("password".equals(type)) {
            return new PasswordLogin();
        } else {
            throw new RuntimeException("没有找到对应的登录类型");
        }
    }

}
