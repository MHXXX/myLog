package com.xmh.log.function;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:01 PM
 */
public class MyLogFunctionService {
    private final MyLogFunctionFactory factory;

    public MyLogFunctionService(MyLogFunctionFactory factory) {
        this.factory = factory;
    }

    public String apply(String functionName, Object value) {
        MyLogFunction function = factory.getFunction(functionName);
        if (function == null) {
            return String.valueOf(value);
        }

        return function.apply(value);
    }

    public boolean isBeforeFunction(String functionName) {
        return factory.isBeforeFunction(functionName);
    }

}
