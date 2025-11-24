package com.yanwan.authcenter.commmon.exception;

import com.yanwan.authcenter.commmon.result.ResultCode;
import lombok.Getter;

/**
 * 认证异常类
 *
 * @author yanwan
 */
@Getter
public class AuthException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    public AuthException() {
        super();
    }

    public AuthException(String message) {
        super(message);
        this.code = ResultCode.AUTH_ERROR.getCode();
        this.message = message;
    }

    public AuthException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public AuthException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public AuthException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}