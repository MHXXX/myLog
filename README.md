# myLog
基于 SpEL 的日志框架

# 功能
1. 通过切面实现日志的记录
2. 支持自定义方法, 实现 `MyLogFunction` 接口并装配到 Spring 中
    ```java
    // 定义方法
    @Bean
    public MyLogFunction squareFunction() {

        return new MyLogFunction() {
            @Override
            public String getName() {
                return "pow";
            }

            @Override
            public String apply(Object o) {
                String s = String.valueOf(o);
                int i = Integer.parseInt(s);
                return String.valueOf(i * i);
            }
        };
    }

    // 使用
    @GetMapping("/test/{num}")
    @MyLog(value = "'call method pow and result is: ' + #pow(#num)")
    public String test(@PathVariable("num") Integer num) {
        return "success " + num;
    }
    ```
3. 可自定义记录日志的方法, 实现 `MyLogRecordService` 接口并装配到 Spring 中
4. 支持自定义属性, 使用 `MyLogContext.put(String key, Object value)` 方法即可
