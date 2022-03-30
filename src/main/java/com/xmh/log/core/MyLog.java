package com.xmh.log.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:31 PM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    /**
     * 正常情况下的日志记录 SpEL 表达式
     */
    String value();

    /**
     * 异常情况下的日志记录 SpEL 表达式
     */
    String failed() default "";

    String category() default "";

    String detail() default "";

    String user() default "";
}
