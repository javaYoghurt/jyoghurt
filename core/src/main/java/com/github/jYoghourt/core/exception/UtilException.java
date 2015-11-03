package com.github.jYoghourt.core.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by IntelliJ IDEA. User: jtwu Date: 12-12-5 Time: 上午10:46 工具类异常
 */
public class UtilException extends BaseException {
	private static final long serialVersionUID = 2244979209286032238L;

	public UtilException() {
        super();
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(Throwable cause) {
        super(StringUtils.EMPTY,cause);
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }
}
