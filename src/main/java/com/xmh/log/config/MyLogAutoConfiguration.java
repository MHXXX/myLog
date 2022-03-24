package com.xmh.log.config;

import com.xmh.log.core.MyLogInterceptor;
import com.xmh.log.core.MyLogParser;
import com.xmh.log.core.MyLogPointCut;
import com.xmh.log.function.MyLogFunction;
import com.xmh.log.function.MyLogFunctionFactory;
import com.xmh.log.function.MyLogFunctionService;
import com.xmh.log.record.DefaultLogRecordServiceImpl;
import com.xmh.log.record.MyLogRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:12 PM
 */

@Slf4j
public class MyLogAutoConfiguration {

    @Bean
    public DefaultPointcutAdvisor optLogPointcutAdvisor(MyLogInterceptor myLogInterceptor, MyLogPointCut pointCut) {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(myLogInterceptor);
        advisor.setPointcut(pointCut);
        return advisor;
    }

    @Bean
    public MyLogFunctionService myLogFunctionService(MyLogFunctionFactory factory) {
        return new MyLogFunctionService(factory);
    }

    @Bean
    public MyLogPointCut myLogPointCut() {
        return new MyLogPointCut();
    }

    @Bean
    public MyLogFunctionFactory myLogFunctionFactory(List<MyLogFunction> functionList) {
        return new MyLogFunctionFactory(functionList);
    }

    @Bean
    public MyLogParser myLogParser(MyLogFunctionService myLogFunctionService) {
        MyLogParser myLogParser = new MyLogParser();
        myLogParser.setMyLogFunctionService(myLogFunctionService);
        return myLogParser;
    }

    @Bean
    @ConditionalOnMissingBean(MyLogRecordService.class)
    public MyLogRecordService myLogRecordService() {
        return new DefaultLogRecordServiceImpl();
    }

    @Bean
    public MyLogInterceptor myLogInterceptor(MyLogParser myLogParser, MyLogRecordService myLogRecordService) {
        MyLogInterceptor interceptor = new MyLogInterceptor();
        interceptor.setLogParser(myLogParser);
        interceptor.setLogRecordService(myLogRecordService);
        return interceptor;
    }

    @PostConstruct
    public void setImportMetadata() {
        System.out.println("***************");
        System.out.println("MY LOG !!!");
        System.out.println("***************");
    }

}
