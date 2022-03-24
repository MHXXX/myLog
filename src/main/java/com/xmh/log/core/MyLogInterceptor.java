package com.xmh.log.core;

import com.xmh.log.record.LogData;
import com.xmh.log.record.MyLogRecordService;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.expression.EvaluationContext;

import java.lang.reflect.Method;
import java.util.*;

/**
 * .
 *
 * @author 谢明辉
 * @date 2022/3/24
 */

@Slf4j
public class MyLogInterceptor implements MethodInterceptor {

    private MyLogParser logParser;
    private MyLogRecordService logRecordService;


    public MyLogRecordService getLogRecordService() {
        return logRecordService;
    }

    public void setLogRecordService(MyLogRecordService logRecordService) {
        this.logRecordService = logRecordService;
    }

    public MyLogParser getLogParser() {
        return logParser;
    }

    public void setLogParser(MyLogParser logParser) {
        this.logParser = logParser;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object proceed = null;
        Throwable throwable = null;
        try {
            proceed = invocation.proceed();
        } catch (Exception e) {
            throwable = e;
        }
        Method method = invocation.getMethod();
        Class<?> targetClass = invocation.getThis() == null ? null : AopProxyUtils.ultimateTargetClass(invocation.getThis());
        MyLog myLog = method.getAnnotation(MyLog.class);
        // 记录日志
        records(myLog, targetClass, method, invocation.getArguments(), proceed, throwable);
        if (throwable != null) {
            throw throwable;
        }
        return proceed;
    }


    private void records(MyLog myLog, Class<?> targetClass, Method method, Object[] args, Object retObj, Throwable throwable) {
        try {
            LogData logData = logParser.parseExpression(myLog, targetClass, method, args, retObj, throwable == null ? null : throwable.getMessage());
            logRecordService.record(logData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
