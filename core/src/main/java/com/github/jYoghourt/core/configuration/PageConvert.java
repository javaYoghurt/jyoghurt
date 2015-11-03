package com.github.jYoghourt.core.configuration;

import com.df.core.controller.form.QueryHandle;
import com.df.core.result.QueryResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/7/21.
 * 翻页信息转换器，前台框架的分页标示不统一，在此做适配
 */
public interface PageConvert {
    String DataTable = "DataTable";
    String EasyUI= "EasyUI";
    String Donkish="Donkish";
     void convert(QueryHandle queryHandle, HttpServletRequest request);

    /**
     * 创建QueryResult
     */
    QueryResult createQueryResult();
}
