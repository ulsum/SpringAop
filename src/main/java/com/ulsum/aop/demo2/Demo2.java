package com.ulsum.aop.demo2;

import com.ulsum.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.createUser();
    }

}
