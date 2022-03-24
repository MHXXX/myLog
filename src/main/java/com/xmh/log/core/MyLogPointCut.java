package com.xmh.log.core;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * .
 *
 * @author 谢明辉
 * @date 2022/3/24
 */

public class MyLogPointCut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        Set<MyLog> annotations = AnnotatedElementUtils.findAllMergedAnnotations(method, MyLog.class);
        return !annotations.isEmpty();
    }
}
