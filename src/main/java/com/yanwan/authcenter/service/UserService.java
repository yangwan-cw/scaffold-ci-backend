package com.yanwan.authcenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanwan.authcenter.dto.request.*;
import com.yanwan.authcenter.dto.response.LoginResponse;
import com.yanwan.authcenter.dto.response.TokenResponse;
import com.yanwan.authcenter.entity.User;

import javax.validation.Valid;


/**
 * 用户服务接口
 * 提供用户认证、登录、注册、令牌管理等核心功能
 *
 * @author yanwan
 * @since 2025-11-25
 */
public interface UserService extends IService<User> {


    /**
     * 自动登录
     * 使用刷新令牌自动登录，无需再次输入密码或验证码
     *
     * @param request 自动登录请求，包含刷新令牌
     * @return 登录响应，包含新的访问令牌、刷新令牌和用户信息
     * @throws IllegalArgumentException 当刷新令牌无效或已过期时
     */
    LoginResponse autoLogin(@Valid AutoLoginRequest request);

    /**
     * 用户注册
     * 注册新用户账号，需要手机号验证码验证
     *
     * @param request 注册请求，包含手机号、验证码、密码和昵称
     * @throws IllegalArgumentException 当手机号已存在或验证码错误时
     */
    void register(@Valid RegisterRequest request);

    /**
     * 记住密码
     * 保存用户的密码凭证，用于下次自动登录
     *
     * @param request 记住密码请求，包含是否记住和密码凭证
     * @throws IllegalArgumentException 当用户未登录时
     */
    void rememberPassword(@Valid RememberPasswordRequest request);

    /**
     * 找回密码
     * 通过手机号验证码重置密码
     *
     * @param request 找回密码请求，包含手机号、验证码和新密码
     * @throws IllegalArgumentException 当手机号不存在或验证码错误时
     */
    void recoverPassword(@Valid RecoverPasswordRequest request);

    /**
     * 获取令牌列表
     * 获取当前用户的所有登录令牌信息，包括设备、IP、创建时间等
     *
     * @return 令牌响应，包含当前令牌和所有令牌列表
     * @throws IllegalArgumentException 当用户未登录时
     */
    TokenResponse getTokenList();

    /**
     * 刷新令牌
     * 使用刷新令牌获取新的访问令牌，延长登录状态
     *
     * @param request 刷新令牌请求，包含刷新令牌
     * @return 登录响应，包含新的访问令牌和刷新令牌
     * @throws IllegalArgumentException 当刷新令牌无效或已过期时
     */
    LoginResponse refreshToken(@Valid RefreshTokenRequest request);

    /**
     * 撤销令牌
     * 撤销指定的访问令牌，使其立即失效
     * 用于退出其他设备的登录或移除可疑登录
     *
     * @param tokenId 令牌ID
     * @throws IllegalArgumentException 当令牌ID不存在或不属于当前用户时
     */
    void revokeToken(String tokenId);

    /**
     * 退出登录
     * 退出当前登录状态，撤销当前访问令牌
     *
     * @throws IllegalArgumentException 当用户未登录时
     */
    void logout();

    /**
     * 切换账户
     *
     * @param request 切换账户请求，包含目标账户信息
     * @return 登录响应，包含新的访问令牌和刷新令牌
     */
    LoginResponse switchAccount(@Valid SwitchAccountRequest request);

    /**
     * 获取账户列表
     *
     * @return 账户列表对象
     */
    Object getAccountList();


    /**
     * 三方登录
     *
     * @param request 三方登录请求类
     * @return 返回登陆后的结果
     */
    LoginResponse thirdLogin(@Valid ThirdLoginRequest request);
}
