package com.xmh.log.core;

import java.lang.reflect.Field;
import java.util.Collections;
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


    private MyLogContext() {

    }

    public static void put(String key, Object value) {
        LinkedHashMap<String, Map<String, Object>> map = THREAD_LOCAL.get();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Map<String, Object> paramMap = map.getOrDefault(methodName, new HashMap<>());
        paramMap.put(key, value);
        map.put(methodName, paramMap);
    }

    public static Map<String, Object> getVariables() {
        return removeTail();
    }

    private static Map<String, Object> removeTail() {
        LinkedHashMap<String, Map<String, Object>> map = THREAD_LOCAL.get();
        try {
            Field tail = map.getClass().getDeclaredField("tail");
            tail.setAccessible(true);
            Map.Entry<String, Map<String, Object>> entry = (Map.Entry<String, Map<String, Object>>) tail.get(map);
            if (entry != null) {
                map.remove(entry.getKey());
                return entry.getValue();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}
