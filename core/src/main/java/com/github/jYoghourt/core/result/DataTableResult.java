package com.github.jYoghourt.core.result;

public class DataTableResult<T> extends QueryResult<T>{
    /**
     * 请求次数
     */
    private long draw;
    /**
     * 过滤后记录数
     */
    private long recordsFiltered;

    public long getRecordsFiltered() {
        return super.getRecordsTotal();
    }

    public long getDraw() {
        return draw;
    }
}
