package org.happybean.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author wgt
 * @date 2019-03-19
 * @description 日志切面类
 * 通知方法：前置：方法运行前
 * 后置：方法运行后
 * 异常：方法运行异常
 * 返回：方法返回后
 * 环绕：动态代理，手动推进方法进行
 **/
//@Aspect 告诉spring这是一个切面类
@Aspect
public class LogAspect {

    //公共切点
    @Pointcut("execution(public int org.happybean.service.Calculator.div(int,int))")
    private void pointCut() {

    }

    //("public int  org.happybean.service.Calculator.div(int,int)") 切入点 具体表达式可自学
    @Before(value = "execution(public int org.happybean.service.Calculator.div(int,int))")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "start");
    }

    @After(value = "execution(public int org.happybean.service.Calculator.div(int,int))")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "end");
    }

    //returning = "result" 用以指定接收返回值的参数
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("result：" + result);
    }

    //throwing = "e" 用以接收异常返回
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(Exception e) {
        System.out.println("exception：" + e);
    }
}
