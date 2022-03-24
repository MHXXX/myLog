package com.xmh.log.core;

import com.xmh.log.function.MyLogFunctionService;
import com.xmh.log.record.LogData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;
import org.springframework.util.StringUtils;

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

    public LogData parseExpression(MyLog myLog, Class<?> targetClass, Method method, Object[] args, Object ret, String errorMsg) {
        EvaluationContext evaluationContext = EVALUATOR.createEvaluationContext(targetClass, method, args, ret, errorMsg);
        AnnotatedElementKey annotatedElementKey = new AnnotatedElementKey(method, targetClass);
        String success = StringUtils.hasText(myLog.success()) ? EVALUATOR.parseExpression(myLog.success(), annotatedElementKey, evaluationContext) : null;
        String failed = StringUtils.hasText(myLog.failed()) ? EVALUATOR.parseExpression(myLog.failed(), annotatedElementKey, evaluationContext) : null;
        return new LogData().setSuccess(errorMsg == null).setRecord(success).setFail(failed).setOperator(null).setTimestamp(System.currentTimeMillis());
    }


}
