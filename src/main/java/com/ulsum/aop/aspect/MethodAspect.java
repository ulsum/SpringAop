package com.ulsum.aop.aspect;

import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

// 切面类
public class MethodAspect {

    // 切面方法，用于扩展额外功能
    // JoinPoint连接点，通过连接点可以获取目标类、方法的信息

    // 【前置通知】
    public void printExecutionTime(JoinPoint joinPoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        // 获取目标对象 > 获取对象的类 > 获取对象类的名字
        String className = joinPoint.getTarget().getClass().getName();
        // 获取目标执行的方法 > 获取方法的名称
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---> " + now + " : " + className + "." + methodName);
        Object[] args = joinPoint.getArgs();
        System.out.println("---> 参数个数：" + args.length);
        for (Object arg : args) {
            System.out.println("---> 参数 = " + arg);
        }
    }

    // 【后置通知】
    // 后置通知无法获取到运行时产生的返回值，或内部抛出的异常，这时候就需要返回后通知和异常通知进行处理
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("<--- 触发后置通知");
    }

    // 【返回后通知】
    // 参数1：连接点，参数2：返回值
    // 返回后通知、后置通知、异常通知的运行运行顺序是靠applicationContext.xml配置的前后顺序决定的
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("<--- 返回后通知" + ret);
    }

    // 【异常通知】
    // 参数1：连接点，参数2：异常
    // 返回后通知、后置通知、异常通知的运行运行顺序是靠applicationContext.xml配置的前后顺序决定的
    public void doAfterThrowing(JoinPoint joinPoint, Throwable th){
        System.out.println("<--- 异常通知" + th.getMessage());
    }

}
