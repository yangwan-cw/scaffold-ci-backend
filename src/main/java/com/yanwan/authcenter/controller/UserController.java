package com.yanwan.authcenter.controller;


import com.yanwan.authcenter.commmon.result.Result;
import com.yanwan.authcenter.dto.request.*;
import com.yanwan.authcenter.dto.response.LoginResponse;
import com.yanwan.authcenter.dto.response.TokenResponse;
import com.yanwan.authcenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "用户管理接口")
@RestController("/apis/user")
@Slf4j
@AllArgsConstructor
public class UserController {


    private final UserService userService;


    @ApiOperation(value = "微信登录", notes = "使用微信授权码进行登录")
    @PostMapping("/third/login")
    public Result<LoginResponse> thirdLogin(
            @ApiParam(value = "微信登录请求", required = true)
            @Valid @RequestBody ThirdLoginRequest request) {
        log.info("三方登录: {}", request);
        LoginResponse response = userService.thirdLogin(request);
        return Result.success(response);
    }

    @ApiOperation(value = "自动登录", notes = "使用刷新令牌自动登录")
    @PostMapping("/login/auto")
    public Result<LoginResponse> autoLogin(
            @ApiParam(value = "自动登录请求", required = true)
            @Valid @RequestBody AutoLoginRequest request) {
        log.info("自动登录");
        LoginResponse response = userService.autoLogin(request);
        return Result.success(response);
    }

    // ==================== 注册相关 ====================

    @ApiOperation(value = "用户注册", notes = "注册新用户账号")
    @PostMapping("/register")
    public Result<Void> register(
            @ApiParam(value = "注册请求", required = true)
            @Valid @RequestBody RegisterRequest request) {
        log.info("用户注册: {}", request.getPhone());
        userService.register(request);
        return Result.success();
    }

    @ApiOperation(value = "用户列表", notes = "分页查询用户列表")
    @PostMapping("/list")
    public Result<?> list() {
        return Result.success(userService.list());
    }

    // ==================== 密码相关 ====================

    @ApiOperation(value = "记住密码", notes = "保存用户密码凭证（用于自动登录）")
    @PostMapping("/password/remember")
    public Result<Void> rememberPassword(
            @ApiParam(value = "记住密码请求", required = true)
            @Valid @RequestBody RememberPasswordRequest request) {
        log.info("记住密码");
        userService.rememberPassword(request);
        return Result.success();
    }

    @ApiOperation(value = "找回密码", notes = "通过验证码重置密码")
    @PostMapping("/password/recover")
    public Result<Void> recoverPassword(
            @ApiParam(value = "找回密码请求", required = true)
            @Valid @RequestBody RecoverPasswordRequest request) {
        log.info("找回密码: {}", request.getPhone());
        userService.recoverPassword(request);
        return Result.success();
    }

    // ==================== 令牌管理 ====================

    @ApiOperation(value = "令牌管理", notes = "获取用户的所有令牌信息")
    @GetMapping("/token/list")
    public Result<TokenResponse> getTokenList() {
        log.info("获取令牌列表");
        TokenResponse response = userService.getTokenList();
        return Result.success(response);
    }

    @ApiOperation(value = "刷新令牌", notes = "使用刷新令牌获取新的访问令牌")
    @PostMapping("/token/refresh")
    public Result<LoginResponse> refreshToken(
            @ApiParam(value = "刷新令牌请求", required = true)
            @Valid @RequestBody RefreshTokenRequest request) {
        log.info("刷新令牌");
        LoginResponse response = userService.refreshToken(request);
        return Result.success(response);
    }

    @ApiOperation(value = "撤销令牌", notes = "撤销指定的访问令牌")
    @DeleteMapping("/token/revoke")
    public Result<Void> revokeToken(
            @ApiParam(value = "令牌ID", required = true)
            @RequestParam String tokenId) {
        log.info("撤销令牌: {}", tokenId);
        userService.revokeToken(tokenId);
        return Result.success();
    }

    // ==================== 多账号切换 ====================

    @ApiOperation(value = "多账号切换", notes = "切换到指定的登录账号")
    @PostMapping("/account/switch")
    public Result<LoginResponse> switchAccount(
            @ApiParam(value = "账号切换请求", required = true)
            @Valid @RequestBody SwitchAccountRequest request) {
        log.info("切换账号: {}", request.getAccountId());
        LoginResponse response = userService.switchAccount(request);
        return Result.success(response);
    }

    @ApiOperation(value = "获取账号列表", notes = "获取当前用户绑定的所有账号")
    @GetMapping("/account/list")
    public Result<Object> getAccountList() {
        log.info("获取账号列表");
        Object response = userService.getAccountList();
        return Result.success(response);
    }

    // ==================== 登出 ====================

    @ApiOperation(value = "退出登录", notes = "退出当前登录状态")
    @PostMapping("/logout")
    public Result<Void> logout() {
        log.info("退出登录");
        userService.logout();
        return Result.success();
    }
}
