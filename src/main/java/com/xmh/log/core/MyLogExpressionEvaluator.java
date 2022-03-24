package com.xmh.log.core;

import com.xmh.log.function.MyLogFunctionService;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 8:53 PM
 */
public class MyLogExpressionEvaluator extends CachedExpressionEvaluator {

    private final Map<ExpressionKey, Expression> expressionCache = new ConcurrentHashMap<>(64);
    private final Map<AnnotatedElementKey, Method> targetMethodCache = new ConcurrentHashMap<>();

    public String parseExpression(String expression, AnnotatedElementKey methodKey, EvaluationContext evalContext) {
        return getExpression(this.expressionCache, methodKey, expression).getValue(evalContext, String.class);
    }

    public EvaluationContext createEvaluationContext(Class<?> targetClass, Method method, Object[] args,
                                                     Object retObj, String errorMsg) {
        Method targetMethod = getTargetMethod(targetClass, method);
        return new MyLogEvaluationContext(null, targetMethod, args, getParameterNameDiscoverer(), retObj, errorMsg);
    }

    private Method getTargetMethod(Class<?> targetClass, Method method) {
        AnnotatedElementKey methodKey = new AnnotatedElementKey(method, targetClass);
        Method targetMethod = this.targetMethodCache.get(methodKey);
        if (targetMethod == null) {
            targetMethod = AopUtils.getMostSpecificMethod(method, targetClass);
            this.targetMethodCache.put(methodKey, targetMethod);
        }
        return targetMethod;
    }
}
