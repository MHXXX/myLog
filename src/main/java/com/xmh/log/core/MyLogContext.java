package com.xmh.log.core;

import sun.reflect.Reflection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:54 PM
 */
public class MyLogContext {

    private static final ThreadLocal<LinkedHashMap<String, Map<String, Object>>> THREAD_LOCAL = ThreadLocal.withInitial(LinkedHashMap::new);


    public static void put(String key, Object value) {
        LinkedHashMap<String, Map<String, Object>> map = THREAD_LOCAL.get();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        map.


        Map<String, Object> paramMap = map.getOrDefault(methodName, new HashMap<>());
        paramMap.put(key, value);
    }
}
