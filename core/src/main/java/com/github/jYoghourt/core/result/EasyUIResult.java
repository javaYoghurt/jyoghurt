package com.github.jYoghourt.core.result;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"data","recordsTotal"})
public class EasyUIResult<T> extends QueryResult<T> {
    public List<T> getRows() {
        return super.getData();
    }

    public long getTotal() {
        return super.getRecordsTotal();
    }
}


