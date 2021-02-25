package com.ulsum.aop.demo3;

public class Demo3 {

    public static void main(String[] args) {
        UserService userService = new UserServiceProxy2(new UserServiceProxy1(new UserServiceImpl()));
        userService.createUser();
    }

}
