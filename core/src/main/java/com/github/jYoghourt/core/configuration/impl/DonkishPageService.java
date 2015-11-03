package com.github.jYoghourt.core.configuration.impl;

import com.df.core.configuration.PageConvert;
import com.df.core.controller.form.QueryHandle;
import com.df.core.result.DataTableResult;
import com.df.core.result.QueryResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2015/8/28.
 */
public class DonkishPageService implements Condition,PageConvert {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return PageConvert.Donkish.equalsIgnoreCase(ResourceBundle.getBundle("environment-config").getString("tableJsLib"));
    }

    @Override
    public void convert(QueryHandle queryHandle, HttpServletRequest request) {

        String length = request.getParameter("iDisplayLength");
        if(StringUtils.isNotEmpty(length)){
            queryHandle.setRows(Integer.valueOf(length));
        }
        String start = request.getParameter("iDisplayStart");
        if(StringUtils.isNotEmpty(start)){
            queryHandle.setPage(Integer.valueOf(start)/ queryHandle.getRows()+1);
        }
        //处理排序
        if(StringUtils.isNotEmpty(request.getParameter("iSortCol_0"))&&"true".equals(request.getParameter
                ("bSortable_"+request.getParameter("iSortCol_0")))){
            queryHandle.addOrderBy(request.getParameter("mDataProp_"+request.getParameter("iSortCol_0")),
                    request.getParameter("sSortDir_0"));
        }
    }

    @Override
    public QueryResult createQueryResult() {
        return new DataTableResult();
    }
}
