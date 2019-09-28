package cn.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志的工具类，提供公共代码
 */
@Component("logger")
@Aspect //表示切面
public class Logger {

    //使用注解同样耀加入表达式
    @Pointcut("execution(* cn.service.impl.*.*(..))")
    private void ptl(){}

    /**
     * 环绕通知:
     *  引发问题：切入点方法没有执行，而通知方法执行了
     *  分析：对比动态代理中的环绕通知代码：
     *          动态代理：有明确的切入点方法调用，我们的代码中没有
     *   解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知另外的解释： 手动实现，而不用配置
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */

    @Around("ptl()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs(); // 得到方法执行所需的参数

            System.out.println("环绕通知：Logger类中的afterPrintLog方法开始记录日志。。 前");

            rtValue = pjp.proceed(args);//明确调用业务层切入点方法

            System.out.println("环绕通知：Logger类中的afterPrintLog方法开始记录日志。。 后");

            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知：Logger类中的afterPrintLog方法开始记录日志。。 异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知：Logger类中的afterPrintLog方法开始记录日志。。 最终");
        }
    }
    /*// 打印日志，在切入点方法执行前执行（业务层方法）
    @Before("ptl()")
    public void beforPrintLog(){
        System.out.println("前置通知：Logger类中的beforPrintLog方法开始记录日志。。");
    }
    @AfterReturning("ptl()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知：Logger类中的afterReturningPrintLog方法开始记录日志。。");
    }
    @AfterThrowing("ptl()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知：Logger类中的afterThrowingPrintLog方法开始记录日志。。");
    }
    @After("ptl()")
    public void afterPrintLog(){
        System.out.println("最终通知：Logger类中的afterPrintLog方法开始记录日志。。");
    }*/

}
