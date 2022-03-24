package com.xmh.log.record;

import lombok.extern.slf4j.Slf4j;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:22 PM
 */

@Slf4j
public class DefaultLogRecordServiceImpl implements MyLogRecordService {
    @Override
    public void record(LogData logData) {
        log.info(logData.getResult());
    }
}
