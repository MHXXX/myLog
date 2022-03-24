package com.xmh.log.core;

import com.xmh.log.function.MyLogFunctionService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.expression.EvaluationContext;

import java.lang.reflect.Method;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:53 PM
 */
@Getter
@Setter
public class MyLogParser {

    private static final MyLogExpressionEvaluator EVALUATOR = new MyLogExpressionEvaluator();
    private MyLogFunctionService myLogFunctionService;



    public static String parseExpression(String expression, Method method, EvaluationContext evalContext) {

    }

    EvaluationContext evaluationContext = EVALUATOR.createEvaluationContext(method, args, targetClass, ret, errorMsg, beanFactory);

}
