package com.xmh.log.record;

import com.xmh.log.core.MyLog;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author 谢明辉
 * @create 2022/3/24 9:35 PM
 */
@Getter
@Setter
@Accessors(chain = true)
public class LogData {

    /** 操作是否成功 */
    private boolean success;
    /** 操作成功的日志 */
    private String log;
    /** 操作失败的日志 */
    private String fail;
    /** 操作用户 */
    private String operator;
    /** 时间戳 */
    private Long timestamp;
    /** 操作失败抛出的异常 */
    private Throwable throwable;
    /** 操作成功的结果 */
    private Object result;
    /** 注解 */
    private MyLog myLog;

    public String getResult() {
        return success ? log : fail;
    }
}
