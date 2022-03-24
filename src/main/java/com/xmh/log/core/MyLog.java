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

    String success();

    String failed() default "";

    String category() default "";

    String detail() default "";

    String user() default "";
}
