package com.skipper.service.learn.designpattern.state;

/**
 * Created with IntelliJ IDEA.
 * Description:客户端类
 * User: shoujian
 * Date: 2017-09-30
 * Time: 下午5:49
 */
public class Client {

    public static void main(String[] args) {
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        for (int i = 0; i < 10; i++) {
            context.request("test");
        }
    }
}
