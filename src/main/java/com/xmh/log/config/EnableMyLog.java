package com.xmh.log.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:15 PM
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyLogAutoConfiguration.class)
public @interface EnableMyLog {
}
