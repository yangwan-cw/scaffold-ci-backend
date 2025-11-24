package com.yanwan.authcenter.commmon.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回码枚举
 *
 * @author yanwan
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    // ==================== 通用返回码 ====================
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),

    // ==================== 参数错误 4xx ====================
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    VALIDATE_FAILED(422, "参数校验失败"),

    // ==================== 服务器错误 5xx ====================
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务暂不可用"),

    // ==================== 业务错误 1xxx ====================
    BUSINESS_ERROR(1000, "业务处理失败"),
    DATA_NOT_EXIST(1001, "数据不存在"),
    DATA_ALREADY_EXIST(1002, "数据已存在"),
    DATA_ERROR(1003, "数据异常"),
    OPERATION_FAILED(1004, "操作失败"),

    // ==================== 认证错误 2xxx ====================
    AUTH_ERROR(2000, "认证失败"),
    TOKEN_INVALID(2001, "Token无效"),
    TOKEN_EXPIRED(2002, "Token已过期"),
    TOKEN_MISSING(2003, "Token缺失"),
    USERNAME_OR_PASSWORD_ERROR(2004, "用户名或密码错误"),
    USER_NOT_EXIST(2005, "用户不存在"),
    USER_DISABLED(2006, "用户已被禁用"),
    USER_LOCKED(2007, "用户已被锁定"),
    PASSWORD_ERROR(2008, "密码错误"),
    OLD_PASSWORD_ERROR(2009, "原密码错误"),
    CAPTCHA_ERROR(2010, "验证码错误"),
    CAPTCHA_EXPIRED(2011, "验证码已过期"),

    // ==================== 权限错误 3xxx ====================
    PERMISSION_DENIED(3000, "权限不足"),
    ROLE_NOT_EXIST(3001, "角色不存在"),
    PERMISSION_NOT_EXIST(3002, "权限不存在"),
    USER_NO_ROLE(3003, "用户未分配角色"),
    USER_NO_PERMISSION(3004, "用户未分配权限"),

    // ==================== 第三方登录错误 4xxx ====================
    OAUTH_ERROR(4000, "第三方登录失败"),
    OAUTH_PLATFORM_NOT_SUPPORT(4001, "不支持的第三方平台"),
    OAUTH_CODE_ERROR(4002, "授权码错误"),
    OAUTH_STATE_ERROR(4003, "State参数错误"),
    OAUTH_USER_INFO_ERROR(4004, "获取用户信息失败"),

    // ==================== 限流错误 5xxx ====================
    RATE_LIMIT(5000, "请求过于频繁，请稍后再试"),
    IP_BLOCKED(5001, "IP已被封禁"),

    // ==================== 数据库错误 6xxx ====================
    DB_ERROR(6000, "数据库操作失败"),
    DB_INSERT_ERROR(6001, "数据插入失败"),
    DB_UPDATE_ERROR(6002, "数据更新失败"),
    DB_DELETE_ERROR(6003, "数据删除失败"),
    DB_QUERY_ERROR(6004, "数据查询失败"),

    // ==================== 文件错误 7xxx ====================
    FILE_ERROR(7000, "文件操作失败"),
    FILE_UPLOAD_ERROR(7001, "文件上传失败"),
    FILE_DOWNLOAD_ERROR(7002, "文件下载失败"),
    FILE_DELETE_ERROR(7003, "文件删除失败"),
    FILE_TYPE_ERROR(7004, "文件类型不支持"),
    FILE_SIZE_EXCEED(7005, "文件大小超出限制"),

    // ==================== 第三方服务错误 8xxx ====================
    THIRD_PARTY_ERROR(8000, "第三方服务调用失败"),
    SMS_SEND_ERROR(8001, "短信发送失败"),
    EMAIL_SEND_ERROR(8002, "邮件发送失败"),
    REDIS_ERROR(8003, "Redis操作失败"),
    ;

    /**
     * 返回码
     */
    private final Integer code;

    /**
     * 返回消息
     */
    private final String message;
}