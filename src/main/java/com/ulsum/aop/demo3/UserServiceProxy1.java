package com.ulsum.aop.demo3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy1 implements UserService {

    // 持有委托类的对象
    private UserService userService;

    public UserServiceProxy1(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        System.out.println(" 前置通知 === " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + " === ");
        userService.createUser();
    }

}
