package com.ulsum.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component  // 标记当前类是组件
@Aspect     // 说明当前类是切面类
public class MethodChecker {

    // 环绕通知，参数为PointCut切点表达式
    @Around("execution(* com.ulsum..*Service.*(..))")
    // 【环绕通知】
    // 环绕通知可以替代 1.前置通知，2.后置通知，3.返回后通知，4.异常通知
    // ProceedingJoinPoint是JoinPoint的升级版，在原有功能外，还可以控制目标方法是否执行
    public Object check(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startTime = new Date().getTime();
            Object ret = pjp.proceed();  // 执行目标方法，返回值就是目标方法执行后的返回值
            long endTime = new Date().getTime();
            long duration = endTime - startTime;
            String className = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            if (duration >= 100) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                String now = sdf.format(new Date());
                System.out.println("<--- 环绕通知" + now + " : " + className + "." + methodName + "（" + duration + "ms）");
            }
            return ret;
        } catch (Throwable throwable) {
            // 环绕通知一般直接把内部异常直接抛出去，如果这里处理异常，那么后续的代码都不会捕捉到这个异常了
            System.out.println("Exception message：" + throwable.getMessage());
            throw throwable;
        }
    }

}
