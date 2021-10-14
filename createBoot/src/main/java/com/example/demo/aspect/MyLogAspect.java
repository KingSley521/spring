package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Aspect
@Component
@Slf4j
public class MyLogAspect {

    //设置切入点
    //表示该切入点切在一个注解上，@annotation后面带该注解的全类名
    //切面最主要的就是切入点，所有的故事都围绕切入点发生
    //logPointCut()代表切入点名称
    @Pointcut("@annotation(com.example.demo.annotation.MyLog)")
    public void loginCut(){}


    /**
     * 对于controller包中所有方法来说，以下两种表达式都是生效的
     */
    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    //@Pointcut("within(com.example.demo.controller.*)")
    public void commonCut(){
        log.info("commonCut生效----------->");
    }

    @Before("commonCut()")
    public void before(){
        log.info("before----------------->");

    }

    @After("commonCut()")
    public void after(){
        log.info("after---------------->");
    }

    //通知
    @Around("loginCut()")
    public void logAround(ProceedingJoinPoint point){
        //获取方法名称
        String methodName = point.getSignature().getName();
        //获取入参
        Object[] args = point.getArgs();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }
        System.out.println("进入方法："+ methodName + "，参数为:" + stringBuilder);

        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("方法："+ methodName + "执行结束");
    }
}
