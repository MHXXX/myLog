package com.xmh.log.record;

/**
 * .
 *
 * @author 谢明辉
 * @create 2022/3/24 9:22 PM
 */

public class DefaultLogRecordService implements MyLogRecordService {
    @Override
    public void record(LogData log) {
        System.out.println(log.getRecord());
    }
}
