package com.github.jYoghourt.core.result;

import java.util.List;

/**
 * 查询结果
 *
 * @param <T>
 * @author gaoyufeng
 */
public class QueryResult<T> {

    /**
     * 结果集
     */
    private List<T> data;

    /**
     * 总数
     */
    private long recordsTotal;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
