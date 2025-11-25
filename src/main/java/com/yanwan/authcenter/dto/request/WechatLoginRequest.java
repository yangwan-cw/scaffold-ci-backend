package com.yanwan.authcenter.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 微信登录请求
 */
@Data
@ApiModel(description = "微信登录请求")
public class WechatLoginRequest {

    @ApiModelProperty(value = "微信授权码", required = true, example = "081234567890abcd")
    @NotBlank(message = "授权码不能为空")
    private String code;

    @ApiModelProperty(value = "用户信息（可选）", example = "{\"nickname\":\"张三\",\"avatar\":\"https://...\"}")
    private String userInfo;
}