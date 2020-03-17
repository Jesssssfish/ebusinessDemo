package com.eb.gc.eborderserver.common.aspectJ;

import com.eb.gc.eborderserver.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Author: gc
 * Date: 2020/3/17 10:05
 * Description: 操作日志切面
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.eb.gc.eborderserver.annotation.Log)")
    public void BrokerAspect() {

    }

//    /**
//     * 前置通知
//     */
//    @Before("BrokerAspect()")
//    public void doBefore(){
//        System.out.println("------>doBefore");
//    }
//
//    /**
//     * 后置通知
//     */
//    @After("BrokerAspect()")
//    public void doAfter(){
//        System.out.println("----->doAfter");
//    }
//

//    /**
//     * 返回后通知
//     */
//    @AfterReturning("BrokerAspect()")
//    public void doAfterReturning(ProceedingJoinPoint joinPoint) {
//        System.out.println("---->doAfterReturning");
//    }

//    /**
//     * 异常通知
//     */
//    @AfterThrowing("BrokerAspect()")
//    public void doAfterThrowing() {
//        System.out.println("---->doAfterThrowing");
//    }

    /**
     * 环绕通知
     */
    @Around("BrokerAspect()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object res;
        Long time = System.currentTimeMillis();
        try {
            res = point.proceed();
            time = System.currentTimeMillis() - time;
            addOperationLog(point, null, time);
        } catch (Exception e) {
            addOperationLog(point, e, time);
            throw e;
        }
        return res;
    }

    /**
     * 添加日志
     *
     * @param joinPoint
     * @param e
     * @param time
     */
    protected void addOperationLog(final JoinPoint joinPoint, final Exception e, final Long time) {
        Log annotationLog = getAnnotationLog(joinPoint);
        if (annotationLog == null)
            return;
        if (e != null)
            System.out.println(String.format("-----保存日志:模块[%s],操作[%s],异常[%s]", annotationLog.title(),
                    annotationLog
                            .businessType().name(), e.getMessage()));
        else
            System.out.println(String.format("-----保存日志:模块[%s],操作[%s],耗时[%d]", annotationLog.title(), annotationLog
                    .businessType().name(), time));
    }

    /**
     * 获得注解
     *
     * @param joinPoint
     * @return
     */
    private Log getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method == null)
            return null;
        return method.getAnnotation(Log.class);
    }
}
