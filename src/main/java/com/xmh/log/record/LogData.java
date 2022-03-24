package com.xmh.log.record;

import lombok.Getter;
import lombok.Setter;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:35 PM
 */
@Getter
@Setter
public class LogData {

    private String record;
    private boolean success;
    private Object result;
    private Throwable error;
}
