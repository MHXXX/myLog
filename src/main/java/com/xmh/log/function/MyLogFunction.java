package com.xmh.log.function;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:04 PM
 */
public interface MyLogFunction {

    default boolean executeBefore() {
        return true;
    }

    String getName();

    String apply(Object value);
}
