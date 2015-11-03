package com.github.jYoghourt.core.controller;


import com.df.core.result.HttpResultEntity;
import com.df.core.result.HttpResultHandle;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 控制器基类
 *
 * @author JiangYingxu
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    static {
        //定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

    }


    /**
     * 返回成功标示
     *
     * @return
     */
    public HttpResultEntity<?> getSuccessResult() {
        return HttpResultHandle.getSuccessResult();
    }

    /**
     * 返回成功标示
     *
     * @return
     */
    public HttpResultEntity<?> getSuccessResult(Object result) {
        return HttpResultHandle.getSuccessResult(result);
    }

    /**
     * 返回成功标示
     *
     * @return
     */
    public static HttpResultEntity<?> getErrorResult() {
        return HttpResultHandle.getErrorResult();
    }


    /**
     * 返回失败标示
     *
     * @return
     */
    public static HttpResultEntity<?> getErrorResult(Object result) {
        return HttpResultHandle.getErrorResult(result);
    }

}
