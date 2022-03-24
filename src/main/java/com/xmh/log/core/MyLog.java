package com.xmh.log.core;


/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:31 PM
 */
public @interface MyLog {

    String content();

    String category() default "";

    String detail() default "";

    String user() default "";
}
