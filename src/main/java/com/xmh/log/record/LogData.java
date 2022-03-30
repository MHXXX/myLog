package com.xmh.log.record;

import com.xmh.log.core.MyLog;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:35 PM
 */
@Getter
@Setter
@Accessors(chain = true)
public class LogData {

    private boolean success;
    private String log;
    private String fail;
    private String operator;
    private Long timestamp;
    private Throwable throwable;
    private Object result;
    private MyLog myLog;

    public String getResult() {
        return success ? log : fail;
    }
}
