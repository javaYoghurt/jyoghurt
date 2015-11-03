package com.github.jYoghourt.core.configuration.impl;

import com.df.core.configuration.PageConvert;
import com.df.core.controller.form.QueryHandle;
import com.df.core.result.EasyUIResult;
import com.df.core.result.QueryResult;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2015/8/28.
 */
public class EasyUIPageService implements Condition,PageConvert {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return PageConvert.EasyUI.equalsIgnoreCase(ResourceBundle.getBundle("environment-config").getString("tableJsLib"));
    }

    @Override
    public void convert(QueryHandle queryHandle, HttpServletRequest request) {

    }

    @Override
    public QueryResult createQueryResult() {
        return new EasyUIResult();
    }
}
