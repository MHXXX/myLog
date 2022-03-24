package com.xmh.log.record;

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
    private String record;
    private String fail;
    private String operator;
    private Long timestamp;

    public String getResult() {
        return success ? record : fail;
    }
}
