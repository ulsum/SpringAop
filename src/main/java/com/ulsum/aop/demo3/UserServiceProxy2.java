package com.ulsum.aop.demo3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy2 implements UserService {

    // 持有委托类的对象
    private UserService userService;

    public UserServiceProxy2(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        userService.createUser();
        System.out.println(" 后置通知 === " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + " === ");
    }

}
