package com.xmh.log.function;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:03 PM
 */
public class MyLogFunctionFactory {
    private final Map<String, MyLogFunction> allFunctionMap = new HashMap<>();

    public MyLogFunctionFactory(List<MyLogFunction> parseFunctions) {
        if (CollectionUtils.isEmpty(parseFunctions)) {
            return;
        }
        for (MyLogFunction parseFunction : parseFunctions) {
            if (ObjectUtils.isEmpty(parseFunction.getName())) {
                continue;
            }
            allFunctionMap.put(parseFunction.getName(), parseFunction);
        }
    }

    public MyLogFunction getFunction(String functionName) {
        return allFunctionMap.get(functionName);
    }

    public boolean isBeforeFunction(String functionName) {
        return allFunctionMap.get(functionName) != null && allFunctionMap.get(functionName).executeBefore();
    }


}
