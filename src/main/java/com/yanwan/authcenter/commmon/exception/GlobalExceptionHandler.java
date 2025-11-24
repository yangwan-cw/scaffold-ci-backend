package com.yanwan.authcenter.commmon.exception;


import com.yanwan.authcenter.commmon.result.Result;
import com.yanwan.authcenter.commmon.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局异常处理器
 *
 * @author yanwan
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.error("业务异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI(), e);
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理认证异常
     */
    @ExceptionHandler(AuthException.class)
    public Result<?> handleAuthException(AuthException e, HttpServletRequest request) {
        log.error("认证异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI(), e);
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常 (@RequestBody 参数校验)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("参数校验异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI());

        // 获取第一个校验失败的错误信息
        FieldError fieldError = e.getBindingResult().getFieldError();
        String errorMessage = fieldError != null ? fieldError.getDefaultMessage() : "参数校验失败";

        return Result.fail(ResultCode.VALIDATE_FAILED.getCode(), errorMessage);
    }

    /**
     * 处理参数绑定异常 (@ModelAttribute 参数校验)
     */
    @ExceptionHandler(BindException.class)
    public Result<?> handleBindException(BindException e, HttpServletRequest request) {
        log.error("参数绑定异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI());

        // 获取第一个校验失败的错误信息
        FieldError fieldError = e.getBindingResult().getFieldError();
        String errorMessage = fieldError != null ? fieldError.getDefaultMessage() : "参数绑定失败";

        return Result.fail(ResultCode.VALIDATE_FAILED.getCode(), errorMessage);
    }

    /**
     * 处理约束违反异常 (@RequestParam 参数校验)
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<?> handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        log.error("约束违反异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI());

        // 获取第一个校验失败的错误信息
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String errorMessage = violations.isEmpty() ? "参数校验失败" :
                violations.iterator().next().getMessage();

        return Result.fail(ResultCode.VALIDATE_FAILED.getCode(), errorMessage);
    }

    /**
     * 处理参数类型不匹配异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        log.error("参数类型不匹配：{}, 请求路径：{}", e.getMessage(), request.getRequestURI());
        String errorMessage = String.format("参数'%s'类型不匹配", e.getName());
        return Result.fail(ResultCode.BAD_REQUEST.getCode(), errorMessage);
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Result<?> handleNullPointerException(NullPointerException e, HttpServletRequest request) {
        log.error("空指针异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI(), e);
        return Result.fail(ResultCode.INTERNAL_SERVER_ERROR.getCode(), "系统内部错误");
    }

    /**
     * 处理非法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        log.error("非法参数异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI(), e);
        return Result.fail(ResultCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 处理其他未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e, HttpServletRequest request) {
        log.error("系统异常：{}, 请求路径：{}", e.getMessage(), request.getRequestURI(), e);
        return Result.fail(ResultCode.INTERNAL_SERVER_ERROR);
    }
}