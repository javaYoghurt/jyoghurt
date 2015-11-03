package com.github.jYoghourt.core.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA. User: metarnet Date: 13-2-26 Time: 下午4:10 基础异常类，其他异常需继承此类
 */
public class BaseException extends Exception {
	private static final long serialVersionUID = 8686960428281101225L;

	protected Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass().getName());
    }


    /**
     * 记录错误日志
     *
     * @param refBizId   业务流水号
     * @param logContent 日志信息
     * @return 日志流水号
     */
    public BaseException(String refBizId, String logContent, Exception e) {
        super();
    }

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);

    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }


}
