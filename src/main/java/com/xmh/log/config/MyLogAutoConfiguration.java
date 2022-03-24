package com.xmh.log.config;

import com.xmh.log.function.MyLogFunction;
import com.xmh.log.function.MyLogFunctionFactory;
import com.xmh.log.function.MyLogFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:12 PM
 */

public class MyLogAutoConfiguration implements ImportAware {


    @Bean
    public MyLogFunctionService myLogFunctionService(MyLogFunctionFactory factory) {
        return new MyLogFunctionService(factory);
    }

    @Bean
    public MyLogFunctionFactory myLogFunctionFactory(List<MyLogFunction> functionList) {
        return new MyLogFunctionFactory(functionList);
    }


    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println("***************");
        System.out.println("MY LOG !!!");
        System.out.println("***************");
    }

}
